package org.formular.core;


public abstract class ValueOperation extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public float value;
	public ValueOperation(){}
	
	public float getValue() {
		return value;
	}



	public void setValue(float value) {
		this.value = value;
	}



	public ValueOperation(float value) {
		super();
		this.value = value;
	}
	
	

	@Override
	public float result() {
		return value;
	}

	public static ValueOperation createParameter(float i, Class<?> class1) {
		ValueOperation newInstance = null;
		try {
			newInstance = (ValueOperation) class1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		newInstance.setValue(i);
		return newInstance;
	}

}
