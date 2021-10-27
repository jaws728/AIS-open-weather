package support;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPI {
	public WeatherAPI() {
	}
	
	public String MyGETRequest(String key, String city, String unit, String language) throws IOException {
		String value = null;
		
	    URL urlForGetRequest = new URL("http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID="+key+"&units="+unit+"&lang="+language);
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    conection.setRequestProperty("userId", "a1bcdef");
	    int responseCode = conection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        value = response.toString();
	    } else {
	        System.out.println("GET NOT WORKED");
	    }
	    
	    return value;
	}
	
	public void POSTRequest() throws IOException {
	    final String POST_PARAMS = "{\n" + "\"userId\": 101,\r\n" +
	        "    \"id\": 101,\r\n" +
	        "    \"title\": \"Test Title\",\r\n" +
	        "    \"body\": \"Test Body\"" + "\n}";
	    System.out.println(POST_PARAMS);
	    URL obj = new URL("https://jsonplaceholder.typicode.com/posts");
	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	    postConnection.setRequestProperty("userId", "a1bcdefgh");
	    postConnection.setRequestProperty("Content-Type", "application/json");
	    postConnection.setDoOutput(true);
	    OutputStream os = postConnection.getOutputStream();
	    os.write(POST_PARAMS.getBytes());
	    os.flush();
	    os.close();
	    int responseCode = postConnection.getResponseCode();
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	            postConnection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in .readLine()) != null) {
	            response.append(inputLine);
	        } in .close();
	        // print result
	        System.out.println(response.toString());
	    } else {
	        System.out.println("POST NOT WORKED");
	    }
	}
	
	public Double getTemp(String key, String city, String unit, String language) throws IOException {
		WeatherAPI wAPI = new WeatherAPI();
		JsonManager json = new JsonManager();
	    
	    String response = wAPI.MyGETRequest(key, city, unit, language);
	    //System.out.println("JSON String Result " + response.toString());
	    
	    Double temp = json.getJSONTemperature(response);
	    return temp;
	}
	
}

