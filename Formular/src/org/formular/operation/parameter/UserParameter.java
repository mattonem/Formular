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
	private String name;
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
		cardNumberField.setLabel(this.name);
		inputDescriptions.add(cardNumberField);
		return inputDescriptions ;
	}
	
	@Override
	public Collection<Input> inputs() {
		Collection<Input> inputs = new LinkedList<Input>();
		inputs.add(this);
		return inputs;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public String getName() {
		return name;
	}

}
