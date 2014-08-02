package org.formular.operation.concrete;

import org.formular.operation.AOperationException;
import org.formular.operation.BinaryOperation;
import org.formular.operation.exception.DivideByZero;

public class Division extends BinaryOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public float result() throws AOperationException {
		if (right.result() == 0f) {
			throw new DivideByZero();
		}
		return left.result()/right.result();
	}

}