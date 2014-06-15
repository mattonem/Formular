package org.formular.test;

import junit.framework.Assert;

import org.formular.core.Operation;
import org.formular.core.Somme;
import org.formular.core.Soustraction;

import android.test.AndroidTestCase;

public class FormularTests extends AndroidTestCase {
	
	public void testSomme12() {
		Operation operation = new Somme();
		operation.right(1);
		operation.left(2);
		Assert.assertEquals(3, operation.result());
	}
	
	public void testSomme13() {
		Operation operation = new Somme();
		operation.right(1);
		operation.left(3);
		Assert.assertEquals(4, operation.result());
	}
	
	public void testSoustraction13() {
		Operation operation = new Soustraction();
		operation.right(1);
		operation.left(3);
		Assert.assertEquals(2, operation.result());
	}
	
	public void testComposition() {
		Operation composition = new Soustraction();
		Operation operation1 = new Soustraction();
		operation1.right(1);
		operation1.left(3);
		composition.left(operation1);
		composition.right(3);
		Assert.assertEquals(-1, composition.result());
	}
	
	public void testComposition2() {
		Operation composition = new Somme();
		Operation operation1 = new Somme();
		operation1.right(2);
		operation1.left(3);
		composition.left(operation1);
		composition.right(2);
		Assert.assertEquals(7, composition.result());
	}
	
}
