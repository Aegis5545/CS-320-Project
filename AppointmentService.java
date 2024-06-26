package Appointment;

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {
	
int currentIDNum = 0; //Setting currentID number to 0
	
	public static HashMap<String, Appointment> appointments = new HashMap<String, Appointment>();
	
	public void addUniqueAppointment(Date _date, String _desc) {

		String stringID = Integer.toString(currentIDNum);		
		Appointment tempAppointment = new Appointment (stringID, _date, _desc);
		appointments.put(stringID, tempAppointment);	

		++currentIDNum;		//Iterates the currentIDNum
	}
	//Removes appointment by ID
	public void deleteAppointment(String _ID) {
		
		if(appointments.containsKey(_ID)) {			
			appointments.remove(_ID);
		}		
	}
}