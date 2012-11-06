package org.harper.calc.eval;

import org.harper.calc.model.Integration;
import org.harper.calc.model.Variable;
import org.harper.calc.model.cons.IntegerConstant;
import org.harper.calc.model.func.ArithmeticFunction;
import org.harper.calc.model.func.Operator;
import org.junit.Test;

public class IntegrationEvaluatorTest {

	@Test
	public void testEvaluate() {

		Variable x = new Variable("x");

		ArithmeticFunction oneoverx = new ArithmeticFunction(new IntegerConstant(1),
				Operator.DIV, x);

		Integration i = new Integration();

		i.setFunction(oneoverx);
		i.setVariable(new Variable("x"));

		new IntegrationEvaluator().evaluate(i);
	}

}
