package org.formular.card.description;

import org.formular.card.CardElement;
import org.formular.card.CardElementVisitor;
import org.formular.core.Input;
import org.formular.core.InputController;
import org.formular.core.UserParameter;

import android.text.InputType;

public class CardField extends CardElement implements InputController {

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
		return Float.toString(operation.getVal());
	}

	public int getType() {
		return InputType.TYPE_NULL;
	}

	@Override
	public void accept(CardElementVisitor visitor) {
		visitor.visit(this);
	}


}
