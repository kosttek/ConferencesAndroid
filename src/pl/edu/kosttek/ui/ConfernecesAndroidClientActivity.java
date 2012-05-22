package pl.edu.kosttek.ui;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import pl.edu.kosttek.ConferencesAndroid;
import pl.edu.kosttek.R;
import pl.edu.kosttek.R.id;
import pl.edu.kosttek.R.layout;
import pl.edu.kosttek.adapters.ConferenceArrayAdapter;
import pl.edu.kosttek.connection.ConferencesConnectionManager;
import pl.edu.kosttek.settings.*;

public class ConfernecesAndroidClientActivity extends Activity {
	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TextView textView = (TextView) findViewById(R.id.text);
		ListView listView = (ListView) findViewById(R.id.conf_list);
		
		String text = ConferencesConnectionManager.getConferences();//get conferences pobiera konfernecje to jest zle zrobione ze zwraca stringa do poprawy
		//textView.setText(text);//get conferences pobiera konfernecje to jest zle zrobione ze zwraca stringa do poprawy
		listView.setAdapter(new ConferenceArrayAdapter(this, ConferencesAndroid.getConferneces()));
		

	}
}