package org.harper.calc.model.func;

import org.harper.calc.model.Function;

public class ArithmeticFunction extends Function {

	private Function left;

	private Function right;

	private Operator operator;

	public ArithmeticFunction(Function left, Operator opr, Function right) {
		this.left = left;
		this.operator = opr;
		this.right = right;
	}

	public Function getLeft() {
		return left;
	}

	public void setLeft(Function left) {
		this.left = left;
	}

	public Function getRight() {
		return right;
	}

	public void setRight(Function right) {
		this.right = right;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

}
