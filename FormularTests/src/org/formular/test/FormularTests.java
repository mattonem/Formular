package org.formular.test;

import junit.framework.Assert;

import org.formular.operation.AOperationException;
import org.formular.operation.BinaryOperation;
import org.formular.operation.concrete.Division;
import org.formular.operation.concrete.FixedParameter;
import org.formular.operation.concrete.Multiplication;
import org.formular.operation.concrete.Somme;
import org.formular.operation.concrete.Soustraction;
import org.formular.operation.exception.DivideByZero;

import android.test.AndroidTestCase;

public class FormularTests extends AndroidTestCase {
	
	public void testSomme12() {
		BinaryOperation operation = new Somme();
		operation.right(1f, FixedParameter.class);
		operation.left(2f, FixedParameter.class);
		assertResult(operation, 3f);
	}

	
	
	public void testSomme13() {
		BinaryOperation operation = new Somme();
		operation.right(1f, FixedParameter.class);
		operation.left(3f, FixedParameter.class);
		this.assertResult(operation, 4f);
	}
	
	public void testSoustraction13() {
		BinaryOperation operation = new Soustraction();
		operation.right(1f, FixedParameter.class);
		operation.left(3f, FixedParameter.class);
		this.assertResult(operation, 2f);
	}
	
	public void testComposition() {
		BinaryOperation composition = new Soustraction();
		BinaryOperation operation1 = new Soustraction();
		operation1.right(1f, FixedParameter.class);
		operation1.left(3f, FixedParameter.class);
		composition.left(operation1);
		composition.right(3f, FixedParameter.class);
		this.assertResult(composition, -1f);
	}
	
	public void testComposition2() {
		BinaryOperation composition = new Somme();
		BinaryOperation operation1 = new Somme();
		operation1.right(2f, FixedParameter.class);
		operation1.left(3f, FixedParameter.class);
		composition.left(operation1);
		composition.right(2f, FixedParameter.class);
		this.assertResult(composition, 7f);
	}
	
	public void testMultiplication() {
		 BinaryOperation operation = new Multiplication();
		 operation.right(5f, FixedParameter.class);
		 operation.left(2f , FixedParameter.class);
		 this.assertResult(operation, 10f);
	}
	
	public void testDivision() {
		BinaryOperation operation = new Division();
		operation.left(4f, FixedParameter.class);
		operation.right(2f, FixedParameter.class);
		this.assertResult(operation,2f);
	}
	
	public void testDivision2() {
		BinaryOperation operation = new Division();
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
	
	protected void assertResult(BinaryOperation operation, Float expected) {
		try {
			Assert.assertEquals(expected, operation.result());
		} catch (AOperationException e) {
			Assert.fail("should not raise exception");
		}
	}
	
	
}
