package monks.service.rest.ZipToLatLon;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@Path("zip")
public class ZipCodeConversion {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{zipcode}")
	public String getLatLonByZipCode(@PathParam("zipcode") String zipcode) {
		
		String apiUrl = "https://azure.geodataservice.net/GeoDataService.svc/GetUSDemographics?";
		String requestFormat = "json";
		String latLon = "";
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String uri = apiUrl + "zipcode=" + zipcode + "&$format=" + requestFormat;

		// building http request object for API request 
		HttpGet httpGetRequest = new HttpGet(uri);
		ResponseHandler<String> responseHandler = new BasicResponseHandler();
		JSONParser parser = new JSONParser();

		try {
			String responseBody = httpClient.execute(httpGetRequest, responseHandler);
			JSONObject jsonObject = (JSONObject) parser.parse(responseBody);
			JSONArray arrayObject = (JSONArray) jsonObject.get("d");

			double longitude = 0;
			double latitude = 0;

			for (Object o : arrayObject) {
				JSONObject innerObject = (JSONObject) o;
				longitude = (double) innerObject.get("Longitude");
				latitude = (double) innerObject.get("Latitude");
			}
			latLon = String.valueOf(latitude) + "," + String.valueOf(longitude);

		} catch (HttpResponseException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return latLon;

	}
}
