package support;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ubidotsCode.ubidots;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Main {
/*{"API key":"BBFF-484f4a7c8258b9e1979edee2abfb0ff9db8",
"Temperatura da Casa ID":"6184ec66e96108847299d09a","Incendio ID":"619b66682eccbc3257190b96"}*/
	public static void main(String[] args) throws ParseException {
		
		/*JSONObject root;
		ObjectMapper mapper = new ObjectMapper();
		String file="C:/Users/Pedro Capelo/Desktop/activiti_data.json";
		String apiKeyUbidots=ubidots.returnJSONvalue("API key",file);
		String variableID=ubidots.returnJSONvalue("Temperatura da Casa ID",file);
		System.out.print(apiKeyUbidots);
		System.out.print(variableID);
		double temp=0;
		int i;
		for(i=0;i<10;i++) {
			temp+=ubidots.getValuefromUbidots(apiKeyUbidots,variableID);
			
		}
		double media=temp/i;
		System.out.print("Media"+media);
		temp=ubidots.getValuefromUbidots(apiKeyUbidots,variableID);
		System.out.print("Temperatura"+temp+"\n");
		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject1 = new JSONObject();
		//Inserting key-value pairs into the json object
		JSONObject main = new JSONObject();
		main.put("Command", "CreateNewUser");
		JSONObject user = new JSONObject();
		user.put("FirstName", "John");
		user.put("LastName", "Reese");
		JSONObject user1 = new JSONObject();
		user1.put("FirstName", "John");
		user1.put("LastName", "Reese");
		main.put("User", user1);
	    
	    try {
	    	File myObj = new File("C:/Users/Pedro Capelo/Desktop/activiti_data.json");
	        if (myObj.createNewFile()) {
	          System.out.println("File created: " + myObj.getName());
	        } else {
	          System.out.println("File already exists.");
	        }
	         FileWriter filejson = new FileWriter("C:/Users/Pedro Capelo/Desktop/activiti_data.json");
	         filejson.write(main.toJSONString());
	         
	         filejson.close();
	         root = mapper.readValue(new File("C:/Users/Pedro Capelo/Desktop/activiti_data.json"), JSONObject.class);
			System.out.println(root);
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      System.out.println("JSON file created: "+main);
	      	
	        
	        String key = "User"; //whatever
	        
	        JSONObject jo = new JSONObject();
	        jo.put(key,"200");
	        //Read from file
	       
			try {
				root = mapper.readValue(new File("C:/Users/Pedro Capelo/Desktop/activiti_data.json"), JSONObject.class);
				System.out.println(root.get("User"));
				Object user2=root.get("User");
				System.out.print(user2);
				JSONParser parser = new JSONParser(); 
				JSONObject jsonuser = (JSONObject) JSONValue.parse(new ObjectMapper().writeValueAsString(user2));
				jsonuser.put("Novo pair","gaaaay");
				System.out.println(jsonuser);
				String val_newer = jo.get(key).toString();
		        String val_older = root.get(key).toString();
		      //Compare values
		        if(!val_newer.equals(val_older))
		        {
		          //Update value in object
		           root.put(key,jsonuser);
		           System.out.println(root);
		           //Write into the file
		            try (FileWriter filejson = new FileWriter("C:/Users/Pedro Capelo/Desktop/activiti_data.json")) 
		            {
		            	filejson.write(root.toString());
		                System.out.println("Successfully updated json object to file...!!");
		            }
		        }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        

		String file="activiti_data.json";
		String apiKeyUbidots=ubidots.returnJSONvalue("API key",file);
		String variableID=ubidots.returnJSONvalue("Temperatura da Casa ID",file);
		
		double temp=ubidots.getValuefromUbidots(apiKeyUbidots,variableID);
		System.out.print(temp);
		
		
		
		String nomeDoUtilizador="Pedro";
		String temperaturaDeConforto="20";
		
		JSONObject user = new JSONObject();
		//Inserting key-value pairs into the json object
	    JSONObject jsonfiledata=new JSONObject();
	    ObjectMapper mapper = new ObjectMapper();
	    user.put("Temperatura de Conforto", temperaturaDeConforto);
	    user.put("Em Casa", "Afirmativo");
	    try {
	    	jsonfiledata = mapper.readValue(new File("C:/Users/Pedro Capelo/Desktop/activiti_data.json"), JSONObject.class);
	    	if(jsonfiledata.get(nomeDoUtilizador)!=null) {//user exists
	    		Object user2=jsonfiledata.get(nomeDoUtilizador);
				JSONObject jsonuser = (JSONObject) JSONValue.parse(new ObjectMapper().writeValueAsString(user2));
				jsonuser.put("Temperatura de Conforto", temperaturaDeConforto);
				jsonuser.put("Em Casa", "Afirmativo");
				System.out.println(jsonuser);
				jsonfiledata.put(nomeDoUtilizador,jsonuser);
	    	}else {//user does not exist
	    		jsonfiledata.put(nomeDoUtilizador,user);
	    		System.out.println(jsonfiledata);
	    	}
	    	//Write into the file
	        FileWriter jsonfile = new FileWriter("C:/Users/Pedro Capelo/Desktop/activiti_data.json");      
	        jsonfile.write(jsonfiledata.toString());
	        jsonfile.close();
	        System.out.println("Successfully updated json object to file...!!");
	        System.out.println(jsonfiledata);
	        
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        */
		String file="C:/Program Files/Apache Software Foundation/Tomcat 9.0/bin/activiti_data.json";
		String apiKeyUbidots=ubidots.returnJSONvalue("API key",file);
		String variableID=ubidots.returnJSONvalue("Temperatura da Casa ID",file);
		
		double temp=ubidots.getValuefromUbidots(apiKeyUbidots,variableID);
		System.out.println(temp);
		}

}
