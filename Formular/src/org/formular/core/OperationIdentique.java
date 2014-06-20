package org.formular.core;

import java.util.Collection;
import java.util.LinkedList;

import org.formular.card.CardElement;
import org.formular.card.description.CardField;

public class OperationIdentique extends Operation implements Input{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int value;
	
	public OperationIdentique(int i) {
		value = i;
	}

	@Override
	public int getVal() {
		return value;
	}

	@Override
	public void setVal(int i) {
		value = i;
	}

	@Override
	public int result() {
		return value;
	}

	@Override
	public Collection<CardElement> inputDescriptions() {
		
		Collection<CardElement> inputDescriptions = new LinkedList<CardElement>();
		CardField cardNumberField = new CardField(this);
		cardNumberField.label("input");
		inputDescriptions.add(cardNumberField);
		return inputDescriptions ;
	}

}
