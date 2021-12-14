package activiti;
import java.time.LocalTime;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import ubidotsCode.ubidots;
public class controlMotor implements JavaDelegate {
	@Override
	public void execute(DelegateExecution execution) 
	{
		String file=".../../activiti_data.json";
		String apiKeyUbidots=ubidots.returnJSONvalue("API key",file);
		String motorID=ubidots.returnJSONvalue("Motor ID",file);//619b66682eccbc3257190b96

        LocalTime currentTime = LocalTime.now();
        //String motorStatus = "OFF";
        int motorOn = 0;

        if (currentTime.getHour() > 8) {
            //motorStatus = "ON";
            motorOn = 1;
        }
        if (currentTime.getHour() < 18) {
            //motorStatus = "OFF";
            motorOn = 0;
        }
        execution.setVariable("motor", motorOn);
        ubidots.setValuefromUbidots(apiKeyUbidots, motorID, motorOn);
	}
}
