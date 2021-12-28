package activiti;
import java.time.LocalTime;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class MotorControl implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) 
	{
		/*
		PathFile fp = new PathFile();
		String file=fp.FilePath();
		String apiKeyUbidots=ubidots.returnJSONvalue("APIkey",file);
		String motorID=ubidots.returnJSONvalue("MotorID",file);
		*/
		
		///Motor comporta-se de forma semelhante ao LED
		
        LocalTime currentTime = LocalTime.now();
        int motorOn = -1;

        if (currentTime.getHour() >= 8  & currentTime.getHour() < 18) {
            motorOn = 1;
        }
        if (currentTime.getHour() >= 18 & currentTime.getHour() < 8) {
            motorOn = 0;
        }
        
        //Send to activiti
        execution.setVariable("motor", motorOn);
        
        /*
        //Update ubidot
        ubidots.setValuefromUbidots(apiKeyUbidots, motorID, motorOn);
        
        //Save to json
        JsonManager.saveJSONData("Estado do motor", Integer.toString(motorOn));
        */
	}
}
