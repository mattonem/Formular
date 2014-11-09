package org.formular.operation.concrete;

import org.formular.operation.AOperationException;
import org.formular.operation.BinaryOperation;

public class PuissanceN extends BinaryOperation<Float,Float> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Float result() throws AOperationException {
		
		return (float) Math.pow(left.result(), right.result());
	}

}
