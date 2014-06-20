package org.formular;

import java.util.LinkedList;

import org.formular.card.CardElement;
import org.formular.card.CardFragment;
import org.formular.card.CardSideFragment;
import org.formular.card.description.CardText;
import org.formular.card.description.CardTitle;
import org.formular.core.Operation;

import android.os.Bundle;

public class OperationAfficheur extends CardFragment {
	private Operation operation;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		operation = (Operation) getArguments().getSerializable("operation");
		Bundle frontArguments = new Bundle();
		Bundle backArguments = new Bundle();
		LinkedList<CardElement> frontDescription = new LinkedList<CardElement>();
		LinkedList<CardElement> backDescription = new LinkedList<CardElement>();
		
		frontDescription.add(new CardTitle(operation.toString()));
		frontDescription.add(new CardText(Integer.toString(operation.result())));
		
		backDescription.add(new CardTitle("Inputs"));
		backDescription.addAll(operation.inputDescriptions());
		
		backArguments.putSerializable("description", backDescription);
		frontArguments.putSerializable("description", frontDescription);
		
		frontSide = new CardSideFragment();
		backSide = new CardSideFragment();
		
		frontSide.setArguments(frontArguments);
		backSide.setArguments(backArguments);
		super.onCreate(savedInstanceState);
	}
}