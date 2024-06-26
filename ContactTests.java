package tests;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import Contact.Contact;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ContactTests {

	@DisplayName("This tests a valid constructor")
	@Test
	void testGoodConstructor() {
	    String contactID = "1";
	    String firstName = "First";
	    String lastName = "Last";
	    String address = "123 street";
	    String phoneNumber = "1111111111";
	    
	    Contact testContact = new Contact(contactID, firstName, lastName, address, phoneNumber);
	    assertEquals(1, testContact.getContactID());
	    assertEquals(firstName, testContact.getFirstName());
	    assertEquals(lastName, testContact.getLastName());
	    assertEquals(address, testContact.getAddress());
	    assertEquals(phoneNumber, testContact.getNumber());
	}
	@DisplayName("This test is a invalid Constructor")
	@Test
	public void testBadConstructor() {
        String contactID = "2";
      	String firstName = "John";
        String lastName = "Jeff";
        String phoneNumber = "2";
        String address = "222222222wodjajdjw";    
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, address, phoneNumber);
        });
	}
	
	@DisplayName("This Test is a valid setFirstName")
	@Test
	public void testGoodSetFirst() {
        String contactID = "2";
      	String firstName = "John";
        String lastName = "Jeff";
        String phoneNumber = "2222222222";
        String address = "222222222wodjajdjw";
		
        Contact testContact = new Contact(contactID, firstName, lastName, address, phoneNumber);   
        testContact.setFirstName("Test");        
        assertEquals("Test", testContact.getFirstName());
	}
	
	@DisplayName("This tests a invalid null setFirstName")
	@Test
	public void testBadSetFirst() {
        String contactID = "2";
      	String firstName = "John";
        String lastName = "Jeff";
        String phoneNumber = "2222222222";
        String address = "222222222wodjajdjw";
		
        Contact testContact = new Contact(contactID, firstName, lastName, address, phoneNumber);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName(null);
        });
	}
	@DisplayName("This tests a too long setFirstName")
	@Test
	public void testLongSetFirst() {
        String contactID = "2";
      	String firstName = "John";
        String lastName = "Jeff";
        String phoneNumber = "2222222222";
        String address = "222222222wodjajdjw";
		
        Contact testContact = new Contact(contactID, firstName, lastName, address, phoneNumber);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setFirstName("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        });
	}
	@DisplayName("Testing a bad getID")
	@Test
	public void testBadGetID() {
        String contactID = "2";
      	String firstName = "John";
        String lastName = "Jeff";
        String phoneNumber = "2222222222";
        String address = "222222222wodjajdjw";
		
        Contact testContact = new Contact(contactID, firstName, lastName, address, phoneNumber);   
        assertNotEquals("3", testContact.getContactID());
	}
	@DisplayName("Test too long getID")
	@Test
	public void testlongGetID() {
		String contactID = "22222222222222222222";
      	String firstName = "John";
        String lastName = "Jeff";
        String phoneNumber = "2222222222";
        String address = "222222222wodjajdjw";
		
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	new Contact(contactID, firstName, lastName, address, phoneNumber);
        });
	}
	@DisplayName("Test an invalid null Number")
	@Test
	public void testBadSetPhone() {
		String contactID = "2";
      	String firstName = "John";
        String lastName = "Jeff";
        String phoneNumber = "2222222222";
        String address = "222222222wodjajdjw";
		
        Contact testContact = new Contact(contactID, firstName, lastName, address, phoneNumber);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setNumber(null);
        });
        
	}
	@DisplayName("Test an invalid length setPhoneNumber")
	@Test
	public void testWrongLengthPhone() {
		String contactID = "2";
      	String firstName = "John";
        String lastName = "Jeff";
        String phoneNumber = "2222222222";
        String address = "222222222wodjajdjw";
		
        Contact testContact = new Contact(contactID, firstName, lastName, address, phoneNumber);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setNumber("5");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setNumber("555555555555555555555555");
        });
	}
	@DisplayName("This Tests an invalid null setAddress")
	@Test
	public void testNullSetAddress() {
		String contactID = "2";
      	String firstName = "John";
        String lastName = "Jeff";
        String phoneNumber = "2222222222";
        String address = "222222222wodjajdjw";
		
        Contact testContact = new Contact(contactID, firstName, lastName, address, phoneNumber);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress(null);
        });
        
	}
	
	@DisplayName("This Tests an invalid length setPhoneNumber")
	@Test
	public void testWrongLengthAddress() {
		String contactID = "2";
      	String firstName = "John";
        String lastName = "Jeff";
        String phoneNumber = "2222222222";
        String address = "222222222wodjajdjw";
		
        Contact testContact = new Contact(contactID, firstName, lastName, address, phoneNumber);   
        
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
        	testContact.setAddress("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        });
	}

}
