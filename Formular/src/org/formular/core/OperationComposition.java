package org.formular.core;

public abstract class OperationComposition extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Operation right;
	public Operation left;
	
	public void right(Operation operation2) {
		right = operation2;	
	}

	public void left(Operation operation1) {
		left = operation1;
		
	}

	

	public void right(int i) {
		right = new OperationIdentique(i);
		
	}

	public void left(int i) {
		left = new OperationIdentique(i);
		
	}
}
