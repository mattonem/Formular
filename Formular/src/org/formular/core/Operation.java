package org.formular.core;

import java.io.Serializable;
import java.util.Collection;

import org.formular.card.CardElement;

public interface Operation extends Serializable {
	
	
	public abstract float result();
	
	
	public abstract Collection <CardElement> inputDescriptions();
	
	public abstract Collection<Input> inputs();
	
	
	

}
