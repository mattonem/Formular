package org.formular.card;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.formular.R;
import org.formular.core.InputController;
import org.formular.description.DescripitonVisitor;
import org.formular.description.DescriptionElement;
import org.formular.description.FieldDescription;
import org.formular.description.concrete.ListDescription;
import org.formular.description.concrete.TextDescription;
import org.formular.description.concrete.TitleDescription;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class CardSideFragment extends Fragment implements DescripitonVisitor {

	protected HashMap<InputController, EditText> binding;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		binding = new HashMap<InputController, EditText>();
		View rootView = inflater.inflate(R.layout.card_face, container, false);
		return rootView;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		((CardFragment) getParentFragment()).prepareFlipButton(getView());

		LinkedList<DescriptionElement> description = (LinkedList<DescriptionElement>) getArguments()
				.getSerializable("description");
		if (description != null) {
			for (DescriptionElement cardElement : description) {
				cardElement.accept(this);
			}
		}
		super.onActivityCreated(savedInstanceState);
	}

	public void visit(TitleDescription title) {
		TextView view = (TextView) getView().findViewById(R.id.title);
		view.setText(title.getTitle());
	}

	@Override
	public void visit(TextDescription cardText) {
		LinearLayout layout = (LinearLayout) getView().findViewById(
				R.id.linear_layout);
		TextView view = new TextView(getActivity());
		view.setText(cardText.getText());
		layout.addView(view);
	}

	@Override
	public void visit(FieldDescription cardNumberField) {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout rootLayout = (LinearLayout) getView().findViewById(
				R.id.linear_layout);
		TextView view = new TextView(getActivity());
		EditText editText = new EditText(getActivity());
		editText.setInputType(cardNumberField.getType());
		editText.setText(cardNumberField.getVal());
		view.setText(cardNumberField.getLabel());

		binding.put(cardNumberField, editText);

		layout.addView(view);
		layout.addView(editText);
		rootLayout.addView(layout);

	}

	@Override
	public void onDestroyView() {
		for (Entry<InputController, EditText> entry : binding.entrySet()) {
			InputController input = entry.getKey();
			EditText editText = entry.getValue();
			String string = editText.getText().toString();
			input.setVal(string);
		}
		super.onDestroyView();
	}

	@Override
	public void visit(ListDescription listDescription) {
		LinearLayout layout = new LinearLayout(getActivity());
		layout.setOrientation(LinearLayout.VERTICAL);
		LinearLayout rootLayout = (LinearLayout) getView().findViewById(
				R.id.linear_layout);
		TextView view = new TextView(getActivity());
		Spinner list = new Spinner(getActivity());
		ArrayAdapter<Float> adapter = new ArrayAdapter<Float>(getActivity(), android.R.layout.simple_list_item_1, 
				android.R.id.text1,  listDescription.getList());
		
		list.setAdapter(adapter);
		
		
		view.setText(listDescription.getLabel());

//		binding.put(listDescription, );

		layout.addView(view);
		layout.addView(list);
		rootLayout.addView(layout);
	}

}
