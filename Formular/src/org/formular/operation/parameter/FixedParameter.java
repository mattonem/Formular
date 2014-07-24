package org.formular.operation.parameter;

import java.util.Collection;
import java.util.LinkedList;

import org.formular.core.Input;
import org.formular.operation.ParameterOperation;

public class FixedParameter extends ParameterOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

	@Override
	public Collection<Input> inputs() {
		return new LinkedList<Input>();
	}

}
