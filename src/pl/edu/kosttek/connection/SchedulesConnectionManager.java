package pl.edu.kosttek.connection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ksoap2.serialization.SoapObject;

import pl.edu.kosttek.ConferencesAndroid;
import pl.edu.kosttek.entity.Conference;
import pl.edu.kosttek.entity.Schedule;
import pl.edu.kosttek.settings.ConfigurationData;
import pl.edu.kosttek.utils.DateUtilities;
import pl.edu.kosttek.utils.EntityParser;

public class SchedulesConnectionManager extends ConnectorSoap {
	static public String getSchedules(int confId){
SoapObject result = null;		
	String resultString = null;	
	Map <String,Object> args = new HashMap<String, Object>();
	args.put("arg0", confId);
			result = getSoapResponse(ConfigurationData.METHOD_NAME_GET_SCHEDULES, ConfigurationData.SPECIFIC_ADRESS_GET_SCHEDULES, args);
			
			
			if(result != null){
				resultString = "SOAP response:\n\n" + result.getProperty(0).toString();
				parseScheduls(result);
				

			}
		
		return resultString;
	}

	static private void parseScheduls(SoapObject sObject) {
		SoapObject list = (SoapObject) sObject.getProperty(0);
		List<Schedule> resultList = new ArrayList<Schedule>();
		EntityParser.setupParser();
		for (int i = 0; i < list.getPropertyCount(); i++) {
			SoapObject item = (SoapObject) list.getProperty(i);
			EntityParser.parseSchedule(item);

		}
		EntityParser.setupResults();
		resultList = ConferencesAndroid.getSchedules();
		System.out.println(resultList.size());
	}
}
