package org.formular.operation.binary;

import org.formular.core.AOperationException;
import org.formular.operation.BinaryOperation;

public class Multiplication extends BinaryOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public float result() throws AOperationException {
		
		return right.result() * left.result();
	}

}
