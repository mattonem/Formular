package org.formular.core;

public abstract class OperationInteger extends Operation {
	
	public int right;
	public int left;

	public void right(int i) {
		right = i;
		
	}

	public void left(int i) {
		left = i;
		
	}

}