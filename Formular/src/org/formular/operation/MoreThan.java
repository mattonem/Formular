package org.formular.operation;

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
