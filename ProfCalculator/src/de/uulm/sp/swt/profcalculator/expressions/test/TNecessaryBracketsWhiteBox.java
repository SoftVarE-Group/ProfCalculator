package de.uulm.sp.swt.profcalculator.expressions.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.uulm.sp.swt.profcalculator.expressions.Addition;
import de.uulm.sp.swt.profcalculator.expressions.Expression;
import de.uulm.sp.swt.profcalculator.expressions.Multiplication;
import de.uulm.sp.swt.profcalculator.expressions.NecessaryBrackets;
import de.uulm.sp.swt.profcalculator.expressions.Sub;
import de.uulm.sp.swt.profcalculator.expressions.Value;

class TNecessaryBracketsWhiteBox {

	@Test
	void testAdditionWithinMultiplication() {
		Expression child = new Addition(new Value(1), new Value(2));
		Expression brackets = new NecessaryBrackets(child);
		Expression parent = new Multiplication(brackets, new Value(3));
		assertEquals(parent.toString(), "(1 + 2) * 3");
	}

	@Test
	void testMultiplicationWithinAddition() {
		Expression child = new Multiplication(new Value(1), new Value(2));
		Expression brackets = new NecessaryBrackets(child);
		Expression parent = new Addition(brackets, new Value(3));
		assertEquals(parent.toString(), "1 * 2 + 3");
	}

	@Test
	void testMultiplicationWithinMultiplication() {
		Expression child = new Multiplication(new Value(1), new Value(2));
		Expression brackets = new NecessaryBrackets(child);
		Expression parent = new Multiplication(brackets, new Value(3));
		assertEquals(parent.toString(), "1 * 2 * 3");
	}

	@Test
	void testSubtractionWithinMultiplication() {
		Expression child = new Sub(new Value(1), new Value(2));
		Expression brackets = new NecessaryBrackets(child);
		Expression parent = new Multiplication(brackets, new Value(3));
		assertEquals(parent.toString(), "(1 - 2) * 3");
	}

	@Test
	void testMultiplicationWithinSubtraction() {
		Expression child = new Multiplication(new Value(1), new Value(2));
		Expression brackets = new NecessaryBrackets(child);
		Expression parent = new Sub(brackets, new Value(3));
		assertEquals(parent.toString(), "1 * 2 - 3");
	}
}
