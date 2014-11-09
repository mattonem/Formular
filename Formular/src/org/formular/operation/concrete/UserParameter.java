package org.formular.operation.concrete;

import java.util.LinkedList;
import java.util.List;

import org.formular.core.Input;
import org.formular.description.DescriptionElement;
import org.formular.description.FieldDescription;
import org.formular.description.concrete.FieldFloatDescription;
import org.formular.operation.ParameterOperation;

public class UserParameter extends ParameterOperation<Float> implements Input<Float>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public Float getVal() {
		return value;
	}

	@Override
	public void setVal(Float i) {
		value = i;
	}

	@Override
	public List<DescriptionElement> inputDescriptions() {
		
		List<DescriptionElement> inputDescriptions = new LinkedList<DescriptionElement>();
		
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
	public DescriptionElement getDesciption() {
		FieldDescription cardNumberField = new FieldFloatDescription(this);
		cardNumberField.setLabel(this.name);
		return cardNumberField;
	}

}
