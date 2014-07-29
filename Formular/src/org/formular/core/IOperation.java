package org.formular.core;

import java.io.Serializable;
import java.util.Collection;

import org.formular.card.CardElement;

public interface IOperation extends Serializable {
	
	
	public abstract float result() throws AOperationException;
	
	public void addOperand(IOperation operation);
	
	public String getName();
	public void setName(String name);
	
	public int getId();
	
	public void setId(int id);
	
	public Collection <CardElement> inputDescriptions();
	
	public Collection<Input> inputs();
	
	
	

}
