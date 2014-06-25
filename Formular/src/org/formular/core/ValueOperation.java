package org.formular.core;


public abstract class ValueOperation extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public float value;


	public ValueOperation(float value) {
		super();
		this.value = value;
	}

	@Override
	public float result() {
		return value;
	}

}
