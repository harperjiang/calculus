package org.harper.calc.model.func;

import org.harper.calc.model.Constant;
import org.harper.calc.model.Function;
import org.harper.calc.model.cons.IntegerConstant;

public class PowerFunction extends Function {

	private Function base;

	private Constant power;

	public PowerFunction(Function base, Integer power) {
		this.base = base;
		this.power = IntegerConstant.construct(power);
	}

	public PowerFunction(Function base, Constant constant) {
		this.base = base;
		this.power = constant;
	}

	public Function getBase() {
		return base;
	}

	public void setBase(Function base) {
		this.base = base;
	}

	public Constant getPower() {
		return power;
	}

	public void setPower(Constant power) {
		this.power = power;
	}

}
