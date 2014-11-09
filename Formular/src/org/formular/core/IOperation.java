package org.formular.core;

import java.io.Serializable;
import java.util.List;

import org.formular.description.DescriptionElement;
import org.formular.operation.AOperationException;

import android.os.Bundle;

public interface IOperation<I,O> extends Serializable {
	
	
	public abstract void initalizeWith(Bundle bundle);

	public int getId();

	public void setId(int id);

	public String getName();

	public void setName(String name);

	public IOperation<?,?> getRoot();

	public abstract IOperation<?, ?> getParent();

	public abstract void setParent(IOperation<?,?> parent);

	public void addOperand(IOperation<?,?> operation);

	public abstract O result() throws AOperationException;
	
	public List<Input> inputs();

	public List <DescriptionElement> inputDescriptions();

	
	
	

}
