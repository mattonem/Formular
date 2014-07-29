package org.formular.card.description;

import org.formular.card.CardElement;
import org.formular.card.CardElementVisitor;
import org.formular.core.AOperationException;
import org.formular.core.IOperation;
import org.formular.core.MissingArgument;


public class CardText implements CardElement {

	private IOperation operation;

	public CardText(IOperation operation) {
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
	public void accept(CardElementVisitor visitor) {
		visitor.visit(this);
	}

}
