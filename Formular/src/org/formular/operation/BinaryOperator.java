package org.formular.operation;

import java.util.LinkedList;
import java.util.List;

import org.formular.core.IOperation;
import org.formular.core.Input;
import org.formular.description.DescriptionElement;

public abstract class BinaryOperator<I> extends AOperation<Boolean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IOperation<I> right;
	public IOperation<I> left;
	
	@Override
	public List<Input> inputs() {
		List<Input> inputs = new LinkedList<Input>();
		if(right != null)
			inputs.addAll(right.inputs());
		if(left != null)
			inputs.addAll(left.inputs());
		return inputs;
	}
	
	@Override
	public void addOperand(IOperation<?> operation) {
		IOperation<I> ioperation = (IOperation<I>) operation;
		if (left == null) {
			left = ioperation;
			operation.setParent(this);
			return;
		}
		if(right == null) {
			right = ioperation;
			operation.setParent(this);
			return;
		}
	}
	
	public void right(IOperation<I> operation2) {
		right = operation2;	
	}

	public void left(IOperation<I> operation1) {
		left = operation1;
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
