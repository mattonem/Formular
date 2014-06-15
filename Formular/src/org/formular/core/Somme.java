package org.formular.core;

public class Somme extends OperationComposition {

	@Override
	public int result() {
		return right.result() + left.result();
	}

}
