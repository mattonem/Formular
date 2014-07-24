package org.formular.operation;

import java.util.Collection;
import java.util.LinkedList;

import org.formular.card.CardElement;
import org.formular.core.Operation;


public abstract class ParameterOperation implements Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public float value;
	public ParameterOperation(){}
	
	public float getValue() {
		return value;
	}

	@Override
	public Collection<CardElement> inputDescriptions() {
		return new LinkedList<CardElement>();
	}

	public void setValue(float value) {
		this.value = value;
	}



	public ParameterOperation(float value) {
		super();
		this.value = value;
	}
	
	

	@Override
	public float result() {
		return value;
	}

	public static ParameterOperation createParameter(float i, Class<? extends ParameterOperation> class1) {
		ParameterOperation newInstance = null;
		try {
			newInstance = class1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		newInstance.setValue(i);
		return newInstance;
	}

}
