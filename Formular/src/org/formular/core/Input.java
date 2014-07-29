package org.formular.core;

import org.formular.card.CardElement;

public interface Input {
	public void setVal(float i);
	public Float getVal();
	public void setName(String name);
	public String getName();
	public CardElement getDesciption();
}
