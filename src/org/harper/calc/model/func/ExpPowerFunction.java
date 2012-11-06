package org.harper.calc.model.func;

import org.harper.calc.model.Function;

public class ExpPowerFunction extends Function {

	private Function power;

	public ExpPowerFunction(Function power) {
		super();
		this.power = power;
	}

	public Function getPower() {
		return power;
	}

}
