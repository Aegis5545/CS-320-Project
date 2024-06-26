package Tasks;

public class Task {
	private String taskID;
	private String fullName;
	private String desc;
	
	//This validates the taskID and returns true/false
	private final boolean validateID(String taskID) {
		if(taskID == null || taskID.length() > 10) {
			return false;			
		}		
		return true;
	}
	
	//This validates the fullName and returns boolean
	private final boolean validateName(String fullName) {
		if(fullName == null || fullName.length() > 20 || fullName.equals("")) {
			return false;			
		}
		return true;
	}
	//This validates the description and returns boolean
	private final boolean validateDescription(String desc) {
		if(desc == null || desc.length() > 50 || desc.equals("")) {	
			return false;			
		}
		return true;
	}
	
	
	public Task(String taskID, 
			String fullName, 
			String desc) {
		
		if(!this.validateID(taskID)) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if(!this.validateName(fullName)) {
			throw new IllegalArgumentException("Invalid name");
		}
		
		if(!this.validateDescription(desc)) {
			throw new IllegalArgumentException("Invalid description");
		}		

		//setting everything
		setID(taskID);
		setName(fullName);
		setDescription(desc);

	}

	//getting everything
	public int getUniqueID() {
		return Integer.valueOf(taskID);
	}

	
	private void setID(String taskID){ 
		this.taskID = taskID; 
	}
	 

	public String getName() {
		return fullName;
	}

	//Making sure the name is valid, then setting the name, if invalid, throws an error
	public void setName(String fullName) {
		if(!this.validateName(fullName)) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.fullName = fullName;
	}
	//gets description
	public String getDescription() {
		return desc;
	}

	//Making sure description is valid and then setting description, if invalid throws an error
	public void setDescription(String desc) {
		if(!this.validateDescription(desc)) {
			throw new IllegalArgumentException("Invalid Description");
		}
		this.desc = desc;
	}

}
