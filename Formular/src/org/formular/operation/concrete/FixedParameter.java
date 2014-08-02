package org.formular.operation.concrete;

import java.util.LinkedList;
import java.util.List;

import org.formular.core.Input;
import org.formular.operation.ParameterOperation;

public class FixedParameter extends ParameterOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	@Override
	public List<Input> inputs() {
		return new LinkedList<Input>();
	}

}
