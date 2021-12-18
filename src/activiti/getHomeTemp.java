package activiti;

import ubidotsCode.Ubidots;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import support.PathFile;

public class GetHomeTemp implements JavaDelegate 
{
	public void execute(DelegateExecution execution) 
	{
		///Just send arduino temp value to smart mirror
		
		PathFile fp = new PathFile();
		String file=fp.FilePath();
		String apiKeyUbidots=Ubidots.returnJSONvalue("APIkey",file);
		String A_ID=Ubidots.returnJSONvalue("A_TempIntID",file);
		String R_ID=Ubidots.returnJSONvalue("R_TempIntID",file);
		
		//Get temp from arduino
		float temp=Ubidots.getValuefromUbidots(apiKeyUbidots,A_ID).floatValue();
		
		//Send to activiti
		Ubidots.setValuefromUbidots(apiKeyUbidots, R_ID, temp);
		
	}
}
