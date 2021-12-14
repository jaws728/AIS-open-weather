package support;

import ubidotsCode.ubidots;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file=".../../activiti_data.json";
		String apiKeyUbidots=ubidots.returnJSONvalue("API key",file);
		String motorID=ubidots.returnJSONvalue("Motor ID",file);//619b66682eccbc3257190b96
		
        ubidots.setValuefromUbidots(apiKeyUbidots, motorID, 1);
        Double value = ubidots.getValuefromUbidots(apiKeyUbidots, motorID);
        System.out.println("Motor value: "+ value);
	}

}
                                                                               