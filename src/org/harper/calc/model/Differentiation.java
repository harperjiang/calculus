package org.harper.calc.model;

public class Differentiation extends Function {

	private Function function;

	private Variable variable;

	public Differentiation() {
	}

	public Differentiation(Function function, Variable variable) {
		this.function = function;
		this.variable = variable;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

}
