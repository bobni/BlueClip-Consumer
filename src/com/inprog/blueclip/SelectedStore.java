package com.inprog.blueclip;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SelectedStore extends Activity {

	private ListView storeDeals ;
	private ArrayAdapter<String> listAdapter ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_selected_store);
		
		storeDeals = (ListView) findViewById( R.id.store_deals);
		
		String[] deals = new String[] { "20% Off", "Buy One Get One Free", "Free Shipping", "Bonus Gift"};  
	    ArrayList<String> dealList = new ArrayList<String>();
	    dealList.addAll( Arrays.asList(deals) );
	    
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, dealList);
	    
	    storeDeals.setAdapter( listAdapter ); 
		
		// Get the message from the intent
	    Intent intent = getIntent();
	    String message = intent.getStringExtra(DisplayLocalStores.EXTRA_MESSAGE);

	    //find the text view
//	    TextView textView = (TextView) findViewById(R.id.store_name);
//	    textView.setTextSize(40);
//	    textView.setText(message);
	    
	    setTitle(message);
	    
	    
//	    // Create the text view
//	    TextView textView = new TextView(this);
//	    textView.setTextSize(40);
//	    textView.setText(message);
//
//	    // Set the text view as the activity layout
//	    setContentView(textView);
		
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.selected_store, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
