package support;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import ubidotsCode.Ubidots;

public class JsonManager {
	public JsonManager() {
	}
	
	public double getJSONTemperature(String jsonStr) {
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject) parser.parse(jsonStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = (JSONObject) obj;
        JSONObject mainList = (JSONObject) jsonObject.get("main");        
        double temp = (double) mainList.get("temp");


        return temp;
    }
	public long getJSONHumidity(String jsonStr) {
        JSONParser parser = new JSONParser();
        JSONObject obj = null;
        try {
            obj = (JSONObject) parser.parse(jsonStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = (JSONObject) obj;
        JSONObject mainList = (JSONObject) jsonObject.get("main");        
        long hum = (long) mainList.get("humidity");


        return hum;
    }
	public static void saveJSONData(String key, String changes) {
		
		PathFile fp = new PathFile();
		String file=fp.FilePath();

        //Read from file
		ObjectMapper mapper = new ObjectMapper();
        JSONObject jsonObj = null;
        String val_older = null;
		try {
			jsonObj = mapper.readValue(new File(file), JSONObject.class);
			val_older = (String) jsonObj.get(key);
		} catch (IOException e) {
			e.printStackTrace();
		}

        //Compare values
        if(!changes.equals(val_older))
        {
          //Update value in object
        	jsonObj.put(key,changes);

           //Write into the file
            try (FileWriter f = new FileWriter(file)) 
            {
                f.write(jsonObj.toString());
                f.close();
                System.out.println("Successfully updated json object to file...!!");
            } catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
}
