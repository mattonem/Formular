package org.formular.core;

import java.util.Collection;
import java.util.LinkedList;

import org.formular.card.CardElement;

public class OperationParameter extends ValueOperation {

	public OperationParameter(float value) {
		super(value);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Collection<CardElement> inputDescriptions() {
		return new LinkedList<CardElement>();
	}

}
