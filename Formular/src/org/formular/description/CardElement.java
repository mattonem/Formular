package org.formular.description;

import java.io.Serializable;


public interface CardElement extends Serializable {

	public void accept(CardElementVisitor visitor);

}
