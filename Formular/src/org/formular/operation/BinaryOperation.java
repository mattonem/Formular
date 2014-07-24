package org.formular.operation;

import java.util.Collection;
import java.util.LinkedList;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.formular.card.CardElement;
import org.formular.core.Input;

public abstract class BinaryOperation extends Operation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Operation right;
	public Operation left;
	
	public void right(Operation operation2) {
		right = operation2;	
		//TODO lorsqu'on aura des operations avec de veritables noms pour les inputs il faudra supprimer l'autoname 
		this.autoNameInputs();
	}

	public void left(Operation operation1) {
		left = operation1;
		//TODO lorsqu'on aura des operations avec de veritables noms pour les inputs il faudra supprimer l'autoname 
		this.autoNameInputs();
	}

	

	public Operation right(float i, Class<? extends ParameterOperation> class1) {
		
		ParameterOperation newInstance = ParameterOperation.createParameter(i, class1);
		this.right(newInstance);
		return newInstance;
	}

	public Operation left(float i, Class<? extends ParameterOperation> class1) {
		ParameterOperation newInstance = ParameterOperation.createParameter(i, class1);
		this.left(newInstance);
		return newInstance;
	}

	@Override
	public Collection <CardElement> inputDescriptions() {
		return CollectionUtils.collect(inputs(),new Transformer<Input, CardElement>() {
			@Override
			public CardElement transform(Input input) {
				return input.getDesciption();
			}
		});
		
	}
	
	@Override
	public Collection<Input> inputs() {
		Collection<Input> inputs = new LinkedList<Input>();
		if(right != null)
			inputs.addAll(right.inputs());
		if(left != null)
			inputs.addAll(left.inputs());
		return inputs;
	}
}
