package org.formular.description;

import org.formular.description.concrete.CardField;
import org.formular.description.concrete.CardText;
import org.formular.description.concrete.CardTitle;



public interface CardElementVisitor {

	void visit(CardTitle cardTitle);

	void visit(CardText cardText);

	void visit(CardField cardNumberField);

}
