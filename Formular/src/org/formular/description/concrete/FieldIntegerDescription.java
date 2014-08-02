package org.formular.description.concrete;

import org.formular.description.FieldDescription;
import org.formular.operation.concrete.UserParameter;

import android.text.InputType;

public class FieldIntegerDescription extends FieldDescription {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FieldIntegerDescription(UserParameter operation) {
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
