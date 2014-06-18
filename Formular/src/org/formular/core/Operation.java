package org.formular.core;

import java.io.Serializable;
import java.util.Collection;

import org.formular.CardElement;

public abstract class Operation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract int result();

	public abstract Collection <CardElement> inputDescriptions();

}
