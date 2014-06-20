package org.formular.core;

import java.util.Collection;
import java.util.LinkedList;

import org.formular.card.CardElement;
import org.formular.card.CardNumberField;

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

	@Override
	public Collection<CardElement> inputDescriptions() {
		
		Collection<CardElement> inputDescriptions = new LinkedList<CardElement>();
		CardNumberField cardNumberField = new CardNumberField();
		cardNumberField.label("input");
		inputDescriptions.add(cardNumberField);
		return inputDescriptions ;
	}

}
