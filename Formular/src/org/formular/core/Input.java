package org.formular.core;

import org.formular.description.DescriptionElement;

public interface Input<T> {
	public void setVal(T i);
	public T getVal();
	public void setName(String name);
	public String getName();
	public DescriptionElement getDesciption();
}
