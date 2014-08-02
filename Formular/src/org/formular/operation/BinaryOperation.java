package org.formular.operation;

import java.util.LinkedList;
import java.util.List;

import org.formular.card.CardElement;
import org.formular.core.IOperation;
import org.formular.core.Input;

public abstract class BinaryOperation extends AOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IOperation right;
	public IOperation left;
	public void right(IOperation operation2) {
		right = operation2;	
	}

	public void left(IOperation operation1) {
		left = operation1;
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
	public List<CardElement> inputDescriptions() {
		List<CardElement> ret = new LinkedList<CardElement>();
		for (Input input: inputs()) {
			ret.add(input.getDesciption());
		}
		return ret;
	}
	
	@Override
	public List<Input> inputs() {
		List<Input> inputs = new LinkedList<Input>();
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
