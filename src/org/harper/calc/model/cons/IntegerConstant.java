package org.harper.calc.model.cons;

import org.harper.calc.model.Constant;
import org.harper.calc.model.func.Operator;

public class IntegerConstant extends Constant {

	private Integer value;

	public static IntegerConstant ZERO = new IntegerConstant(0);

	public static IntegerConstant ONE = new IntegerConstant(1);

	protected IntegerConstant(Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Constant construct(int intValue) {
		if (intValue == 1)
			return IntegerConstant.ONE;
		if (intValue == 0)
			return IntegerConstant.ZERO;
		return new IntegerConstant(intValue);
	}

	@Override
	public Constant add(Constant i) {
		if (i instanceof IntegerConstant) {
			return construct(getValue() + ((IntegerConstant) i).getValue());

		} else
			return i.add(this);
	}

	@Override
	public Constant subtract(Constant i) {
		if (i instanceof IntegerConstant)
			return construct(getValue() - ((IntegerConstant) i).getValue());
		return new ArthmeticConstant(null, Operator.SUB, i.subtract(this));
	}

	@Override
	public Constant multiply(Constant c) {
		if (c instanceof IntegerConstant)
			return construct(getValue() * ((IntegerConstant) c).getValue());
		return c.multiply(this);
	}

	@Override
	public Constant divide(Constant c) {
		if (c instanceof IntegerConstant) {
			IntegerConstant ic = (IntegerConstant) c;
			if (getValue() % ic.getValue() == 0) {
				return construct(getValue() / ic.getValue());
			} else {
				return new FractionConstant(this, c);
			}
		}
		if (c instanceof FractionConstant) {
			FractionConstant fc = (FractionConstant) c;
			return fc.getDenominator().multiply(this).divide(fc.getNumerator());
		}
		return null;
	}
}
