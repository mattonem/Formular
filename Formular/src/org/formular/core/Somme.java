package org.formular.core;


public class Somme extends OperationComposition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public float result() {
		if(right == null || left == null)
			return 0;
		return right.result() + left.result();
	}

}
