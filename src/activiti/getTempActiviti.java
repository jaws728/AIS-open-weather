package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import java.io.IOException;

import support.WeatherAPI;

public class getTempActiviti implements JavaDelegate 
{
	public void execute(DelegateExecution execution) 
	{
		//
		//<variável para receber o valor> = execution.getVariable("<Nome da variável usada no Activiti>");
		// TODO Auto-generated method stub
				WeatherAPI wAPI = new WeatherAPI();
				String key =  "0c72e0670fb7e6bf0d188a765e70ea44";
				String city = "Almada,pt";
				String unit = "metric";
				String language = "pt";
				
				
				try 
				{
					long humidity;
					double temp;
					humidity = wAPI.getHumidity(key,city,unit,language);
					temp = wAPI.getTemp(key,city,unit,language);
					execution.setVariable("temperaturaexterior", temp);
					//System.out.print(temp);
				}
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}								
	}
}
