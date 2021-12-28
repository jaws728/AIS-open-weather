package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import java.io.IOException;

import support.PathFile;
import support.WeatherAPI;
import ubidotsCode.Ubidots;

public class GetTempActiviti implements JavaDelegate 
{
	public void execute(DelegateExecution execution) 
	{
		//<variável para receber o valor> = execution.getVariable("<Nome da variável usada no Activiti>");
		//Obter temp a partir de api open weather
		WeatherAPI wAPI = new WeatherAPI();
		
		PathFile fp = new PathFile();
		String file=fp.FilePath();
		String key=Ubidots.returnJSONvalue("WeatherAPIkey",file);
		String apiKeyUbidots=Ubidots.returnJSONvalue("API key",file);
		String tempID=Ubidots.returnJSONvalue("TempExID",file);
		
		String city = "Almada,pt";
		String unit = "metric";
		String language = "pt";
		
		try 
		{
			//Get from open weather api
			float temp = (float)wAPI.getTemp(key,city,unit,language);
			//System.out.println(temp);
			//Send to smart mirror
			Ubidots.setValuefromUbidots(apiKeyUbidots, tempID, temp);
			
			//execution.setVariable("temperaturaexterior", temp);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}								
	}
}
