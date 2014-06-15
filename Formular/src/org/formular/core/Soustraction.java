package org.formular.core;

public class Soustraction extends OperationComposition {

	@Override
	public int result() {
		return left.result() - right.result();
	}

}
