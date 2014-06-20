package org.formular.card;

import org.formular.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public abstract class CardFragment extends Fragment {
	boolean front;
	protected Fragment frontSide;
	protected Fragment backSide;
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		front = true;
		View rootView = inflater.inflate(R.layout.card, container, false);
		getChildFragmentManager().beginTransaction()
				.replace(R.id.card_side, frontSide).commit();
		return rootView;
	}

	@Override
	public void onStart() {

		super.onStart();
	}

	public void prepareFlipButton(View view) {
		ImageButton flipButton = (ImageButton) view.findViewById(R.id.flip_button);
		flipButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				CardFragment.this.flipToBack();
			}
		});

	}

	protected void flipToBack() {
		front = !front;
		Fragment newSide = front?frontSide:backSide;
		getChildFragmentManager()
				.beginTransaction()
				.setCustomAnimations(R.anim.card_flip_left_in,
						R.anim.card_flip_left_out)
				.replace(R.id.card_side, newSide).commit();
	}
	
}
