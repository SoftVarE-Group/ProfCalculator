package de.uulm.sp.swt.profcalculator.expressions;

public class Div extends Expression {

	public Expression left;
	public Expression right;

	public Div(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public String toString(Expression parent) {
		return left.toString(this) + " / " + right.toString(this);
	}

	public double evaluate() {
		if (right.evaluate() == 0)
			throw new ArithmeticException("Division by zero is not allowed!");
		return left.evaluate() / right.evaluate();
	}

}
