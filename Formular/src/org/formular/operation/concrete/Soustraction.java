package org.formular.operation.concrete;

import org.formular.operation.AOperationException;
import org.formular.operation.BinaryOperation;

public class Soustraction extends BinaryOperation<Float,Float> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Float result() throws AOperationException {
		return left.result() - right.result();
	}

}
