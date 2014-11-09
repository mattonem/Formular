package org.formular.operation.concrete;

import org.formular.operation.AOperationException;
import org.formular.operation.BinaryOperation;


public class Somme extends BinaryOperation<Float,Float> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public Float result() throws AOperationException {
		if(right == null || left == null)
			return 0f;
		return right.result() + left.result();
	}

}
