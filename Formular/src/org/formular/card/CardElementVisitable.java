package org.formular.card;

public interface CardElementVisitable {
	
	public void accept(CardElementVisitor visitor);
}
