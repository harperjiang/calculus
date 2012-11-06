package org.harper.calc.model;


public abstract class Constant extends Function {

	public abstract Constant add(Constant i);

	public abstract Constant subtract(Constant i);

	public abstract Constant multiply(Constant c);

	public abstract Constant divide(Constant c);

}
