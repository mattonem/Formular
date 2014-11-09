package org.formular.operation.concrete;

import org.formular.operation.AOperationException;
import org.formular.operation.BinaryOperation;

public class MoreThan extends BinaryOperation<Float, Boolean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Boolean result() throws AOperationException {
		return (left.result() > right.result());
	}

}
