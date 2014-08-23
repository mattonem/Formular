package org.formular.operation.concrete;

import org.formular.operation.AOperationException;
import org.formular.operation.BinaryOperator;

public class MoreThan extends BinaryOperator<Float> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Boolean result() throws AOperationException {
		return (left.result() > right.result());
	}

}
