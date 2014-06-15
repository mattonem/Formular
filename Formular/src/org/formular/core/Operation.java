package org.formular.core;

public abstract class Operation {
	
	public Operation right;
	public Operation left;
	
	public void right(OperationInteger operation2) {
		right = operation2;	
	}

	public void left(Operation operation1) {
		left = operation1;
		
	}

	public abstract int result();

	public void right(int i) {
		right = new OperationIdentique(i);
		
	}

	public void left(int i) {
		left = new OperationIdentique(i);
		
	}

}
