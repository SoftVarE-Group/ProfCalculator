package de.uulm.sp.swt.profcalculator.expressions;

public class Subtraction extends Expression{
	
	public Expression left;
	public Expression right;
	
	public Subtraction(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int evaluate() {
		return left.evaluate() - right.evaluate();
	}

	@Override
	public String toString(Expression parent) {
		// TODO Auto-generated method stub
		return left.toString(this) + "-" + right.toString(this);
	}

}
