package AppointmentTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import java.util.Date;
import java.util.Calendar;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;

class AppointmentTesting {

	@DisplayName("This tests a valid test case")
	@Test
	void testAppointment() {
        String id = "1";
        Calendar c = Calendar.getInstance();
        String desc = "Valid Description";
        
      	c.set(Calendar.MONTH, 06);
      	c.set(Calendar.DATE, 30);
      	c.set(Calendar.YEAR, 2024);
      	
      	Date goodDate = c.getTime();
        
        Appointment tempAppt = new Appointment(id, goodDate, desc);
        
        assertEquals(1, tempAppt.getUniqueID());
        assertEquals(goodDate, tempAppt.getDate());
        assertEquals(desc, tempAppt.getDescription());
	}
	@DisplayName("Test constructor with a id null")
	@Test
	void testNullID() {
        String id = null;
      	Date date = new Date();
        String desc = "Valid Description";
               
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, date, desc);
        });
        
        assertEquals("Invalid ID", exception.getMessage());
        
	}
	@DisplayName("Test constructor with too long of an ID")
	@Test
	void testLongAppointment() {
        String id = "44444444444444444444444";
      	Date date = new Date();
        String desc = "This is a good description";
               
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, date, desc);
        });
        
        assertEquals("Invalid ID", exception.getMessage());
        
	}
	@DisplayName("Test empty description")
	@Test
	void testEmptyDesc() {
        String id = "1";
      	String desc = "";    	
      	Calendar c = Calendar.getInstance();
      	
      	c.set(Calendar.MONTH, 06);
      	c.set(Calendar.DATE, 30);
      	c.set(Calendar.YEAR, 2024);
      	
      	Date goodDate = c.getTime();
      	              
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, goodDate, desc);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());
	}
	@DisplayName("Tests for a null description")
	@Test
	void testNullDesc() {
        String id = "1";
      	String desc = null;    	
      	Calendar c = Calendar.getInstance();
      	
      	c.set(Calendar.MONTH, 06);
      	c.set(Calendar.DATE, 30);
      	c.set(Calendar.YEAR, 2024);
      	
      	Date goodDate = c.getTime();
      	              
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, goodDate, desc);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());
	}
	@DisplayName("Tests for too long of a description")
	@Test
	void testLongDesc() {
        String id = "1";
      	String desc = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";    	
      	Calendar c = Calendar.getInstance();
      	
      	c.set(Calendar.MONTH, 06);
      	c.set(Calendar.DATE, 30);
      	c.set(Calendar.YEAR, 2024);
      	
      	Date goodDate = c.getTime();
      	
      	
      	Appointment tempAppt = new Appointment(id, goodDate, "test");
      	              
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, goodDate, desc);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());
      	
      	exception = assertThrows(IllegalArgumentException.class, () -> {
        	tempAppt.setDescription(desc);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());
	}
	@DisplayName("Tests for past date")
	@Test
	void testBadDate() {
        String id = "1";
        Calendar c = Calendar.getInstance();
      	String desc = "Valid Description";
      	
      	c.set(Calendar.MONTH, 06);
      	c.set(Calendar.DATE, 30);
      	c.set(Calendar.YEAR, 2023);
      	
      	Date badDate = c.getTime();
      	              
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, badDate, desc);
        });
      	
      	assertEquals("Invalid date", exception.getMessage());
        
	}
	@DisplayName("Tests for a null date")
	@Test
	void testNullDate() {
        String id = "1";
      	String desc = "Valid Description";    	
      	Date badDate = null;
      	
      	Calendar c = Calendar.getInstance();
      	
      	c.set(Calendar.MONTH, 06);
      	c.set(Calendar.DATE, 30);
      	c.set(Calendar.YEAR, 2024);
      	
      	Date goodDate = c.getTime();
      	
      	Appointment tempAppt = new Appointment(id, goodDate, desc);      	
      	              
      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        	new Appointment(id, badDate, desc);
        });
      	
      	assertEquals("Invalid date", exception.getMessage());
      	
      	exception = assertThrows(IllegalArgumentException.class, () -> {
        	tempAppt.setDate(null);
        });
      	
      	assertEquals("Invalid date", exception.getMessage());
	}
}
