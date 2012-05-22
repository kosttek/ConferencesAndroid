package pl.edu.kosttek;

import java.util.List;

import pl.edu.kosttek.entity.Conference;
import android.app.Application;


public class ConferencesAndroid extends Application {
	static private List <Conference> conferneces;

	static public List <Conference> getConferneces() {
		return conferneces;
	}

	static public void setConferneces(List <Conference> confernecesSet) {
		conferneces = confernecesSet;
	}

}
