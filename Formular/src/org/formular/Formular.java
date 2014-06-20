package org.formular;

import org.formular.card.CardFragment;
import org.formular.core.Operation;
import org.formular.core.OperationComposition;
import org.formular.core.Somme;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class Formular extends Activity {

	Operation ope;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_formular);

		if (savedInstanceState == null) {
			Bundle operationBundle = new Bundle();
			OperationComposition operation = new Somme();
			operation.right(1);
			operation.left(2);
			ope = operation;
			
			operationBundle.putSerializable("operation", ope);
			Fragment fragment = new PlaceholderFragment();
			fragment.setArguments(operationBundle);
			getFragmentManager().beginTransaction()
					.add(R.id.container, fragment).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.formular, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_formular,
					container, false);

			return rootView;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			if (savedInstanceState == null) {
				CardFragment fragment = new OperationAfficheur();
				fragment.setArguments(getArguments());
				getChildFragmentManager().beginTransaction()
						.add(R.id.cards_layout, fragment).commit();
			}
			super.onActivityCreated(savedInstanceState);
		}
		
	}

}
