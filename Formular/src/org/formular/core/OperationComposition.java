package org.formular.core;

import java.util.Collection;

import org.formular.card.CardElement;

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

	

	public void right(float i) {
		right = new OperationIdentique(i);
		
	}

	public void left(float i) {
		left = new OperationIdentique(i);
		
	}
	
	@Override
	public Collection <CardElement> inputDescriptions() {
		Collection<CardElement> inputDescriptions = right.inputDescriptions();
		inputDescriptions.addAll(left.inputDescriptions());
		return inputDescriptions;
	}
}
