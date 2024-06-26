package AppointmentTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import Appointment.AppointmentService;
import org.junit.jupiter.api.DisplayName;

class AppointmentServiceTesting {

	@AfterEach
	void tearDown() throws Exception {
		AppointmentService.appointments.clear();
	}

	@DisplayName("Adding a valid Appointment")
	@Test
	void testAddAppt() {
		String id = "0";
		String desc = "Valid Description";
		Calendar c = Calendar.getInstance();

		c.set(Calendar.MONTH, 06);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2024);

		Date goodDate = c.getTime();

		AppointmentService tempAppt = new AppointmentService();

		assertEquals(0, AppointmentService.appointments.size());

		tempAppt.addUniqueAppointment(goodDate, desc);

		assertTrue(AppointmentService.appointments.containsKey(id));
		assertEquals(goodDate, AppointmentService.appointments.get(id).getDate());
		assertEquals(desc, AppointmentService.appointments.get(id).getDescription());

	}

	@DisplayName("Appointment with a Null Description")
	@Test
	void testAddNullDesc() {
		String id = "0";
		String desc = null;
		Calendar c = Calendar.getInstance();

		c.set(Calendar.MONTH, 06);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2024);

		Date goodDate = c.getTime();

      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      		AppointmentService tempAppt = new AppointmentService();
      		tempAppt.addUniqueAppointment(goodDate, desc);
        });
      	assertEquals("Invalid description", exception.getMessage());

	}
	@DisplayName("This should delete appointments")
	@Test
	void testDeleteAppt() {

		String id = "0";
		String desc = "Valid Description";
		Calendar c = Calendar.getInstance();

		c.set(Calendar.MONTH, 06);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2024);

		Date goodDate = c.getTime();

		AppointmentService tempAppt = new AppointmentService();

		assertEquals(0, AppointmentService.appointments.size());

		tempAppt.addUniqueAppointment(goodDate, desc);
		tempAppt.addUniqueAppointment(goodDate, desc);
		tempAppt.addUniqueAppointment(goodDate, desc);

		assertEquals(3, AppointmentService.appointments.size());

		tempAppt.deleteAppointment("1");

		assertEquals(2, AppointmentService.appointments.size());
		assertFalse(AppointmentService.appointments.containsKey("1"));
		
		tempAppt.deleteAppointment("1");
		assertEquals(2, AppointmentService.appointments.size());

	}
	@DisplayName("This tests for an appointment with an empty description")
	@Test
	void testAddEmptyDesc() {
		String id = "0";
		String desc = "";
		Calendar c = Calendar.getInstance();

		c.set(Calendar.MONTH, 06);
		c.set(Calendar.DATE, 30);
		c.set(Calendar.YEAR, 2024);

		Date goodDate = c.getTime();

      	IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
      		AppointmentService tempAppt = new AppointmentService();
      		tempAppt.addUniqueAppointment(goodDate, desc);
        });
      	
      	assertEquals("Invalid description", exception.getMessage());

	}

}
