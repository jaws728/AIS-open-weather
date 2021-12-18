  package activiti;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import support.PathFile;
import ubidotsCode.Ubidots;
public class FireAlert implements JavaDelegate {
	public void execute(DelegateExecution execution) 
	{
		PathFile fp = new PathFile();
		String file=fp.FilePath();
		String apiKeyUbidots=Ubidots.returnJSONvalue("APIkey",file);
		String fireID=Ubidots.returnJSONvalue("FireID",file);
		
		double alert=Ubidots.getValuefromUbidots(apiKeyUbidots,fireID);
		
		//Send to activiti
        execution.setVariable("fireAlert", (int)alert);
	}
}
