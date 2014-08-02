package org.formular.description.concrete;

import org.formular.description.CardElement;
import org.formular.description.CardElementVisitor;



public class CardTitle implements CardElement {

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
