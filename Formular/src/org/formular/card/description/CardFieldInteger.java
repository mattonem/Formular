package org.formular.card.description;

import org.formular.core.OperationIdentique;

import android.text.InputType;

public class CardFieldInteger extends CardField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CardFieldInteger(OperationIdentique operation) {
		super(operation);
	}

	@Override
	public int getType() {
		return InputType.TYPE_CLASS_NUMBER;
	}
}
