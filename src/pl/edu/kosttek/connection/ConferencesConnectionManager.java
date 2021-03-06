package pl.edu.kosttek.connection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import pl.edu.kosttek.ConferencesAndroid;
import pl.edu.kosttek.entity.Conference;
import pl.edu.kosttek.settings.ConfigurationData;
import pl.edu.kosttek.utils.DateUtilities;
import pl.edu.kosttek.utils.EntityParser;

public class ConferencesConnectionManager extends ConnectorSoap {
	static public String getConferences(){
SoapObject result = null;		
	String resultString = null;	
			result = getSoapResponse(ConfigurationData.METHOD_NAME_GET_CONFERENCES, ConfigurationData.SPECIFIC_ADRESS_GET_CONFERENCES, null);
			
			
			if(result != null){
				resultString = "SOAP response:\n\n" + result.getProperty(0).toString();
				
				parseToConfernecesList(result);

				

			}
		
		return resultString;
	}

	static private void parseToConfernecesList(SoapObject sObject) {
		SoapObject list = (SoapObject) sObject.getProperty(0);
		EntityParser.setupParser();
		for (int i = 0; i < list.getPropertyCount(); i++) {
			SoapObject item = (SoapObject) list.getProperty(i);

			EntityParser.parseConfernece(item);
			

		}
		EntityParser.setupResults();

	}
}
