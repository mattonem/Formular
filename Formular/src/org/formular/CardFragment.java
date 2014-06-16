package org.formular;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class CardFragment extends Fragment {
	boolean front;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		front = true;
		View rootView = inflater.inflate(R.layout.card, container, false);
		getChildFragmentManager().beginTransaction()
				.replace(R.id.card_side, new CardSideFragment()).commit();
		return rootView;
	}

	@Override
	public void onStart() {

		super.onStart();
	}

	public void prepareFlipButton() {
		ImageButton flipButton = (ImageButton) getView().findViewById(R.id.button);
		flipButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				CardFragment.this.flipToBack();
			}
		});

	}

	protected void flipToBack() {
		front = !front;
		getChildFragmentManager()
				.beginTransaction()
				.setCustomAnimations(R.anim.card_flip_left_in,
						R.anim.card_flip_left_out)
				.replace(R.id.card_side, new CardSideFragment()).commit();
	}
	
}
