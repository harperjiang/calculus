package org.harper.calc.eval;

import org.harper.calc.model.Constant;
import org.harper.calc.model.Differentiation;
import org.harper.calc.model.Function;
import org.harper.calc.model.Variable;
import org.harper.calc.model.cons.IntegerConstant;
import org.harper.calc.model.func.ArithmeticFunction;
import org.harper.calc.model.func.BasicFunction;
import org.harper.calc.model.func.BasicFunctionType;
import org.harper.calc.model.func.Operator;
import org.harper.calc.model.func.PowerFunction;

public class DifferentiationEvaluator {

	public Function evaluate(Differentiation data) {

		Function base = data.getFunction();

		if (base instanceof ArithmeticFunction) {
			ArithmeticFunction arith = (ArithmeticFunction) base;
			Function udv = Cleaner.clean(new ArithmeticFunction(
					evaluate(new Differentiation(arith.getRight(), data
							.getVariable())), Operator.MUL, arith.getLeft()));
			Function vdu = Cleaner.clean(new ArithmeticFunction(arith
					.getRight(), Operator.MUL, evaluate(new Differentiation(
					arith.getLeft(), data.getVariable()))));

			switch (arith.getOperator()) {
			case ADD:
			case SUB:
				return Cleaner.clean(new ArithmeticFunction(
						evaluate(new Differentiation(arith.getLeft(), data
								.getVariable())), arith.getOperator(),
						evaluate(new Differentiation(arith.getRight(), data
								.getVariable()))));
			case MUL:
				return Cleaner.clean(new ArithmeticFunction(udv, Operator.ADD,
						vdu));
			case DIV:
				Function uv = new ArithmeticFunction(arith.getLeft(),
						Operator.MUL, arith.getRight());
				return Cleaner.clean(new ArithmeticFunction(
						new ArithmeticFunction(udv, Operator.ADD, vdu),
						Operator.MUL, uv));
			}
		}
		if (base instanceof BasicFunction) {
			BasicFunction bf = (BasicFunction) base;
			Function next = Cleaner.clean(evaluate(new Differentiation(bf
					.getVariable(), data.getVariable())));
			switch (bf.getType()) {
			case SIN:
				return Cleaner.clean(new ArithmeticFunction(new BasicFunction(
						BasicFunctionType.COS, bf.getVariable()), Operator.MUL,
						next));
			case COS:
				return Cleaner.clean(new ArithmeticFunction(null, Operator.SUB,
						new ArithmeticFunction(new BasicFunction(
								BasicFunctionType.SIN, bf.getVariable()),
								Operator.MUL, next)));
			case LN:
				return Cleaner.clean(new ArithmeticFunction(new PowerFunction(
						bf.getVariable(), -1), Operator.MUL, next));
			}
		}
		if (base instanceof PowerFunction) {
			PowerFunction pf = (PowerFunction) base;
			Function next = Cleaner.clean(evaluate(new Differentiation(pf
					.getBase(), data.getVariable())));
			Function newPower = Cleaner.clean(new PowerFunction(pf.getBase(),
					pf.getPower().subtract(IntegerConstant.ONE)));

			return Cleaner.clean(new ArithmeticFunction(Cleaner
					.clean(new ArithmeticFunction(pf.getPower(), Operator.MUL,
							newPower)), Operator.MUL, next));
		}
		if (base instanceof Constant) {
			return IntegerConstant.ZERO;
		}
		if (base instanceof Variable) {
			Variable v = (Variable) base;
			if (v.getName().equals(data.getVariable().getName()))
				return IntegerConstant.ONE;
			return IntegerConstant.ZERO;
		}
		return null;
	}
}
