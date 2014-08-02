package org.formular.core;

import java.io.Serializable;
import java.util.Collection;

import org.formular.card.CardElement;
import org.formular.operation.AOperationException;

public interface IOperation extends Serializable {
	
	
	public abstract float result() throws AOperationException;
	
	public String getName();
	public void setName(String name);
	
	public void addOperand(IOperation operation);
	
	public IOperation getRoot();
	
	public int getId();
	
	public void setId(int id);
	
	public Collection <CardElement> inputDescriptions();
	
	public Collection<Input> inputs();

	public abstract void setParent(IOperation parent);

	public abstract IOperation getParent();
	
	
	

}
