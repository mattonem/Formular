package org.formular.card;

import org.formular.card.description.CardNumberField;
import org.formular.card.description.CardText;
import org.formular.card.description.CardTitle;


public interface CardElementVisitor {

	void visit(CardTitle cardTitle);

	void visit(CardText cardText);

	void visit(CardNumberField cardNumberField);

}
