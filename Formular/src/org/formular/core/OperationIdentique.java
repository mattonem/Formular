package org.formular.core;

import java.util.Collection;
import java.util.LinkedList;

import org.formular.card.CardElement;
import org.formular.card.description.CardField;
import org.formular.card.description.CardFieldFloat;

public class OperationIdentique extends Operation implements Input{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public float value;
	
	public OperationIdentique(float i) {
		value = i;
	}

	@Override
	public float getVal() {
		return value;
	}

	@Override
	public void setVal(float i) {
		value = i;
	}

	@Override
	public float result() {
		return value;
	}

	@Override
	public Collection<CardElement> inputDescriptions() {
		
		Collection<CardElement> inputDescriptions = new LinkedList<CardElement>();
		CardField cardNumberField = new CardFieldFloat(this);
		cardNumberField.label("input");
		inputDescriptions.add(cardNumberField);
		return inputDescriptions ;
	}

}
