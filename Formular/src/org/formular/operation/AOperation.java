package org.formular.operation;

import org.formular.core.IOperation;


public abstract class AOperation implements IOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public String name;
	private int id;
	private IOperation parent;

	@Override
	public void setParent(IOperation parent) {
		this.parent = parent;
	}
	
	@Override
	public IOperation getParent() {
		return (parent == null )? this : parent;
	}
	
	@Override
	public IOperation getRoot() {
		return (getParent() == this ) ? this : getParent().getRoot();
	}

	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
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
