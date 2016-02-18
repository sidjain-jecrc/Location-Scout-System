package monks.location.service.util;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

// Reference taken from https://www.yelp.com/developers/documentation/v2/overview
public class StoreSearchApiUtil {

	// Set search limit to return 3 results only
	private static final int SEARCH_LIMIT = 5;
	// Set search radius as maximum of 20 miles(approx. 33000 meters)
	private static final int SEARCH_RADIUS = 33000;
	// To retrieve results sorted by distance
	private static final int SORT_BY_DISTANCE = 1;

	// Store search API Url
	private final String storeSearchApiUrl = "https://api.yelp.com/v2/search";

	OAuthService service;
	Token accessToken;

	// Setup the Search API OAuth credentials.
	public StoreSearchApiUtil(String consumerKey, String consumerSecret, String token, String tokenSecret) {
		this.service = new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(consumerKey).apiSecret(consumerSecret).build();
		this.accessToken = new Token(token, tokenSecret);
	}

	// Creates and sends a request to the Search API by term and location.
	public String searchForNearbyStoreByLocation(String storeName, String zipcodeOrCityName) {
		OAuthRequest request = new OAuthRequest(Verb.GET, storeSearchApiUrl);
		request.addQuerystringParameter("term", storeName);
		request.addQuerystringParameter("location", zipcodeOrCityName);
		request.addQuerystringParameter("sort", String.valueOf(SORT_BY_DISTANCE));
		request.addQuerystringParameter("radius_filter", String.valueOf(SEARCH_RADIUS));
		request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
		return sendRequestAndGetResponse(request);
	}

	// Sends an OAuthRequest to Search API to fetch Response
	private String sendRequestAndGetResponse(OAuthRequest request) {
		this.service.signRequest(this.accessToken, request);
		Response response = request.send();
		return response.getBody();
	}

}
