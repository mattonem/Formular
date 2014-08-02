package org.formular.description;

import org.formular.description.concrete.TextDescription;
import org.formular.description.concrete.TitleDescription;



public interface DescripitonVisitor {

	void visit(TitleDescription cardTitle);

	void visit(TextDescription cardText);

	void visit(FieldDescription cardNumberField);

}
