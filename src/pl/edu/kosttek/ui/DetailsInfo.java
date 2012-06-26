package pl.edu.kosttek.ui;
import pl.edu.kosttek.ConferencesAndroid;
import pl.edu.kosttek.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



public class DetailsInfo extends Activity {
	static final String PANEL_ID = "panelId"; 
	private int panelId;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleExtras();
        setContentView(R.layout.details_box);   
        TextView text = (TextView) findViewById(R.id.details_text);
        text.setText(ConferencesAndroid.getPanelById(panelId).getDescription());
       
    }
    void handleExtras(){
		panelId = getIntent().getIntExtra(PANEL_ID, -1);
	}
    
  }
