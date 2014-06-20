package org.formular.card;


public interface CardElementVisitor {

	void visit(CardTitle cardTitle);

	void visit(CardText cardText);

	void visit(CardNumberField cardNumberField);

}
