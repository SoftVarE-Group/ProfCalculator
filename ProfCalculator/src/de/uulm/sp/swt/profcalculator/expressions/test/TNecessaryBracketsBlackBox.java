package de.uulm.sp.swt.profcalculator.expressions.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import de.uulm.sp.swt.profcalculator.expressions.Addition;
import de.uulm.sp.swt.profcalculator.expressions.Expression;
import de.uulm.sp.swt.profcalculator.expressions.Multiplication;
import de.uulm.sp.swt.profcalculator.expressions.NecessaryBrackets;
import de.uulm.sp.swt.profcalculator.expressions.Sub;
import de.uulm.sp.swt.profcalculator.expressions.Value;

class TNecessaryBracketsBlackBox {

	Expression value = new NecessaryBrackets(new Value(1));
	Expression add = new NecessaryBrackets(new Addition(value, value));
	Expression sub = new NecessaryBrackets(new Sub(value, value));
	Expression mult = new NecessaryBrackets(new Multiplication(value, value));
	Expression addSub = new NecessaryBrackets(new Addition(sub, value)); // 1-1+1
	
	@Test
	void testNoBrackets() {
		assertEquals("1 + 1 * 1", new Addition(value, mult).toString());
		assertEquals("1 - 1 * 1", new Sub(value, mult).toString());
		assertEquals("1 - 1 + 1 * 1", new Addition(sub, mult).toString());
	}
	
	@Test
	void testBracketsLeft() {
		assertEquals("(1 + 1) * 1", new Multiplication(add, value).toString());
		assertEquals("(1 - 1) * 1", new Multiplication(sub, value).toString());
		assertEquals("(1 - 1 + 1) * 1", new Multiplication(addSub, value).toString());
	}
	
	@Test
	void testBracketsRight() {
		assertEquals("1 * (1 + 1)", new Multiplication(value, add).toString());
		assertEquals("1 * (1 - 1)", new Multiplication(value, sub).toString());
		assertEquals("1 * (1 - 1 + 1)", new Multiplication(value, addSub).toString());
	}
	
	@Test
	void testBracketsLeftAndRight() {
		assertEquals("(1 + 1) * (1 + 1)", new Multiplication(add, add).toString());
		assertEquals("(1 - 1) * (1 - 1)", new Multiplication(sub, sub).toString());
		assertEquals("(1 - 1 + 1) * (1 - 1)", new Multiplication(addSub, sub).toString());
		assertEquals("(1 - 1) * (1 - 1 + 1)", new Multiplication(sub, addSub).toString());
		assertEquals("(1 - 1 + 1) * (1 - 1 + 1)", new Multiplication(addSub, addSub).toString());
	}

}
