package org.formular.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.formular.core.IOperation;
import org.formular.operation.AOperationException;
import org.formular.operation.BinaryOperation;
import org.formular.operation.UnaryOperation;
import org.formular.operation.concrete.Division;
import org.formular.operation.concrete.FixedParameter;
import org.formular.operation.concrete.Multiplication;
import org.formular.operation.concrete.Puissance2;
import org.formular.operation.concrete.PuissanceN;
import org.formular.operation.concrete.Somme;
import org.formular.operation.concrete.Soustraction;
import org.formular.operation.exception.DivideByZero;

public class OperationTests extends TestCase {
	
	public void testSomme12() {
		BinaryOperation<?,Float> operation = new Somme();
		operation.right(1f, FixedParameter.class);
		operation.left(2f, FixedParameter.class);
		assertResult(operation, 3f);
	}

	
	
	public void testSomme13() {
		BinaryOperation<?,Float> operation = new Somme();
		operation.right(1f, FixedParameter.class);
		operation.left(3f, FixedParameter.class);
		this.assertResult(operation, 4f);
	}
	
	public void testSoustraction13() {
		BinaryOperation<?,Float> operation = new Soustraction();
		operation.right(1f, FixedParameter.class);
		operation.left(3f, FixedParameter.class);
		this.assertResult(operation, 2f);
	}
	
	public void testComposition() {
		BinaryOperation<Float,Float> composition = new Soustraction();
		BinaryOperation<?,Float> operation1 = new Soustraction();
		operation1.right(1f, FixedParameter.class);
		operation1.left(3f, FixedParameter.class);
		composition.left(operation1);
		composition.right(3f, FixedParameter.class);
		this.assertResult(composition, -1f);
	}
	
	public void testComposition2() {
		BinaryOperation<Float,Float> composition = new Somme();
		BinaryOperation<?,Float> operation1 = new Somme();
		operation1.right(2f, FixedParameter.class);
		operation1.left(3f, FixedParameter.class);
		composition.left(operation1);
		composition.right(2f, FixedParameter.class);
		this.assertResult(composition, 7f);
	}
	
	public void testMultiplication() {
		 BinaryOperation<?,Float> operation = new Multiplication();
		 operation.right(5f, FixedParameter.class);
		 operation.left(2f , FixedParameter.class);
		 this.assertResult(operation, 10f);
	}
	
	public void testDivision() {
		BinaryOperation<?,Float> operation = new Division();
		operation.left(4f, FixedParameter.class);
		operation.right(2f, FixedParameter.class);
		this.assertResult(operation,2f);
	}
	
	public void testDivision2() {
		BinaryOperation<?,Float> operation = new Division();
		operation.left(4f, FixedParameter.class);
		operation.right(0f, FixedParameter.class);
		try {
			operation.result();
		} 	catch (DivideByZero e) {
			return;
		}
			catch (AOperationException e) {
			Assert.fail("Je veux une exception plus precise");
			return;
		}
		
		Assert.fail("Diviser par zero ne devrait pas etre possible");
	}
	
	protected void assertResult(IOperation<?,Float> operation, Float expected) {
		try {
			Assert.assertEquals(expected, operation.result());
		} catch (AOperationException e) {
			Assert.fail("should not raise exception");
		}
	}
	
	
	
	public void testPuissance2() {
		 UnaryOperation<?,Float> operation = new Puissance2();
		 operation.operand(5f, FixedParameter.class);
		 this.assertResult(operation, 25f);
	}	

	public void testPuissanceN() {
		 BinaryOperation<?,Float> operation = new PuissanceN();
		 operation.right(3f, FixedParameter.class);
		 operation.left(4f , FixedParameter.class);
		 this.assertResult(operation, 64f);
	}
}
