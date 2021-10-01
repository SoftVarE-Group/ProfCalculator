package de.uulm.sp.swt.profcalculator.expressions;

public class Value extends Expression {

	protected Double value;

	public Value(double value) {
		this.value = value;
	}

	public String toString(Expression parent) {
		return value.toString();
	}

	@Override
	public double evaluate() {
		return value;
	}

}
