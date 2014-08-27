package org.formular.description.concrete;

import org.formular.description.DescriptionElement;
import org.formular.description.DescripitonVisitor;



public class TitleDescription implements DescriptionElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String title;

	public TitleDescription(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	public void accept(DescripitonVisitor visitor) {
		visitor.visit(this);
	}

}
