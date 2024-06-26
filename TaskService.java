package Tasks;

import java.util.HashMap;

public class TaskService {
	
	int currenttaskID = 0; //setting the current task ID to 0
	
	public static HashMap<String, Task> tasks = new HashMap<String, Task>();
	
	public void addUniqueTask(String _name, String _description) {

		String stringID = Integer.toString(currenttaskID);		
		Task tempTask = new Task (stringID, _name, _description);
		tasks.put(stringID, tempTask);	

		++currenttaskID;		
	}
	
	public void deleteTasks(String _ID) {
		
		if(tasks.containsKey(_ID)) {			
			tasks.remove(_ID);
		}		
	}
	
	public void updateTasks(String _ID, String _newName, String _newDescription) {
		
		if(tasks.containsKey(_ID)) {
			
			tasks.get(_ID).setName(_newName);
			tasks.get(_ID).setDescription(_newDescription);
		}
		
	}
}