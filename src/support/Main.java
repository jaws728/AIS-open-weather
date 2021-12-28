package support;

import ubidotsCode.Ubidots;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PathFile fp = new PathFile();
		String file=fp.FilePath();
		String apiKeyUbidots=Ubidots.returnJSONvalue("APIkey",file);
		System.out.println(apiKeyUbidots);
		String A_ID=Ubidots.returnJSONvalue("A_TempIntID",file);
		//String R_ID=Ubidots.returnJSONvalue("R_TempIntID",file);
		float temp=Ubidots.getValuefromUbidots(apiKeyUbidots,A_ID).floatValue();
		System.out.println(temp);
		activiti.GetTempActiviti a = new activiti.GetTempActiviti();
		//System.out.println(a);
		a.execute(null);
	}

}
