package org.formular.operation.concrete;

import java.util.Collection;
import java.util.LinkedList;

import org.formular.core.Input;
import org.formular.description.CardElement;
import org.formular.description.concrete.CardField;
import org.formular.description.concrete.CardFieldFloat;
import org.formular.operation.ParameterOperation;

public class UserParameter extends ParameterOperation implements Input{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	@Override
	public Float getVal() {
		return value;
	}

	@Override
	public void setVal(float i) {
		value = i;
	}

	@Override
	public Collection<CardElement> inputDescriptions() {
		
		Collection<CardElement> inputDescriptions = new LinkedList<CardElement>();
		
		inputDescriptions.add(getDesciption());
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

	@Override
	public CardElement getDesciption() {
		CardField cardNumberField = new CardFieldFloat(this);
		cardNumberField.setLabel(this.name);
		return cardNumberField;
	}

}
