package org.formular.description.concrete;

import org.formular.core.IOperation;
import org.formular.description.DescriptionElement;
import org.formular.description.DescripitonVisitor;
import org.formular.operation.AOperationException;
import org.formular.operation.exception.MissingArgument;


public class TextDescription implements DescriptionElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IOperation<?> operation;

	public TextDescription(IOperation<?> operation) {
		this.operation = operation;
	}

	public CharSequence getText() {
		try {
			return ""+ operation.result();
		}	catch (MissingArgument e) {
			return "Missing parameter";
		}
			catch (AOperationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void accept(DescripitonVisitor visitor) {
		visitor.visit(this);
	}

}
