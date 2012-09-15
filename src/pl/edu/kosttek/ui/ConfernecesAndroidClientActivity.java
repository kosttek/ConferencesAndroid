package pl.edu.kosttek.ui;

import pl.edu.kosttek.ConferencesAndroid;
import pl.edu.kosttek.R;
import pl.edu.kosttek.adapters.ConferenceArrayAdapter;
import pl.edu.kosttek.connection.ConferencesConnectionManager;
import pl.edu.kosttek.entity.Conference;
import pl.edu.kosttek.settings.ConfigurationData;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ConfernecesAndroidClientActivity extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println(ConfigurationData.URL);
		setContentView(R.layout.main);
		//TextView textView = (TextView) findViewById(R.id.text);
		ListView listView = (ListView) findViewById(R.id.conf_list);
		
		ConferencesConnectionManager.getConferences();
		//textView.setText(text);//get conferences pobiera konfernecje to jest zle zrobione ze zwraca stringa do poprawy
		listView.setAdapter(new ConferenceArrayAdapter(this, ConferencesAndroid.getConferneces()));
		
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
					Conference conf =(Conference) arg0.getItemAtPosition(arg2);
					Intent intent = new Intent(getApplicationContext(), PanelsActivity.class);
					intent.putExtra(SchedulesListAndroidClientActivity.CONFENRECE_ID,conf.getId() );
					startActivity(intent);
				
			}
			
			
			
		});
		listView.setOnItemLongClickListener(new OnItemLongClickListener(){

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				Conference conf =(Conference) arg0.getItemAtPosition(arg2);
				Toast.makeText(ConfernecesAndroidClientActivity.this,conf.getId()+"" , Toast.LENGTH_SHORT).show();
				Intent intent = new Intent(ConfernecesAndroidClientActivity.this,SchedulesListAndroidClientActivity.class);
				intent.putExtra(SchedulesListAndroidClientActivity.CONFENRECE_ID,conf.getId() );
				startActivity(intent);
				return true;
			}
			
		});

		
	}
	   public boolean onCreateOptionsMenu(Menu menu) {
	    	menu.add(0,1, 0, "Settings");
	    	return true;
	    }
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	        case 1:
	        	Intent i = new Intent(this, SettingsActivity.class);
	        	startActivity(i);
	            break;
	        }
	        return true;
	    }
}