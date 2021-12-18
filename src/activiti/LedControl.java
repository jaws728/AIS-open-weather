package activiti;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import support.*;
import ubidotsCode.Ubidots;
public class LedControl implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) 
	{
		///LEDs DESCRICAO:
		///Arduino recebe o comando do smart mirror a pedir ligar/desligar LED
		///Smart Mirror: envia comando
		///Arduino: recebe comando e mantem-se no estado actual

		PathFile fp = new PathFile();
		String file=fp.FilePath();
		String apiKeyUbidots=Ubidots.returnJSONvalue("APIkey",file);
		
		//Get LED IDs
		String A_ID=Ubidots.returnJSONvalue("A_LedID",file); //receive command
		String R_ID=Ubidots.returnJSONvalue("R_LedID",file); //send command
		
		//Get LED command and LED state
		double ledState = Ubidots.getValuefromUbidots(apiKeyUbidots, A_ID); //0 or 1
		double ledCommand = Ubidots.getValuefromUbidots(apiKeyUbidots, R_ID); //0 or 1
		
		int led = -1;
		
		//state!=command then change state
        if (ledCommand != ledState) {
            led = (int)ledCommand;
        }

        //Send result to activiti
        execution.setVariable("led", led);
        
	}
}
