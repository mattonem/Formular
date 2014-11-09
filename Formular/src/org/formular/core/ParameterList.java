package org.formular.core;

public interface ParameterList<O> extends IOperation<O, O>{

	void addItem(Integer i, O f);

	int size();

	void select(Integer i);
	
}
