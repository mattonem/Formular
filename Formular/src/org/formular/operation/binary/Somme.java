package org.formular.operation.binary;

import org.formular.core.AOperationException;
import org.formular.operation.BinaryOperation;


public class Somme extends BinaryOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public float result() throws AOperationException {
		if(right == null || left == null)
			return 0;
		return right.result() + left.result();
	}

}
