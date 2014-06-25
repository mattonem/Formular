package org.formular.card.description;

import org.formular.core.UserValue;

import android.text.InputType;

public class CardFieldFloat extends CardField {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardFieldFloat(UserValue operation) {
		super(operation);
	}

	@Override
	public int getType() {
		return InputType.TYPE_CLASS_NUMBER;
	}
	
	@Override
	public void setVal(String string) {
		try {
			operation.setVal(Float.parseFloat(string));
		} catch (NumberFormatException e) {
			
		}
	}
}
