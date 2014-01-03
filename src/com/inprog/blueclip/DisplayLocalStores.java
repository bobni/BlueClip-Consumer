package com.inprog.blueclip;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class DisplayLocalStores extends Activity {

	public final static String EXTRA_MESSAGE = "com.inprog.blueclip.MESSAGE";
	
	private ListView mainListView ;
	private ArrayAdapter<String> listAdapter ;
	  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_local_stores);
		
		// Find the ListView resource. 
	    mainListView = (ListView) findViewById( R.id.mainListView );

	    // Create and populate a List of store names.
	    String[] stores = new String[] { "Macy's", "JC Penney", "Sears", "BestBuy"};  
	    ArrayList<String> storeList = new ArrayList<String>();
	    storeList.addAll( Arrays.asList(stores) );
	    
	    // Create ArrayAdapter using the store list.
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simplerow, storeList);
	    
	    // Add more stores. If you passed a String[] instead of a List<String> 
	    // into the ArrayAdapter constructor, you must not add more items. 
	    // Otherwise an exception will occur.
	    listAdapter.add( "WalMart" );
	    listAdapter.add( "H&M" );
	    
	    // Set the ArrayAdapter as the ListView's adapter.
	    mainListView.setAdapter( listAdapter ); 
	    
	    mainListView.setOnItemClickListener(new OnItemClickListener() {
	    	 
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
               int position, long id) {
              
             // ListView Clicked item index
             int itemPosition     = position;
             
             // ListView Clicked item value
             String  itemValue    = (String) mainListView.getItemAtPosition(position);
                
              // Show Alert 
              Toast.makeText(getApplicationContext(),"Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG).show();
              
              	Intent intent = new Intent(DisplayLocalStores.this,SelectedStore.class);
      			String message = itemValue;
      			intent.putExtra(EXTRA_MESSAGE, message);
      			startActivity(intent);
           
            }

       }); 
	    
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
		getMenuInflater().inflate(R.menu.display_local_stores, menu);
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
