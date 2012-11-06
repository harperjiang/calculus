package org.harper.calc.model;

public class Integration extends Function {

	private Function function;

	private Function variable;

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Function getVariable() {
		return variable;
	}

	public void setVariable(Function variable) {
		this.variable = variable;
	}

}
