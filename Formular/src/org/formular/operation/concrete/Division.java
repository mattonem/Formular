package org.formular.operation.concrete;

import org.formular.operation.AOperationException;
import org.formular.operation.BinaryOperation;
import org.formular.operation.exception.DivideByZero;

public class Division extends BinaryOperation<Float,Float> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Float result() throws AOperationException {
		if (right.result() == 0f) {
			throw new DivideByZero();
		}
		return left.result()/right.result();
	}

}
