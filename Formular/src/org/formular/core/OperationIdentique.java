package org.formular.core;

public class OperationIdentique extends Operation {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int value;
	
	public OperationIdentique(int i) {
		value = i;
	}

	@Override
	public int result() {
		return value;
	}

}
