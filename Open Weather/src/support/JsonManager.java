package support;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonManager {
	public JsonManager() {
	}
	
	public Double getJSONTemperature(String jsonStr) {
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject) parser.parse(jsonStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = (JSONObject) obj;
        JSONObject mainList = (JSONObject) jsonObject.get("main");        
        Double temp = (Double) mainList.get("temp");


        return temp;
    }
	
}
