package org.formular.core;

import java.util.Collection;
import java.util.LinkedList;

import org.formular.card.CardElement;

public class FixedParameter extends ValueOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FixedParameter(float value) {
		super(value);
	}

	@Override
	public Collection<CardElement> inputDescriptions() {
		return new LinkedList<CardElement>();
	}

}
