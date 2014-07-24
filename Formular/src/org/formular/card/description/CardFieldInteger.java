package org.formular.card.description;

import org.formular.operation.parameter.UserParameter;

import android.text.InputType;

public class CardFieldInteger extends CardField {

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
