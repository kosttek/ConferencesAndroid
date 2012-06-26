package pl.edu.kosttek.ui;
import java.util.List;

import pl.edu.kosttek.ConferencesAndroid;
import pl.edu.kosttek.R;
import pl.edu.kosttek.adapters.PanelArrayAdapter;
import pl.edu.kosttek.connection.SchedulesConnectionManager;
import pl.edu.kosttek.entity.Conference;
import pl.edu.kosttek.entity.Panel;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;



public class PanelsActivity extends Activity {
	
	private List<Panel> panele;
	
	private ListView listView;
	
	static final String CONFENRECE_ID = "conferenceId"; 
	private int conferenceId;
	
    //private static final int ACTIVITY_CREATE=0;
    //private static final int ACTIVITY_EDIT=1;

   // private static final int INSERT_ID = Menu.FIRST;
    //private static final int DELETE_ID = Menu.FIRST + 1;
   // private static final int END_ID = Menu.FIRST + 2;

	
	
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.panel_list);
      
        listView = (ListView) findViewById(R.id.panel_list);
        handleExtras();
        SchedulesConnectionManager.getSchedules(conferenceId);
        
        initResources();
        initListView();
    }
    
    
    
    private void initResources() {
		panele = ConferencesAndroid.getPanelsByConferneceId(conferenceId);
		System.out.println();
    }
    
    void handleExtras(){
		conferenceId = getIntent().getIntExtra(CONFENRECE_ID, -1);
	}
    
    private void initListView() {
		PanelArrayAdapter adapter = new PanelArrayAdapter(this, panele);
		listView.setAdapter(adapter);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int pos,	long id) {
				Panel panel =(Panel) parent.getItemAtPosition(pos);
				Intent intent = new Intent(getApplicationContext(), DetailsInfo.class);
				intent.putExtra(DetailsInfo.PANEL_ID,panel.getId() );
				startActivity(intent);
				
				/*Toast.makeText(getApplicationContext(), 
			    detale[pos],
				Toast.LENGTH_SHORT).show();
				Intent i = new Intent(this, PanelsActivity.class);
			    startActivityForResult(i, 1);*/
		}
		
	});
}

}
