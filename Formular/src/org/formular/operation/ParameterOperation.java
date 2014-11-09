package org.formular.operation;

import java.util.LinkedList;
import java.util.List;

import org.formular.core.IOperation;
import org.formular.description.DescriptionElement;
import org.formular.operation.exception.MissingArgument;

import android.os.Bundle;


public abstract class ParameterOperation<I> extends AOperation<I,I> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public I value;
	
	
	@Override
	public void initalizeWith(Bundle bundle) {
		try {
			value = (I) Float.valueOf(bundle.getString("value"));
		} catch (NullPointerException e) {
			value = null;
		}
		
		super.initalizeWith(bundle);
	}
	
	public ParameterOperation(){}
	
	public I getValue() {
		return value;
	}

	@Override
	public List<DescriptionElement> inputDescriptions() {
		return new LinkedList<DescriptionElement>();
	}

	public void setValue(I value) {
		this.value = value;
	}
	

	@Override
	public I result() throws AOperationException {
		if(value == null) 
			throw new MissingArgument(this);
		return value;
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
	
	@Override
	public void addOperand(IOperation<?,?> operation) {
		//do nothing
	}

}
