package org.harper.calc.eval;

import org.harper.calc.model.Constant;
import org.harper.calc.model.Function;
import org.harper.calc.model.cons.IntegerConstant;
import org.harper.calc.model.func.ArithmeticFunction;
import org.harper.calc.model.func.Operator;
import org.harper.calc.model.func.PowerFunction;

public class Cleaner {

	public static Function clean(Function function) {
		if (function instanceof ArithmeticFunction) {
			ArithmeticFunction arith = (ArithmeticFunction) function;

			// Calculate the result
			if (arith.getLeft() instanceof Constant
					&& arith.getRight() instanceof Constant) {

			}

			// Swap constants and variables
			if (arith.getRight() instanceof Constant
					&& !(arith.getLeft() instanceof Constant)
					&& arith.getOperator() == Operator.MUL) {
				Function left = arith.getLeft();
				arith.setLeft(arith.getRight());
				arith.setRight(left);
			}

			// Remove unnecessary steps
			if (arith.getLeft() == IntegerConstant.ZERO
					&& arith.getOperator() == Operator.ADD)
				return arith.getRight();
			if (arith.getRight() == IntegerConstant.ZERO
					&& (arith.getOperator() == Operator.ADD || arith
							.getOperator() == Operator.SUB))
				return arith.getLeft();
			if (arith.getLeft() == IntegerConstant.ONE
					&& arith.getOperator() == Operator.MUL)
				return arith.getRight();
			if (arith.getRight() == IntegerConstant.ONE
					&& (arith.getOperator() == Operator.MUL || arith
							.getOperator() == Operator.DIV))
				return arith.getLeft();
		}

		if (function instanceof PowerFunction) {
			PowerFunction pf = (PowerFunction) function;
			if (pf.getPower().equals(IntegerConstant.ONE))
				return pf.getBase();
		}

		return function;
	}
}
