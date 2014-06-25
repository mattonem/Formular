package org.formular.card.description;

import org.formular.card.CardElement;
import org.formular.card.CardElementVisitor;


public class CardTitle extends CardElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;

	public CardTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public void accept(CardElementVisitor visitor) {
		visitor.visit(this);
	}

}
