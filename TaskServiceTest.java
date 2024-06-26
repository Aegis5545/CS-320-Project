package tasktests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import Tasks.TaskService;

class TaskServiceTest {

	@AfterEach
	void tearDown() throws Exception {
		TaskService.tasks.clear();
	}
//This creates a normal and valid task, should always pass
	@DisplayName("This should create a task")
	@Test
	void testAddUniqueTask() {
        String id = "0";
      	String fullName = "John Jeff";
        String desc = "This should be a proper description";
        
        TaskService tempTask = new TaskService();
        
        assertEquals(0, TaskService.tasks.size());
        
        tempTask.addUniqueTask(fullName, desc);
       
		assertTrue(TaskService.tasks.containsKey(id));
		assertEquals(fullName, TaskService.tasks.get(id).getName());
		assertEquals(desc, TaskService.tasks.get(id).getDescription());              
        
	}

	//This should add 2 new tasks, and deletes the task with the id of 1
	@DisplayName("Test deleteContact")			  
	@Test void testDeleteTask() {
				  
		String fullName = "John Jeff";
        String desc = "This should be a proper description";
		  
        TaskService tempTask = new TaskService();
        
        assertEquals(0, TaskService.tasks.size());

        tempTask.addUniqueTask(fullName, desc);
        tempTask.addUniqueTask(fullName, desc);
		  
		assertEquals(2,TaskService.tasks.size());
		  
		tempTask.deleteTasks("1");
		  
		assertEquals(1,TaskService.tasks.size());
		assertFalse(TaskService.tasks.containsKey("1"));
			 
	}
	//This will create a task and updates the ID with a valid ID number
	@DisplayName("Test updateTask with a good ID")
	@Test
	void testUpdateTasks() {
		String id = "0";
      	String fullName = "John Jeff";
        String desc = "This should be a proper description";
		  
        TaskService tempTask = new TaskService();
        
        tempTask.addUniqueTask(fullName, desc); //ID 1

        tempTask.updateTasks("0", fullName, "New description");
        assertEquals("New description", TaskService.tasks.get(id).getDescription());
        assertEquals(fullName, TaskService.tasks.get(id).getName());
        
	}
	
	//This will create a task and updates the ID with a invalid ID number
	@DisplayName("Test updateTask with a bad ID")
	@Test
	void testBadUpdateTasks() {
		String id = "0";
      	String fullName = "John Jeff";
        String desc = "This should be a proper description";
		  
        TaskService tempTask = new TaskService();
        
        tempTask.addUniqueTask(fullName, desc);

        tempTask.updateTasks("1", fullName, "New description");
        assertNotEquals("New description", TaskService.tasks.get(id).getDescription());
        assertEquals(fullName, TaskService.tasks.get(id).getName());
        
	}

}
