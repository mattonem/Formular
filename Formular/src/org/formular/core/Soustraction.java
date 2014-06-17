package org.formular.core;

public class Soustraction extends OperationComposition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int result() {
		return left.result() - right.result();
	}

}
