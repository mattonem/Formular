package org.formular.card.description;

import org.formular.card.CardElement;
import org.formular.card.CardElementVisitor;


public class CardText extends CardElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CharSequence text;

	public CardText(String text) {
		this.text = text;
	}

	@Override
	public void accept(CardElementVisitor visitor) {
		visitor.visit(this);
	}

	public CharSequence getText() {
		return text;
	}

}
