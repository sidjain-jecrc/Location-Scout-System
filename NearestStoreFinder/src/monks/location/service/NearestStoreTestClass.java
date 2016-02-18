package monks.location.service;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import monks.location.service.util.StoreSearchApiUtil;

public class NearestStoreTestClass {

	/*
	 * Update OAuth credentials below from the Yelp Developers API site:
	 * http://www.yelp.com/developers/getting_started/api_access
	 */
	private static final String CONSUMER_KEY = "0g_t1_QDCB1I2vm_eNtClg";
	private static final String CONSUMER_SECRET = "JUgGx3X6vNme9jcgxAcSryUdPEQ";
	private static final String TOKEN = "xVgENShX8UlT_Xci_fW8VB_kHchlfV1w";
	private static final String TOKEN_SECRET = "I6z_giUHlzqNqmCEkEVL1QMytXU";

	public static void main(String args[]) {

		String nearestStoreAddress = "";
		String zipcode = "tempe";
		String storeName = "walmart";

		StoreSearchApiUtil storeSearchObject = new StoreSearchApiUtil(CONSUMER_KEY, CONSUMER_SECRET, TOKEN, TOKEN_SECRET);
		String responseString = storeSearchObject.searchForNearbyStoreByLocation(storeName, zipcode);

		JSONParser parser = new JSONParser();
		try {

			// parsing response string using simple json parser
			JSONObject jsonObject = (JSONObject) parser.parse(responseString);
			long numOfStoresNearby = (long) jsonObject.get("total");

			// Checking if there is at least one store in the vicinity
			if (numOfStoresNearby > 0) {
				JSONArray arrayObject = (JSONArray) jsonObject.get("businesses");

				for (Object o : arrayObject) {
					JSONObject innerBusinessObject = (JSONObject) o;
					boolean isClosed = (boolean) innerBusinessObject.get("is_closed");

					if (!isClosed) {
						String matchingStoreName = (String) innerBusinessObject.get("name");
						nearestStoreAddress = matchingStoreName;

						JSONObject locationJsonObject = (JSONObject) innerBusinessObject.get("location");
						JSONArray displayAddressArray = (JSONArray) locationJsonObject.get("display_address");
						Iterator<String> iterator = displayAddressArray.iterator();

						while (iterator.hasNext()) {
							nearestStoreAddress = nearestStoreAddress + ", " + iterator.next();
						}
						break;
					}
				}
			} else {
				nearestStoreAddress = "Sorry, no stores found in vicinity with matching name!";
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
