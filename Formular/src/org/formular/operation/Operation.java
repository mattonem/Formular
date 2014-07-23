package org.formular.operation;

import java.io.Serializable;
import java.util.Collection;

import org.formular.card.CardElement;

public abstract class Operation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract float result();

	public abstract Collection <CardElement> inputDescriptions();

}