package pl.edu.kosttek.connection;

import java.util.Map;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import pl.edu.kosttek.settings.ConfigurationData;

public class ConnectorSoap {
	static public SoapObject getSoapResponse(String methodName,
			String specificAdres, Map<String, Object> args) {
		System.out.println("Start get response");
		// Initialize soap request + add parameters
		SoapObject request = new SoapObject(ConfigurationData.NAMESPACE,
				methodName);

		// Use this to add parameters
		if (args != null) {
			for (String key : args.keySet()) {
				args.get(key);
				request.addProperty(key, args.get(key));
			}
		}

		// Declare the version of the SOAP request
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);

		envelope.setAddAdornments(false);
		envelope.implicitTypes = true;
		envelope.setOutputSoapObject(request);

		// Needed to make the internet call
		String URL = ConfigurationData.URL
				+ specificAdres;
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		androidHttpTransport.debug = true;
		// androidHttpTransport.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		try {
			// this is the actual part that will call the webservice
			String SOAP_ACTION = ConfigurationData.NAMESPACE + specificAdres;
			androidHttpTransport.call(SOAP_ACTION, envelope);

		} catch (Exception e) {
			// Log.i("response dump log","rsponse dump: "+androidHttpTransport.responseDump);
			// Log.e("request dump log","request dump: "+androidHttpTransport.requestDump);
			e.printStackTrace();
		}
		String resultString = null;
		// Get the SoapResult from the envelope body.
		SoapObject result = null;

		try {
			result = (SoapObject) envelope.bodyIn;

		} catch (Exception e) {

			e.printStackTrace();
		}

		return result;
	}
}
