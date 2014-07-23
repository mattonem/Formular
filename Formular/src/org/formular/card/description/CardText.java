package org.formular.card.description;

import org.formular.card.CardElement;
import org.formular.card.CardElementVisitor;
import org.formular.operation.Operation;


public class CardText extends CardElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Operation operation;

	public CardText(Operation operation) {
		this.operation = operation;
	}

	public CharSequence getText() {
		return ""+operation.result();
	}

	@Override
	public void accept(CardElementVisitor visitor) {
		visitor.visit(this);
	}

}
