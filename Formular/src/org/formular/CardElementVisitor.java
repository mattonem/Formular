package org.formular;

public interface CardElementVisitor {

	void visit(CardTitle cardTitle);

	void visit(CardText cardText);

	void visit(CardNumberField cardNumberField);

}
