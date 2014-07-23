package org.formular.operation;

import java.io.Serializable;
import java.util.Collection;

import org.formular.card.CardElement;
import org.formular.core.Input;

public abstract class Operation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public abstract float result();
	
	
	public abstract Collection <CardElement> inputDescriptions();
	
	public abstract Collection<Input> inputs();
	
	public void autoNameInputs() {
		int i = 1;
		for (Input input : this.inputs()) {
			input.setName("input " + i);
			i++;
		}
	};
	

}
