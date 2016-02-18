package monks.location.service;

import java.math.BigDecimal;

import monks.location.client.Web2StringClient;

public class WindEnergy {

	public BigDecimal getWindIntensity(BigDecimal latitude, BigDecimal longitude) {

		BigDecimal annualWindIndex = BigDecimal.ZERO;
		
		// converting latitude and longitude into integer as the lat & lon data from 
		// web page doesn't has decimal values but only integer values
		int referredLatitude = latitude.intValue();
        int referredLongitude = longitude.intValue();

		// URL of web page containing wind data from NASA Surface meteorology
		// and Solar Energy (SSE)
		String webPageUrl = "https://eosweb.larc.nasa.gov/sse/global/text/10yr_wspd50m";

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

			// Splitting each line into array of strings separated by empty space
			String[] subStrings = line.split(" ");

			// fetching the latitude and longitude value from the string array
			String localLatitude = subStrings[0];
			String localLongitude = subStrings[1];

			if (localLatitude.equals(Integer.toString(referredLatitude)) && localLongitude.equals(Integer.toString(referredLongitude))) {
				annualWindIndex = new BigDecimal(subStrings[subStrings.length - 1]);
				break;
			}
		}
		return annualWindIndex;
	}
}
