package org.formular.card.description;

import org.formular.card.CardElement;
import org.formular.card.CardElementVisitor;
import org.formular.core.Operation;


public class CardText implements CardElement {

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
