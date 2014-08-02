package org.formular.description;

import java.io.Serializable;


public interface DescriptionElement extends Serializable {

	public void accept(DescripitonVisitor visitor);

}
