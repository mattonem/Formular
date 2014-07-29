package org.formular.operation;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;
import org.formular.card.CardElement;
import org.formular.core.IOperation;
import org.formular.core.Input;

public abstract class MultinaryOperation extends AOperation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	List<IOperation> operands;

	@Override
	public Collection<CardElement> inputDescriptions() {
		return CollectionUtils.collect(inputs(),new Transformer<Input, CardElement>() {
			@Override
			public CardElement transform(Input input) {
				return input.getDesciption();
			}
		});
	}
	
	@Override
	public void addOperand(IOperation operation) {
		operation.addOperand(operation);
	}

	@Override
	public Collection<Input> inputs() {
		Collection<Collection<Input>> collect = CollectionUtils.collect(operands,new Transformer<IOperation, Collection<Input>>() {
			@Override
			public Collection<Input> transform(IOperation ope) {
				return ope.inputs();
			}
		});
		Collection<Input> ret = new LinkedList<Input>();
		for (Collection<Input> inputs : collect) {
			ret.addAll(inputs);
		}
		return ret;
		
	}
	
	public abstract List<IOperation> getOperands();
}
