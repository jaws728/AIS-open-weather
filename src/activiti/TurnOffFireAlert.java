package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import support.PathFile;
import ubidotsCode.Ubidots;

public class TurnOffFireAlert implements JavaDelegate {
	public void execute(DelegateExecution execution) 
	{
		PathFile fp = new PathFile();
		String file=fp.FilePath();
		String apiKeyUbidots=Ubidots.returnJSONvalue("APIkey",file);
		String alertID=Ubidots.returnJSONvalue("AlarmeID",file);
		//int turnOffFire=0;
		Ubidots.setValuefromUbidots(apiKeyUbidots, alertID, 0);
	}
}
