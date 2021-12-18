package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import support.PathFile;
import ubidotsCode.Ubidots;

public class MotorOff  implements JavaDelegate{
	public void execute(DelegateExecution execution) 
	{
		//Assumir que o motor precisa de se desligar - class chamada pelo activiti
		PathFile fp = new PathFile();
		String file=fp.FilePath();
		String apiKeyUbidots=Ubidots.returnJSONvalue("APIkey",file);
		String A_ID=Ubidots.returnJSONvalue("A_MotorID",file);
		String R_ID=Ubidots.returnJSONvalue("R_MotorID",file);
		
		//Update ubidots
        Ubidots.setValuefromUbidots(apiKeyUbidots, A_ID, 0);
        Ubidots.setValuefromUbidots(apiKeyUbidots, R_ID, 0);
        
	}
}
