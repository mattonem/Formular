package org.formular.operation.exception;

import org.formular.operation.AOperationException;
import org.formular.operation.ParameterOperation;


public class MissingArgument extends AOperationException {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ParameterOperation input;

	public MissingArgument(ParameterOperation input) {
		this.setInput(input);
	}

	public ParameterOperation getInput() {
		return input;
	}

	public void setInput(ParameterOperation input) {
		this.input = input;
	}

}
