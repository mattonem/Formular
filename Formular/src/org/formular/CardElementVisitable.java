package org.formular;

public interface CardElementVisitable {
	
	public void accept(CardElementVisitor visitor);
}
