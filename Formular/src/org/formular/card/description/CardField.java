package org.formular.card.description;

import org.formular.card.CardElement;
import org.formular.card.CardElementVisitor;
import org.formular.core.Input;
import org.formular.core.InputController;
import org.formular.core.OperationIdentique;

import android.text.InputType;

public class CardField extends CardElement implements InputController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;
	private Input operation;

	public Input getOperation() {
		return operation;
	}

	public void setOperation(Input operation) {
		this.operation = operation;
	}

	public CardField(OperationIdentique operation) {
		this.operation = operation;
	}

	@Override
	public void accept(CardElementVisitor visitor) {
		visitor.visit(this);
	}

	public void label(String label) {
		this.label = label;
		
	}
	
	public String getLabel() {
		return label;
	}

	@Override
	public void setVal(String string) {
		try {
			operation.setVal(Integer.parseInt(string));
		} catch (NumberFormatException e) {
			
		}
		
	}

	@Override
	public String getVal() {
		return Integer.toString(operation.getVal());
	}

	public int getType() {
		return InputType.TYPE_NULL;
	}


}
