package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import support.PathFile;
import ubidotsCode.Ubidots;

public class LedOff  implements JavaDelegate{
	public void execute(DelegateExecution execution) 
	{
		///Assume-se que o activiti verificou o caminho para tras
		///Basta enviar o sinal desligar para arduino
		PathFile fp = new PathFile();
		String file=fp.FilePath();
		String apiKeyUbidots=Ubidots.returnJSONvalue("APIkey",file);
		String A_ID=Ubidots.returnJSONvalue("A_LedID",file); //receive command
		
		//Send command to arduino
		Ubidots.setValuefromUbidots(apiKeyUbidots, A_ID, 0);
	}
}
