package org.formular.operation;

import java.util.LinkedList;
import java.util.List;

import org.formular.core.IOperation;
import org.formular.core.Input;
import org.formular.description.DescriptionElement;

public abstract class UnaryOperation extends AOperation<Float> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IOperation<Float> operand;



	@Override
	public void addOperand(IOperation<?> operation) {
		this.operand((IOperation<Float>) operation);
		operation.setParent(this);
		
	}

	

	@Override
	public List<Input> inputs() {
		return operand.inputs();
	}

	@Override
	public List<DescriptionElement> inputDescriptions() {
		List<DescriptionElement> ret = new LinkedList<DescriptionElement>();
		for (Input input: inputs()) {
			ret.add(input.getDesciption());
		}
		return ret;
	}

	public IOperation<Float> operand(Float f, Class<? extends ParameterOperation> class1) {
		IOperation<Float> newInstance = ParameterOperation.createParameter(f, class1);
		this.operand(newInstance);
		return newInstance;
		
	}



	private void operand(IOperation<Float> newInstance) {
		operand = newInstance;
	}

}
