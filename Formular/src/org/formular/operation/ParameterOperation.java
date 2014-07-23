package org.formular.operation;


public abstract class ParameterOperation extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public float value;
	public ParameterOperation(){}
	
	public float getValue() {
		return value;
	}



	public void setValue(float value) {
		this.value = value;
	}



	public ParameterOperation(float value) {
		super();
		this.value = value;
	}
	
	

	@Override
	public float result() {
		return value;
	}

	public static ParameterOperation createParameter(float i, Class<?> class1) {
		ParameterOperation newInstance = null;
		try {
			newInstance = (ParameterOperation) class1.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		newInstance.setValue(i);
		return newInstance;
	}

}
