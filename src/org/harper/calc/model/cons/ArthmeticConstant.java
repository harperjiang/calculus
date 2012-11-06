package org.harper.calc.model.cons;

import org.harper.calc.model.Constant;
import org.harper.calc.model.func.Operator;

public class ArthmeticConstant extends Constant {

	private Constant left;

	private Operator operator;

	private Constant right;

	public ArthmeticConstant(Constant left, Operator operator, Constant right) {
		this.left = left;
		this.operator = operator;
		this.right = right;
	}

	@Override
	public Constant add(Constant i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Constant subtract(Constant i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Constant multiply(Constant c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Constant divide(Constant c) {
		// TODO Auto-generated method stub
		return null;
	}

}
