package org.formular.core;


public abstract class AOperation implements IOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String name;
	private int id;
	
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
