package tasktests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import Tasks.Task;

class TaskTest {
	//This tests for a valid entry
	@DisplayName("Valid Constructor")
	@Test
	void validContsructor() {
		
        String id = "1";
      	String fullName = "Jeff Jefferson";
        String desc = "Jeff jefferson is a valid man";

		
        Task tempTask = new Task(id, fullName, desc);
        
		assertEquals(1, tempTask.getUniqueID());
		assertEquals(fullName, tempTask.getName());
		assertEquals(desc, tempTask.getDescription());		
	}
	//This tests for an invalid entry with a desc too long
		@DisplayName("Long Desc Constructor")
		@Test
		void longdescContsructor() {
			
	        String id = "1";
	      	String fullName = "Jeff Jefferson";
	        String desc = "Jeff jefferson is a valid mannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";

			
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        	new Task(id, fullName, desc);		
		});
		}
	//This tests for a null ID
		@DisplayName("Null ID Constructor")
		@Test
		void nullIDContsructor() {
			
	        String id = null;
	      	String fullName = "Jeff Jefferson";
	        String desc = "Jeff jefferson is a valid man";

			
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        	new Task(id, fullName, desc);		
		});
		}
	//This tests for invalid ID number
		@DisplayName("Invalid ID Constructor")
		@Test
		void invalidIDContsructor() {
			
	        String id = "198534798275649256797257";
	      	String fullName = "Jeff Jefferson";
	        String desc = "Jeff jefferson is a valid man";

			
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        	new Task(id, fullName, desc);		
		});
		}
	//This tests for a null full name
		@DisplayName("Null Name Constructor")
		@Test
		public void nullNameConstructor() {
			String id = "1";
			String fullName = "Jeff Jefferson";
	        String desc = "Jeff jefferson is a valid man";
	        
	        Task tempTask = new Task(id, fullName, desc);
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        	tempTask.setName(null);
	        });
		}
	//This tests for an invalid full name
		@DisplayName("Invalid Name Constructor")
		@Test
		public void invalidNameConstructor() {
			String id = "1";
			String fullName = "Jeff Jefferson";
	        String desc = "Jeff jefferson is a valid man";
	        
	        Task tempTask = new Task(id, fullName, desc);
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        	tempTask.setName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	        });
		}
	//This tests for a blank description
		@DisplayName("Blank Desc Constructor")
		@Test
		public void blankDescConstructor() {
			String id = "1";
			String fullName = "Jeff Jefferson";
	        String desc = "Jeff jefferson is a valid man";
	        
	        Task tempTask = new Task(id, fullName, desc);
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        	tempTask.setName("");
	        });
		}
	//This tests for a blank fullName
		@DisplayName("Blank Name Constructor")
		@Test
		public void blankNameConstructor() {
			String id = "1";
			String fullName = "Jeff Jefferson";
	        String desc = "Jeff jefferson is a valid man";
	        
	        Task tempTask = new Task(id, fullName, desc);
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        	tempTask.setName("");
	        });
		}
	//This tests for null description
		@DisplayName("Null Desc Constructor")
		@Test
		public void nullDescConstructor() {
			String id = "1";
			String fullName = "Jeff Jefferson";
	        String desc = null;
	        
	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        	new Task(id, fullName, desc);
	        });
		}
}
