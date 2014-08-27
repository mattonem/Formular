package org.formular.operation.concrete;

import org.formular.operation.AOperationException;
import org.formular.operation.BinaryOperation;

public class Multiplication extends BinaryOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Float result() throws AOperationException {
		
		return right.result() * left.result();
	}

}
