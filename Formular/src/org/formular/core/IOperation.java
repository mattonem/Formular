package org.formular.core;

import java.io.Serializable;
import java.util.List;

import org.formular.description.DescriptionElement;
import org.formular.operation.AOperationException;

import android.os.Bundle;

public interface IOperation<O> extends Serializable {
	
	
	public abstract O result() throws AOperationException;
	
	public String getName();
	public void setName(String name);
	
	public void addOperand(IOperation<?> operation);
	
	public IOperation<?> getRoot();
	
	public int getId();
	
	public void setId(int id);
	
	public List <DescriptionElement> inputDescriptions();
	
	public List<Input> inputs();

	public abstract void setParent(IOperation<?> parent);

	public abstract IOperation<?> getParent();

	public abstract void initalizeWith(Bundle bundle);
	
	
	

}
