package org.formular.operation;

import java.util.LinkedList;
import java.util.List;

import org.formular.core.IOperation;
import org.formular.core.Input;
import org.formular.description.DescriptionElement;

public abstract class BinaryOperation<I,O> extends AOperation<I,O> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IOperation<?,I> right;
	public IOperation<?,I> left;
	public void right(IOperation<?,I> operation2) {
		right = operation2;	
	}

	public void left(IOperation<?,I> operation1) {
		left = operation1;
	}

	

	public IOperation<?,I> right(Float i, Class<? extends ParameterOperation> class1) {
		
		ParameterOperation newInstance = ParameterOperation.createParameter(i, class1);
		this.right(newInstance);
		return newInstance;
	}

	public IOperation<?,I> left(Float i, Class<? extends ParameterOperation> class1) {
		ParameterOperation newInstance = ParameterOperation.createParameter(i, class1);
		this.left(newInstance);
		return newInstance;
	}

	@Override
	public void addOperand(IOperation<?,?> operation) {
		IOperation<?,I> iOperation = ((IOperation<?,I>) operation);
		if (left == null) {
			left = iOperation;
			operation.setParent(this);
			return;
		}
		if(right == null) {
			right = iOperation;
			operation.setParent(this);
			return;
		}
	}

	@Override
	public List<Input> inputs() {
		List<Input> inputs = new LinkedList<Input>();
		if(left != null)
			inputs.addAll(left.inputs());
		if(right != null)
			inputs.addAll(right.inputs());
		return inputs;
	}

	@Override
	public List <DescriptionElement> inputDescriptions() {
		List<DescriptionElement> ret = new LinkedList<DescriptionElement>();
		for (Input input: inputs()) {
			ret.add(input.getDesciption());
		}
		return ret;
	}
	

}
