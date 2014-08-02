package org.formular.description;

import org.formular.core.Input;
import org.formular.core.InputController;
import org.formular.operation.concrete.UserParameter;

import android.text.InputType;

public abstract class FieldDescription implements DescriptionElement, InputController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	protected Input operation;

	public FieldDescription(UserParameter operation) {
		this.operation = operation;
	}

	public Input getOperation() {
		return operation;
	}

	public void setOperation(Input operation) {
		this.operation = operation;
	}

	public void setLabel(String label) {
		this.label = label;
		
	}
	
	public String getLabel() {
		return label;
	}

	@Override
	public void setVal(String string) {
		
		
	}

	@Override
	public String getVal() {
		Float val = operation.getVal();
		return (val != null) ? val.toString() : ""; 
	}

	public int getType() {
		return InputType.TYPE_NULL;
	}

	@Override
	public void accept(DescripitonVisitor visitor) {
		visitor.visit(this);
	}


}
