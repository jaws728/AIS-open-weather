package activiti;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import java.io.IOException;

import support.AccuWeatherAPI;
import support.WeatherAPI;

public class getTempActiviti implements JavaDelegate {
	public void execute(DelegateExecution execution) {
	
		/*
		WeatherAPI wAPI = new WeatherAPI();
		String key =  "0c72e0670fb7e6bf0d188a765e70ea44";
		String city = "Almada,pt";
		String unit = "metric";
		String language = "pt";
		
		Double temp = null;
		*/
		
		AccuWeatherAPI awAPI = new AccuWeatherAPI();
		String key =  "6MeUwcXDForJGvPcCqRKD1QtOLRrMUvS";
		int city = 274087;
		boolean details = false;
		String lang = "pt";
		
		Double temp = null;
		
		try {
			temp = awAPI.getTemp(key, city, details, lang);
			//temp = wAPI.getTemp(key, city, unit, language);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		execution.setVariable("temperaturaexterior", temp);
		
		Object homeTemp = execution.getVariable("temperaturadacasa");
		String hvac = "OFF";
		if (!homeTemp.equals(temp)) {
			hvac = "ON";
		} 
		execution.setVariable("hvac", hvac);
	}
}

//C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps\activiti-app\WEB-INF\lib