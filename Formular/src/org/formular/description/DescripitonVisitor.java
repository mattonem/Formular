package org.formular.description;

import org.formular.description.concrete.ListDescription;
import org.formular.description.concrete.TextDescription;
import org.formular.description.concrete.TitleDescription;



public interface DescripitonVisitor {

	void visit(ListDescription listDescription);

	void visit(TextDescription cardText);

	void visit(FieldDescription cardNumberField);

	void visit(TitleDescription titleDescription);

}
