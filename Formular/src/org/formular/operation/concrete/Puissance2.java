package org.formular.operation.concrete;

import org.formular.operation.AOperationException;
import org.formular.operation.UnaryOperation;

public class Puissance2 extends UnaryOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Float result() throws AOperationException {
		return operand.result()*operand.result();
	}

}
