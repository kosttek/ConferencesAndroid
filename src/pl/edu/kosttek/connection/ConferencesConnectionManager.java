package pl.edu.kosttek.connection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import pl.edu.kosttek.ConferencesAndroid;
import pl.edu.kosttek.entity.Conference;
import pl.edu.kosttek.settings.ConfigurationData;
import utils.DateUtilities;
import android.util.Log;

public class ConferencesConnectionManager {
	static public String getConferences(){
		//Initialize soap request + add parameters
		SoapObject request = new SoapObject(ConfigurationData.NAMESPACE,ConfigurationData.METHOD_NAME_GET_CONFERENCES);        

		//Use this to add parameters
		request.addProperty("arg0","Gan di");

		//Declare the version of the SOAP request
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
	

		envelope.setAddAdornments(false);
	       envelope.implicitTypes = true;
	       envelope.setOutputSoapObject(request);
		
		//Needed to make the internet call
	    String URL = ConfigurationData.URL+ConfigurationData.SPECIFIC_ADRESS_GET_CONFERENCES;
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.debug = true;
		//androidHttpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		try {
			//this is the actual part that will call the webservice
			String SOAP_ACTION = ConfigurationData.NAMESPACE + ConfigurationData.METHOD_NAME_GET_CONFERENCES;
			androidHttpTransport.call(SOAP_ACTION, envelope);
		
		} catch (Exception e) {
//			Log.i("response dump log","rsponse dump: "+androidHttpTransport.responseDump);
//			Log.e("request dump log","request dump: "+androidHttpTransport.requestDump);
			e.printStackTrace();
		}
		String resultString = null;
		// Get the SoapResult from the envelope body.
		SoapObject result;
		try {
			result = (SoapObject)envelope.bodyIn;
			if(result != null){
				resultString = "SOAP response:\n\n" + result.getProperty(0).toString();
				Log.i("ConfernecesConnectionManager",result.getProperty(0).toString());
				parseToConfernecesList(result);
				//System.out.println("SOAP response:\n\n" + result.getProperty(0).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultString;
	}
	static private void parseToConfernecesList(SoapObject sObject){
		SoapObject list = (SoapObject)sObject.getProperty(0);
		List<Conference> resultList= new ArrayList<Conference>();
		for(int i = 0 ; i < list.getPropertyCount();i++){
			SoapObject item = (SoapObject)list.getProperty(i);
			Date startDate=DateUtilities.getDateFromString(item.getProperty("startDate").toString());
			Date endDate=DateUtilities.getDateFromString(item.getProperty("endDate").toString());
			Conference conf = new Conference(item.getProperty("title").toString(), item.getProperty("description").toString(), startDate, endDate);
			conf.setId(Integer.parseInt(item.getProperty("id").toString()));
			resultList.add(conf);
			Log.i("ConfernecesConnectionManager",item.getProperty("description").toString() + item.getProperty("title").toString()+conf.getStartDate().toGMTString());
		}
		ConferencesAndroid.setConferneces(resultList);
		Log.i("ConfernecesConnectionManager","size" +resultList.size());
	}
}
