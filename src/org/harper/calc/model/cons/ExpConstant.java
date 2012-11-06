package org.harper.calc.model.cons;

import org.harper.calc.model.Constant;

public class ExpConstant extends Constant {

	public static ExpConstant E = new ExpConstant(null);

	private ExpConstant(Constant coefficient) {
		this.coefficient = coefficient;
	}

	private Constant coefficient;

	public Constant getCoefficient() {
		return coefficient;
	}

	@Override
	public Constant add(Constant i) {
		return null;
	}

	@Override
	public Constant subtract(Constant i) {
		return null;
	}

	@Override
	public Constant multiply(Constant c) {
		return null;
	}

	@Override
	public Constant divide(Constant c) {
		return null;
	}
}
