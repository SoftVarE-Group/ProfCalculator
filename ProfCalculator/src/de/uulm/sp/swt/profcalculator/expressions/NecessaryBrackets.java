package de.uulm.sp.swt.profcalculator.expressions;

public class NecessaryBrackets extends Expression {

	private Expression expression;

	public NecessaryBrackets(Expression expression) {
		this.expression = expression;
	}

	@Override
	public String toString(Expression parent) {
		String childString = expression.toString(parent);
		if ((parent instanceof Multiplication && (expression instanceof Addition || expression instanceof Sub))
				|| (parent instanceof Div && (expression instanceof Addition || expression instanceof Sub))) {
			childString = "(" + childString + ")";
		}
		return childString;
	}

	@Override
	public double evaluate() {
		return expression.evaluate();
	}

}
