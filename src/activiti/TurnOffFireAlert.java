package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import ubidotsCode.ubidots;

public class TurnOffFireAlert implements JavaDelegate {
	public void execute(DelegateExecution execution) 
	{
		String file="C:/Program Files/Apache Software Foundation/Tomcat 9.0/bin/activiti_data.json";
		String apiKeyUbidots=ubidots.returnJSONvalue("API key",file);
		String variableID=ubidots.returnJSONvalue("Incendio ID",file);//619b66682eccbc3257190b96
	int turnOffFire=0;
	ubidots.setValuefromUbidots(apiKeyUbidots,variableID,turnOffFire);
	}
}
