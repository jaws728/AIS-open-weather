package ubidotsCode;

import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.ubidots.ApiClient;
import main.java.com.ubidots.Variable;

public class ubidots {
	public ubidots() {
	      
	}
	 public static Double getValuefromUbidots(String APIKey, String valueID) {
	        ApiClient api = new ApiClient(APIKey);
	        
	        Variable variable = api.getVariable(valueID);
	        return variable.getValues()[0].getValue();
	 }
	 public static void setValuefromUbidots(String APIKey, String valueID, int fireValue) {
	        ApiClient api = new ApiClient(APIKey);
	        
	        Variable variable = api.getVariable(valueID);
	        variable.saveValue(fireValue);
	 }
	 
	 public static String returnJSONvalue(String variableName, String file) {
		 JSONParser parser = new JSONParser();
		 String valueJSON="No Value";
		 ObjectMapper mapper = new ObjectMapper();
		 JSONObject jsonObject;
		 try {
			 
			 jsonObject = mapper.readValue(new File(file), JSONObject.class);
	 
				
			 	
				// A JSON array. JSONObject supports java.util.List interface.
				valueJSON = (String) jsonObject.get(variableName);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		 return valueJSON;
	 }
}
