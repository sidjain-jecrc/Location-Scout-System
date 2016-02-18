package monks.location.service;

import java.math.BigDecimal;

import monks.location.client.Web2StringClient;

public class SolarEnergy {

	public BigDecimal getSolarIntensity(BigDecimal latitude, BigDecimal longitude) {

		BigDecimal annualSolarIndex = BigDecimal.ZERO;
        
		// converting latitude and longitude into integer as the lat & lon data from 
		// web page doesn't has decimal values but only integer values
		int referredLatitude = latitude.intValue();
        int referredLongitude = longitude.intValue();
        
		// URL of web page containing solar radiation data from NASA Surface
		// meteorology and Solar Energy (SSE)
		String webPageUrl = "https://eosweb.larc.nasa.gov/sse/global/text/direct_radiation";

		/*
		 * Reading content from the web URL using the client that is consuming
		 * Web2String service in ASU Service Repository
		 */
		Web2StringClient webToStringClient = new Web2StringClient();
		String webContentString = webToStringClient.getWebContectFromUrl(webPageUrl);

		// Splitting the web content string into array of lines separated by
		// line delimiter '\n'
		String[] lines = webContentString.split("\\r?\\n");
		for (String line : lines) {

			// Splitting each line into array of strings separated by empty space ' '
			String[] stringArray = line.split(" ");

			// fetching the latitude and longitude value from the string array
			String localLatitude = stringArray[0];
			String localLongitude = stringArray[1];

			// if the requested latitude and longitude match the available data then
			// fetch the annual solar index value
			if (localLatitude.equals(Integer.toString(referredLatitude)) && localLongitude.equals(Integer.toString(referredLongitude))) {
				annualSolarIndex = new BigDecimal(stringArray[stringArray.length - 1]);
				break;
			}
		}
		return annualSolarIndex;
	}
}
