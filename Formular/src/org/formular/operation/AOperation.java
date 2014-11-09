package org.formular.operation;

import org.formular.core.IOperation;

import android.os.Bundle;


public abstract class AOperation<I,O> implements IOperation<I,O> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public String name;
	private int id;
	private IOperation<O,?> parent;

	@Override
	public void initalizeWith(Bundle bundle) {
		name = bundle.getString("name");
		try {
			id = Integer.valueOf(bundle.getInt("id"));
		} catch (NullPointerException e) {
			id = 0;
		}
		
	}
	
	@Override
	public void setParent(IOperation<?,?> parent) {
		this.parent = (IOperation<O, ?>) parent;
	}
	
	@Override
	public IOperation<?,?> getParent() {
		return (parent == null )? this : parent;
	}
	
	@Override
	public IOperation<?,?> getRoot() {
		return (getParent() == this ) ? this : getParent().getRoot();
	}

	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public int getId() {
		return id;
	}


}
