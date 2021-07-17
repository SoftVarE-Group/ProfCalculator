package de.uulm.sp.swt.profcalculator.expressions;

public class Evaluate extends Expression {

	private Expression expression;
	
	public Evaluate(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public String toString(Expression parent) {
		String childString = expression.toString(parent);
		if (parent instanceof Multiplication && (expression instanceof Addition || expression instanceof Subtraction)) {
			childString = String.valueOf(evaluate());
		}
		return childString;
	}

	@Override
	public int evaluate() {
		return expression.evaluate();
	}

}
