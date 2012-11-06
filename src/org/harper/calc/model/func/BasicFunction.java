package org.harper.calc.model.func;

import org.harper.calc.model.Function;

public class BasicFunction extends Function {

	private BasicFunctionType type;

	private Function variable;

	public BasicFunction(BasicFunctionType type, Function variable) {
		this.type = type;
		this.variable = variable;
	}

	public BasicFunctionType getType() {
		return type;
	}

	public void setType(BasicFunctionType type) {
		this.type = type;
	}

	public Function getVariable() {
		return variable;
	}

	public void setVariable(Function variable) {
		this.variable = variable;
	}

}
