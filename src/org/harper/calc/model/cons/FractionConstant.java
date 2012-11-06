package org.harper.calc.model.cons;

import org.harper.calc.model.Constant;

public class FractionConstant extends Constant {

	private Constant numerator;

	private Constant denominator;

	protected FractionConstant(Integer numerator, Integer denominator) {
		this.numerator = new IntegerConstant(numerator);
		this.denominator = new IntegerConstant(denominator);
	}

	public FractionConstant(Constant numerator, Constant denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Constant getNumerator() {
		return numerator;
	}

	public void setNumerator(Constant numerator) {
		this.numerator = numerator;
	}

	public Constant getDenominator() {
		return denominator;
	}

	public void setDenominator(Constant denominator) {
		this.denominator = denominator;
	}

	public static Constant construct(Integer n, Integer d) {
		return construct(new IntegerConstant(n), new IntegerConstant(d));
	}

	public static Constant construct(Constant n, Constant d) {
		if (n instanceof IntegerConstant && d instanceof IntegerConstant) {
			IntegerConstant in = (IntegerConstant) n;
			IntegerConstant id = (IntegerConstant) d;
			if (in.getValue() % id.getValue() == 0)
				return IntegerConstant.construct(in.getValue() / id.getValue());
		}
		return new FractionConstant(n, d);
	}

	@Override
	public Constant add(Constant i) {
		return construct(
				this.getNumerator().add(i.multiply(this.getDenominator())),
				this.denominator);
	}

	@Override
	public Constant subtract(Constant i) {
		return construct(
				this.getNumerator().subtract(i.multiply(this.getDenominator())),
				this.getDenominator());
	}

	@Override
	public Constant multiply(Constant c) {
		return construct(this.getNumerator().multiply(c), this.getDenominator());
	}

	@Override
	public Constant divide(Constant c) {
		return construct(this.getNumerator(), this.getDenominator().multiply(c));
	}

}
