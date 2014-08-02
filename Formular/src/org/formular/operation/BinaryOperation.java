package org.formular.operation;

import java.util.Collection;
import java.util.LinkedList;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.formular.core.Input;
import org.formular.core.IOperation;
import org.formular.description.DescriptionElement;

public abstract class BinaryOperation extends AOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IOperation right;
	public IOperation left;
	public void right(IOperation operation2) {
		right = operation2;	
		//TODO lorsqu'on aura des operations avec de veritables noms pour les inputs il faudra supprimer l'autoname 
		this.autoNameInputs();
	}

	public void left(IOperation operation1) {
		left = operation1;
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
	public Collection <DescriptionElement> inputDescriptions() {
		return CollectionUtils.collect(inputs(),new Transformer<Input, DescriptionElement>() {
			@Override
			public DescriptionElement transform(Input input) {
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
	
	public void autoNameInputs() {
		int i = 1;
		for (Input input : this.inputs()) {
			input.setName("input " + i);
			i++;
		}
	};
	
	@Override
	public void addOperand(IOperation operation) {
		if (left == null) {
			left = operation;
			operation.setParent(this);
			return;
		}
		if(right == null) {
			right = operation;
			operation.setParent(this);
			return;
		}
	}
}
