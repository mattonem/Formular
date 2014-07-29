package org.formular.card;

import java.io.Serializable;


public interface CardElement extends Serializable {

	public void accept(CardElementVisitor visitor);

}
