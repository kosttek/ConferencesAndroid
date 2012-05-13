package pl.edu.kosttek;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ConfernecesAndroidClientActivity extends Activity {
    /** Called when the activity is first created. */
	
//	private static String SOAP_ACTION = "http://webservice.regdeveloper.co.uk/EchoBeanService";
//	private static String SOAP_ACTION = "";

	private static String NAMESPACE = "http://webservice.regdeveloper.co.uk/";
	private static String METHOD_NAME = "echo";
	private static String SOAP_ACTION = NAMESPACE +"/"+METHOD_NAME;

	// ip jest do zmiany zalezne od tego na jakim ip stoi jboss
	private static String URL = "http://10.10.0.1:8080/ConferenceEJB/EchoBean";
//	private static String URL = "http://10.10.0.1:8080/ejbanother2/EchoBean";
//	private static String SOAP_ACTION = "http://webservice.regdeveloper.co.uk/EchoBeanService";
////	private static String SOAP_ACTION = "";
//
//	private static String NAMESPACE = "http://agh.edu.pl/ex";
//	private static String METHOD_NAME = "EchoBeanService";
//
//	private static String URL = "http://10.10.0.1:8080/ejbexample/HelloWorldPortType?wsdl";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView textView = (TextView)findViewById(R.id.text);

    	/**
    	 * @param args
    	 */
    	

    		//Initialize soap request + add parameters
    		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);        

    		//Use this to add parameters
    		request.addProperty("arg0","Gan di");

    		//Declare the version of the SOAP request
    		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    		envelope.setOutputSoapObject(request);
    	
    		//try random
    				//envelope.dotNet = true; 
    				//envelope.headerOut = security; // this is an Element[] created before 
    				//envelope.encodingStyle = SoapEnvelope.ENC; 
    				//envelope.setAddAdornments(false); 
    				//envelope.implicitTypes = false;
    		envelope.setAddAdornments(false);
    	       envelope.implicitTypes = true;
    	       envelope.setOutputSoapObject(request);
    		
    		//Needed to make the internet call
    		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
    		androidHttpTransport.debug = true;
    		//androidHttpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    		try {
    			//this is the actual part that will call the webservice
    			
    			androidHttpTransport.call(SOAP_ACTION, envelope);
    		
    		} catch (Exception e) {
//    			Log.i("response dump log","rsponse dump: "+androidHttpTransport.responseDump);
//    			Log.e("request dump log","request dump: "+androidHttpTransport.requestDump);
    			e.printStackTrace();
    		}
    		
    		// Get the SoapResult from the envelope body.
    		SoapObject result;
    		try {
    			// czasmi wyrzuca wyjatek cannot cast exception czasami dziala co drugi raz! to nie moze byc przypadek :0 
    			result = (SoapObject)envelope.bodyIn;
    			if(result != null){
    				textView.setText("SOAP response:\n\n" + result.getProperty(0).toString());
    				//System.out.println("SOAP response:\n\n" + result.getProperty(0).toString());
    			}
    		} catch (Exception e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

    		

    }
}