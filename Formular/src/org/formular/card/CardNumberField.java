package org.formular.card;

public class CardNumberField extends CardElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String label;

	@Override
	public void accept(CardElementVisitor visitor) {
		visitor.visit(this);
	}

	public void label(String label) {
		this.label = label;
		
	}
	
	public String getLabel() {
		return label;
	}

}
