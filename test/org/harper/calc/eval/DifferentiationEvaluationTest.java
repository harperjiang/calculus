package org.harper.calc.eval;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.harper.calc.model.Differentiation;
import org.harper.calc.model.Function;
import org.harper.calc.model.Variable;
import org.harper.calc.model.cons.FractionConstant;
import org.harper.calc.model.cons.IntegerConstant;
import org.harper.calc.model.func.ArithmeticFunction;
import org.harper.calc.model.func.PowerFunction;
import org.junit.Test;

public class DifferentiationEvaluationTest {

	@Test
	public void testBasicEvaluate() {
		Variable x = new Variable("x");
		Differentiation d = new Differentiation(x, new Variable("x"));

		Function result = new DifferentiationEvaluator().evaluate(d);

		assertEquals(result, IntegerConstant.ONE);
	}

	@Test
	public void testPowerEvaluate() {
		Variable x = new Variable("x");
		Differentiation d = new Differentiation(new PowerFunction(x, 2),
				new Variable("x"));

		Function result = new DifferentiationEvaluator().evaluate(d);

		assertTrue(result instanceof ArithmeticFunction);
		ArithmeticFunction af = (ArithmeticFunction) result;

		assertTrue(af.getLeft() instanceof IntegerConstant);
		assertTrue(af.getRight() instanceof Variable);
		assertEquals(((IntegerConstant) af.getLeft()).getValue().intValue(), 2);
		assertEquals(((Variable) af.getRight()).getName(), "x");

		d = new Differentiation(new PowerFunction(x, 5), new Variable("x"));

		result = new DifferentiationEvaluator().evaluate(d);

		assertTrue(result instanceof ArithmeticFunction);
		af = (ArithmeticFunction) result;

		assertTrue(af.getLeft() instanceof IntegerConstant);
		assertTrue(af.getRight() instanceof PowerFunction);
		assertEquals(((IntegerConstant) af.getLeft()).getValue().intValue(), 5);
		PowerFunction subp = (PowerFunction) af.getRight();
		assertTrue(subp.getBase() instanceof Variable);
		assertEquals(((Variable) subp.getBase()).getName(), "x");
		assertEquals(((IntegerConstant) subp.getPower()).getValue(),
				new Integer(4));

		d = new Differentiation(new PowerFunction(x,
				FractionConstant.construct(5, 4)), new Variable("x"));

		result = new DifferentiationEvaluator().evaluate(d);

		assertTrue(result instanceof ArithmeticFunction);
		af = (ArithmeticFunction) result;

		assertTrue(af.getLeft() instanceof FractionConstant);
		assertTrue(af.getRight() instanceof PowerFunction);
		FractionConstant coe = (FractionConstant) af.getLeft();
		assertEquals(((IntegerConstant) coe.getNumerator()).getValue(),
				new Integer(5));
		assertEquals(((IntegerConstant) coe.getDenominator()).getValue(),
				new Integer(4));
		subp = (PowerFunction) af.getRight();
		assertTrue(subp.getBase() instanceof Variable);
		assertEquals(((Variable) subp.getBase()).getName(), "x");

		FractionConstant coe2 = (FractionConstant) subp.getPower();
		assertEquals(((IntegerConstant) coe2.getNumerator()).getValue(),
				new Integer(1));
		assertEquals(((IntegerConstant) coe2.getDenominator()).getValue(),
				new Integer(4));
	}

	@Test
	public void testExponetEvaluate() {
		
	}
}
