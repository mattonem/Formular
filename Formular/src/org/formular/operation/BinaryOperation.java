package org.formular.operation;

import java.util.LinkedList;
import java.util.List;

import org.formular.core.IOperation;
import org.formular.core.Input;
import org.formular.description.DescriptionElement;

public abstract class BinaryOperation extends AOperation<Float> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IOperation<Float> right;
	public IOperation<Float> left;
	public void right(IOperation<Float> operation2) {
		right = operation2;	
	}

	public void left(IOperation<Float> operation1) {
		left = operation1;
	}

	

	public IOperation<Float> right(Float i, Class<? extends ParameterOperation> class1) {
		
		ParameterOperation newInstance = ParameterOperation.createParameter(i, class1);
		this.right(newInstance);
		return newInstance;
	}

	public IOperation<Float> left(Float i, Class<? extends ParameterOperation> class1) {
		ParameterOperation newInstance = ParameterOperation.createParameter(i, class1);
		this.left(newInstance);
		return newInstance;
	}

	@Override
	public void addOperand(IOperation<?> operation) {
		IOperation<Float> iOperation = ((IOperation<Float>) operation);
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
