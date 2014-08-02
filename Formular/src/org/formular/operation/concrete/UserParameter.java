package org.formular.operation.concrete;

import java.util.LinkedList;
import java.util.List;

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
	public Float getVal() {
		return value;
	}

	@Override
	public void setVal(float i) {
		value = i;
	}

	@Override
	public List<CardElement> inputDescriptions() {
		
		List<CardElement> inputDescriptions = new LinkedList<CardElement>();
		
		inputDescriptions.add(getDesciption());
		return inputDescriptions ;
	}
	
	@Override
	public List<Input> inputs() {
		List<Input> inputs = new LinkedList<Input>();
		inputs.add(this);
		return inputs;
	}

	@Override
	public CardElement getDesciption() {
		CardField cardNumberField = new CardFieldFloat(this);
		cardNumberField.setLabel(this.name);
		return cardNumberField;
	}

}
