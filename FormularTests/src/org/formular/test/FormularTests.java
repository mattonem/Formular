package org.formular.test;

import junit.framework.Assert;

import org.formular.core.AOperationException;
import org.formular.operation.BinaryOperation;
import org.formular.operation.binary.Somme;
import org.formular.operation.binary.Soustraction;
import org.formular.operation.parameter.FixedParameter;

import android.test.AndroidTestCase;

public class FormularTests extends AndroidTestCase {
	
	public void testSomme12() {
		BinaryOperation operation = new Somme();
		operation.right(1f, FixedParameter.class);
		operation.left(2f, FixedParameter.class);
		try {
			Assert.assertEquals(3f, operation.result());
		} catch (AOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testSomme13() {
		BinaryOperation operation = new Somme();
		operation.right(1f, FixedParameter.class);
		operation.left(3f, FixedParameter.class);
		try {
			Assert.assertEquals(4f, operation.result());
		} catch (AOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testSoustraction13() {
		BinaryOperation operation = new Soustraction();
		operation.right(1f, FixedParameter.class);
		operation.left(3f, FixedParameter.class);
		try {
			Assert.assertEquals(2f, operation.result());
		} catch (AOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testComposition() {
		BinaryOperation composition = new Soustraction();
		BinaryOperation operation1 = new Soustraction();
		operation1.right(1f, FixedParameter.class);
		operation1.left(3f, FixedParameter.class);
		composition.left(operation1);
		composition.right(3f, FixedParameter.class);
		try {
			Assert.assertEquals(-1f, composition.result());
		} catch (AOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testComposition2() {
		BinaryOperation composition = new Somme();
		BinaryOperation operation1 = new Somme();
		operation1.right(2f, FixedParameter.class);
		operation1.left(3f, FixedParameter.class);
		composition.left(operation1);
		composition.right(2f, FixedParameter.class);
		try {
			Assert.assertEquals(7f, composition.result());
		} catch (AOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
