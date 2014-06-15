package org.formular.test;

import org.formular.core.Operation;
import org.formular.core.Somme;
import org.formular.core.Soustraction;

import junit.framework.Assert;
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
}
