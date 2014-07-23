package org.formular.operation.parameter;

import java.util.Collection;
import java.util.LinkedList;

import org.formular.card.CardElement;
import org.formular.card.description.CardField;
import org.formular.card.description.CardFieldFloat;
import org.formular.core.Input;
import org.formular.operation.ParameterOperation;

public class UserParameter extends ParameterOperation implements Input{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public float getVal() {
		return value;
	}

	@Override
	public void setVal(float i) {
		value = i;
	}

	@Override
	public Collection<CardElement> inputDescriptions() {
		
		Collection<CardElement> inputDescriptions = new LinkedList<CardElement>();
		CardField cardNumberField = new CardFieldFloat(this);
		cardNumberField.setLabel("input");
		inputDescriptions.add(cardNumberField);
		return inputDescriptions ;
	}

}