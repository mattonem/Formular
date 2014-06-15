package org.formular.core;

public class OperationIdentique extends Operation {
	
	public int value;
	
	public OperationIdentique(int i) {
		value = i;
	}

	@Override
	public int result() {
		return value;
	}

}
