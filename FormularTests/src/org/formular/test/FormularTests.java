package org.formular.test;

import junit.framework.Assert;

import org.formular.core.FixedParameter;
import org.formular.core.OperationComposition;
import org.formular.core.Somme;
import org.formular.core.Soustraction;

import android.test.AndroidTestCase;

public class FormularTests extends AndroidTestCase {
	
	public void testSomme12() {
		OperationComposition operation = new Somme();
		operation.right(1f, FixedParameter.class);
		operation.left(2f, FixedParameter.class);
		Assert.assertEquals(3f, operation.result());
	}
	
	public void testSomme13() {
		OperationComposition operation = new Somme();
		operation.right(1f, FixedParameter.class);
		operation.left(3f, FixedParameter.class);
		Assert.assertEquals(4f, operation.result());
	}
	
	public void testSoustraction13() {
		OperationComposition operation = new Soustraction();
		operation.right(1f, FixedParameter.class);
		operation.left(3f, FixedParameter.class);
		Assert.assertEquals(2f, operation.result());
	}
	
	public void testComposition() {
		OperationComposition composition = new Soustraction();
		OperationComposition operation1 = new Soustraction();
		operation1.right(1f, FixedParameter.class);
		operation1.left(3f, FixedParameter.class);
		composition.left(operation1);
		composition.right(3f, FixedParameter.class);
		Assert.assertEquals(-1f, composition.result());
	}
	
	public void testComposition2() {
		OperationComposition composition = new Somme();
		OperationComposition operation1 = new Somme();
		operation1.right(2f, FixedParameter.class);
		operation1.left(3f, FixedParameter.class);
		composition.left(operation1);
		composition.right(2f, FixedParameter.class);
		Assert.assertEquals(7f, composition.result());
	}
	
	
}
