package pl.edu.kosttek.ui;

import pl.edu.kosttek.ConferencesAndroid;
import pl.edu.kosttek.R;
import pl.edu.kosttek.adapters.SchedulesArrayAdapter;
import pl.edu.kosttek.connection.SchedulesConnectionManager;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class SchedulesListAndroidClientActivity extends Activity {
	/** Called when the activity is first created. */
	static final String CONFENRECE_ID = "conferenceId"; 
	private int conferenceId;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	//	TextView textView = (TextView) findViewById(R.id.text);
		ListView listView = (ListView) findViewById(R.id.conf_list);
		handleExtras();
		SchedulesConnectionManager.getSchedules(conferenceId);//get conferences pobiera konfernecje to jest zle zrobione ze zwraca stringa do poprawy
		//textView.setText(text);//get conferences pobiera konfernecje to jest zle zrobione ze zwraca stringa do poprawy
		listView.setAdapter(new SchedulesArrayAdapter(this, ConferencesAndroid.getSchedulesByConferneceId(conferenceId)));


	}
	void handleExtras(){
		conferenceId = getIntent().getIntExtra(CONFENRECE_ID, -1);
	}
}