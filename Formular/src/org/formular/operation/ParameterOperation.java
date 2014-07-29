package org.formular.operation;

import java.util.Collection;
import java.util.LinkedList;

import org.formular.card.CardElement;
import org.formular.core.AOperationException;
import org.formular.core.IOperation;
import org.formular.core.MissingArgument;


public abstract class ParameterOperation extends AOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Float value;
	
	
	public ParameterOperation(){}
	
	public float getValue() {
		return value;
	}

	@Override
	public Collection<CardElement> inputDescriptions() {
		return new LinkedList<CardElement>();
	}

	public void setValue(Float value) {
		this.value = value;
	}
	

	@Override
	public float result() throws AOperationException {
		if(value == null) 
			throw new MissingArgument(this);
		return value;
	}

	@Override
	public void addOperand(IOperation operation) {
			
	}

	public static ParameterOperation createParameter(Float i, Class<? extends ParameterOperation> class1) {
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
