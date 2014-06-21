package org.formular.core;

public class Soustraction extends OperationComposition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public float result() {
		return left.result() - right.result();
	}

}
