package org.formular.card.description;

import org.formular.operation.parameter.UserParameter;

import android.text.InputType;

public class CardFieldFloat extends CardField {

	public CardFieldFloat(UserParameter operation) {
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
