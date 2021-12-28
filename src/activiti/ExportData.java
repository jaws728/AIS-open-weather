package activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import support.PathFile;
import ubidotsCode.Ubidots;

public class ExportData implements JavaDelegate {
	public void execute(DelegateExecution execution) 
	{
		//Assumindo que os valores foram feitos guardados no ubidots
		//Envia um sinal para exportar data
		
		PathFile fp = new PathFile();
		String file=fp.FilePath();
		
		String apiKeyUbidots=Ubidots.returnJSONvalue("APIkey",file);
		
		String ExpID=Ubidots.returnJSONvalue("ExportID",file);
		
		//Send command to smart mirror
		Ubidots.setValuefromUbidots(apiKeyUbidots, ExpID, 1);
	}
}
