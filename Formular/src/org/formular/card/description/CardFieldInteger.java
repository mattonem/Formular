package org.formular.card.description;

import org.formular.core.UserParameter;

import android.text.InputType;

public class CardFieldInteger extends CardField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardFieldInteger(UserParameter operation) {
		super(operation);
	}

	@Override
	public int getType() {
		return InputType.TYPE_CLASS_NUMBER;
	}
	
	@Override
	public void setVal(String string) {
		try {
			operation.setVal(Integer.parseInt(string));
		} catch (NumberFormatException e) {
			
		}
	}
}
