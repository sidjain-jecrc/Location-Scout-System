package monks.location.client;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import monks.location.client.ServiceStub.GetWebContent;
import monks.location.client.ServiceStub.GetWebContentResponse;

public class Web2StringClient {

	/*
	 * This client will invoke the service in ASU Service Repository called
	 * Web2String and download the Web page at the given URL and return the text in
	 * the page as a String
	 */
	public String getWebContectFromUrl(String url) {

		String localWebContent = null;
		try {
			ServiceStub stub = new ServiceStub();

			GetWebContent getWebContentRequest = new GetWebContent();
			getWebContentRequest.setUrl(url);

			GetWebContentResponse getWebContentResponse = stub.getWebContent(getWebContentRequest);
			localWebContent = getWebContentResponse.getGetWebContentResult();

		} catch (AxisFault e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return localWebContent;
	}

}
