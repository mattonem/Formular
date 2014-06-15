package org.formular.core;

public class Somme extends Operation {

	@Override
	public int result() {
		return right.result() + left.result();
	}

}
