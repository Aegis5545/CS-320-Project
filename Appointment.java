package Appointment;

import java.util.Date;

public class Appointment {
		
	private String uniqueID;
	private Date date;
	private String desc;

	
	
	 //This validates a unique ID
	private final boolean validateID(String uniqueID) {
		if(uniqueID == null || uniqueID.length() > 10) {
			return false;			
		}		
		return true;
	}
	
	//This validates the name
	private final boolean validateDate(Date _date) {
		
		if(_date == null || _date.before(new Date())) {
			return false;			
		}
		return true;
	}
	//This validates the description
	private final boolean validateDescription(String desc) {
		if(desc == null || desc.length() > 50 || desc.equals("")) {	
			return false;			
		}
		return true;
	}
	
	
	public Appointment(String uniqueID, 
			Date date, 
			String desc) {
		
		if(!this.validateID(uniqueID)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(!this.validateDate(date)) {
			throw new IllegalArgumentException("Invalid date");
		}
		
		if(!this.validateDescription(desc)) {
			throw new IllegalArgumentException("Invalid description");
		}		

		
		setID(uniqueID);
		setDate(date);
		setDescription(desc);

	}

	public int getUniqueID() {
		return Integer.valueOf(uniqueID);
	}

	
	private void setID(String uniqueID){ 
		this.uniqueID = uniqueID; 
	}
	 

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		if(!this.validateDate(date)) {
			throw new IllegalArgumentException("Invalid date");
		}
		this.date = date;
	}
	
	public String getDescription() {
		return desc;
	}

	public void setDescription(String desc) {
		if(!this.validateDescription(desc)) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.desc = desc;
	}
}