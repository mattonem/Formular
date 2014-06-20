package org.formular.card;

import java.util.LinkedList;

import org.formular.R;
import org.formular.card.description.CardField;
import org.formular.card.description.CardText;
import org.formular.card.description.CardTitle;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CardSideFragment extends Fragment implements CardElementVisitor {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.card_face, container, false);
		return rootView;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		((CardFragment) getParentFragment()).prepareFlipButton(getView());

		LinkedList<CardElement> description = (LinkedList<CardElement>) getArguments()
				.getSerializable("description");
		if (description != null) {
			for (CardElement cardElement : description) {
				cardElement.accept(this);
			}
		}
		super.onActivityCreated(savedInstanceState);
	}

	public void visit(CardTitle title) {
		TextView view = (TextView) getView().findViewById(R.id.title);
		view.setText(title.getTitle());
	}

	@Override
	public void visit(CardText cardText) {
		LinearLayout layout = (LinearLayout) getView().findViewById(
				R.id.linear_layout);
		TextView view = new TextView(getActivity());
		view.setText(cardText.getText());
		layout.addView(view);
	}

	@Override
	public void visit(CardField cardNumberField) {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout rootLayout = (LinearLayout) getView().findViewById(
				R.id.linear_layout);
		TextView view = new TextView(getActivity());
		EditText editText = new EditText(getActivity());
		
		view.setText(cardNumberField.getLabel());
		
		layout.addView(view);
		layout.addView(editText);
		rootLayout.addView(layout);

	}

}
