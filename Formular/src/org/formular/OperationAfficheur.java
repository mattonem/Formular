package org.formular;

import java.util.LinkedList;

import org.formular.card.CardFragment;
import org.formular.card.CardSideFragment;
import org.formular.core.IOperation;
import org.formular.description.DescriptionElement;
import org.formular.description.concrete.TextDescription;
import org.formular.description.concrete.TitleDescription;

import android.os.Bundle;

public class OperationAfficheur extends CardFragment {
	private IOperation<?> operation;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		operation = (IOperation<?>) getArguments().getSerializable("operation");
		Bundle frontArguments = new Bundle();
		Bundle backArguments = new Bundle();
		LinkedList<DescriptionElement> frontDescription = new LinkedList<DescriptionElement>();
		LinkedList<DescriptionElement> backDescription = new LinkedList<DescriptionElement>();
		
		frontDescription.add(new TitleDescription(operation.getName()));
		frontDescription.add(new TextDescription(operation));
		
		backDescription.add(new TitleDescription("Inputs"));
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
