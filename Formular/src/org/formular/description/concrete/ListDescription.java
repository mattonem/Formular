package org.formular.description.concrete;

import java.util.Iterator;
import java.util.List;

import org.formular.core.InputController;
import org.formular.core.UserListOperation;
import org.formular.description.DescripitonVisitor;
import org.formular.description.DescriptionElement;

public class ListDescription implements DescriptionElement, InputController{

	private UserListOperation<?> operation;
	
	public ListDescription(UserListOperation<?> simpleParameterList) {
		operation = simpleParameterList;
	}

	@Override
	public void setVal(String i) {
		operation.select(Integer.getInteger(i));
	}

	@Override
	public String getVal() {
		return operation.selected().toString();
	}

	@Override
	public void accept(DescripitonVisitor visitor) {
		visitor.visit(this);
	}

	public UserListOperation<?> getOperation() {
		return operation;
	}

	public void setOperation(UserListOperation<?> operation) {
		this.operation = operation;
	}
	
	public Float[] getList(){
		Float[] array = new Float[operation.size()];
		return operation.getList().toArray(array);
	}

	public String getLabel() {
		return operation.getName();
	}



}
