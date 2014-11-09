package org.formular.operation.concrete;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import org.formular.core.Input;
import org.formular.core.ParameterList;
import org.formular.core.UserListOperation;
import org.formular.description.DescriptionElement;
import org.formular.description.FieldDescription;
import org.formular.description.concrete.FieldFloatDescription;
import org.formular.description.concrete.ListDescription;
import org.formular.operation.AOperationException;
import org.formular.operation.ParameterOperation;

public class SimpleParameterList extends ParameterOperation<Float> implements UserListOperation<Float> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Hashtable<Integer, Float> table;

	private Integer selected;
	
	@Override
	public List<DescriptionElement> inputDescriptions() {
		
		List<DescriptionElement> inputDescriptions = new LinkedList<DescriptionElement>();
		
		inputDescriptions.add(getDesciption());
		return inputDescriptions ;
	}
	
	public SimpleParameterList() {
		table = new Hashtable<Integer, Float>();
		selected = 0;
	}
	
	@Override
	public Float result() throws AOperationException {
		return table.get(selected);
	}

	@Override
	public void addItem(Integer i, Float f) {
		table.put(i, f);
	}

	@Override
	public int size() {
		return table.size();
	}

	@Override
	public void select(Integer i) {
		selected = i;
	}

	@Override
	public List<Input> inputs() {
		List<Input> list = new LinkedList<Input>();
		list.add(this);
		return list;
	}

	@Override
	public void setVal(Integer i) {
		this.select(i);
	}

	@Override
	public Integer getVal() {
		return selected;
	}

	@Override
	public DescriptionElement getDesciption() {
		ListDescription cardListDescription = new ListDescription(this);
		return cardListDescription;
	}

	@Override
	public Integer selected() {
		return selected;
	}

	@Override
	public List<?> getList() {
		return new ArrayList<Float>(table.values());
	}

	

	

}
