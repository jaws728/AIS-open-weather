package activiti;

import ubidotsCode.ubidots;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class getHomeTemp implements JavaDelegate 
{
	public void execute(DelegateExecution execution) 
	{
		String file="C:/Program Files/Apache Software Foundation/Tomcat 9.0/bin/activiti_data.json";
		String apiKeyUbidots=ubidots.returnJSONvalue("API key",file);
		String variableID=ubidots.returnJSONvalue("Temperatura da Casa ID",file);
		
		double temp=ubidots.getValuefromUbidots(apiKeyUbidots,variableID);
		execution.setVariable("temperaturainterior", temp);
	}
}
