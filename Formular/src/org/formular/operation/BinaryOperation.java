package org.formular.operation;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.formular.card.CardElement;
import org.formular.core.IOperation;
import org.formular.core.Input;

public abstract class BinaryOperation extends MultinaryOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public List<IOperation> getOperands() {
		if (operands == null) {
			operands = new LinkedList<IOperation>();
			operands.add(null);
			operands.add(null);
		}
		return operands;
	}
	
	public IOperation right() {
		try {
			return getOperands().get(1);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
		
	}
	
	public IOperation left() {
		try {
			return getOperands().get(0);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
		
	}
	
	public void right(IOperation operation2) {
		getOperands().set(1, operation2);
		//TODO lorsqu'on aura des operations avec de veritables noms pour les inputs il faudra supprimer l'autoname 
		this.autoNameInputs();
	}

	public void left(IOperation operation1) {
		getOperands().set(0, operation1);
		//TODO lorsqu'on aura des operations avec de veritables noms pour les inputs il faudra supprimer l'autoname 
		this.autoNameInputs();
	}

	

	public IOperation right(Float i, Class<? extends ParameterOperation> class1) {
		
		ParameterOperation newInstance = ParameterOperation.createParameter(i, class1);
		this.right(newInstance);
		return newInstance;
	}

	public IOperation left(Float i, Class<? extends ParameterOperation> class1) {
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
	public void addOperand(IOperation operation) {
		
	}
	
	@Override
	public Collection<Input> inputs() {
		Collection<Input> inputs = new LinkedList<Input>();
		if(right() != null)
			inputs.addAll(right().inputs());
		if(left() != null)
			inputs.addAll(left().inputs());
		return inputs;
	}
	
	public void autoNameInputs() {
		int i = 1;
		for (Input input : this.inputs()) {
			input.setName("input " + i);
			i++;
		}
	};
}
