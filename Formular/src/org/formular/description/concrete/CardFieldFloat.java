package org.formular.description.concrete;

import org.formular.operation.concrete.UserParameter;

import android.text.InputType;

public class CardFieldFloat extends CardField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
