package org.formular.description.concrete;

import org.formular.core.Input;
import org.formular.core.InputController;
import org.formular.description.CardElement;
import org.formular.description.CardElementVisitor;
import org.formular.operation.concrete.UserParameter;

import android.text.InputType;

public class CardField implements CardElement, InputController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	protected Input operation;

	public CardField(UserParameter operation) {
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
	public void accept(CardElementVisitor visitor) {
		visitor.visit(this);
	}


}
