package de.uulm.sp.swt.profcalculator.expressions;

public class Sub extends Expression {
	
	public Expression left;
	public Expression right;

	public Sub(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	public String toString(Expression parent) {
		return left.toString(this) + " - " + right.toString(this);
	}

	public double evaluate() {
		return left.evaluate() - right.evaluate();
	}
	
}
