package ubidotsCode;

import java.io.File;

import org.json.simple.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.ubidots.ApiClient;
import main.java.com.ubidots.Variable;

public class Ubidots {
	public Ubidots() {
	      
	}
	 public static Double getValuefromUbidots(String APIKey, String valueID) {
	        ApiClient api = new ApiClient(APIKey);
	        
	        Variable variable = api.getVariable(valueID);
	        return variable.getValues()[0].getValue();
	 }
	 public static void setValuefromUbidots(String APIKey, String valueID, float value) {
	        ApiClient api = new ApiClient(APIKey);
	        
	        Variable variable = api.getVariable(valueID);
	        variable.saveValue(value);
	 }
	 
	 public static String returnJSONvalue(String variableName, String file) {
		 //JSONParser parser = new JSONParser();
		 String valueJSON="No Value";
		 ObjectMapper mapper = new ObjectMapper();
		 JSONObject jsonObject = new JSONObject();
		 try {
			 jsonObject = mapper.readValue(new File(file), JSONObject.class);
			valueJSON = (String) jsonObject.get(variableName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return valueJSON;
	 }
}
