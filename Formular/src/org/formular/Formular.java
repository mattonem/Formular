package org.formular;

import android.app.Activity;
import android.app.Fragment;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Formular extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
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
            View rootView = inflater.inflate(R.layout.fragment_formular, container, false);
            
            return rootView;
        }
        
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
        	getFragmentManager().beginTransaction().add(R.id.cards_layout, new CardFragment(),"frag1").commit();
        	getFragmentManager().beginTransaction().add(R.id.cards_layout, new CardFragment(),"frag2").commit();
        	getFragmentManager().beginTransaction().add(R.id.cards_layout, new CardFragment(),"frag3").commit();
        	getFragmentManager().beginTransaction().add(R.id.cards_layout, new CardFragment(),"frag4").commit();
//        	Button view = (Button) getActivity().getLayoutInflater().inflate(R.layout.card, null);
//            view.setText("coucou");
//			layout.addView(view);
//			view.setOnClickListener(new View.OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					Log.d("test", "coucou");
//					
//				}
//			});
        	super.onActivityCreated(savedInstanceState);
        }
    }

}
