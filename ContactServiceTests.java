package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Contact.ContactService;

class ContactServiceTests {
	//This will clear the array lists after each of the tests
		@AfterEach
		void tearDown() throws Exception {
			ContactService.contactList.clear();
		}

		@DisplayName("Testing adding a Contact")
		@Test
		void testAddContact() {

			String contactID = "2";
	      	String firstName = "John";
	        String lastName = "Jeff";
	        String phoneNumber = "2222222222";
	        String address = "222222222wodjajdjw";

			ContactService test = new ContactService();

			assertTrue(ContactService.contactList.isEmpty());

			test.addContact(firstName, lastName, address, phoneNumber);

			assertFalse(ContactService.contactList.isEmpty());
			assertEquals(0, ContactService.contactList.get(0).getContactID());
			assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
			assertEquals(lastName, ContactService.contactList.get(0).getLastName());
			assertEquals(address, ContactService.contactList.get(0).getAddress());
			assertEquals(phoneNumber, ContactService.contactList.get(0).getNumber());

		}
		
		@DisplayName("Test deleteContact")			  
		@Test void testDeleteContact() {
					  
			String contactID = "2";
	      	String firstName = "John";
	        String lastName = "Jeff";
	        String phoneNumber = "2222222222";
	        String address = "222222222wodjajdjw";
	        boolean testBool = false;
			  
			ContactService test = new ContactService();
			  
			assertTrue(ContactService.contactList.isEmpty());
			 
			test.addContact(firstName, lastName, address, phoneNumber);//This is at ID 0
			test.addContact(firstName, lastName, address, phoneNumber);//This is at ID 1
			test.addContact(firstName, lastName, address, phoneNumber);//This is at ID 2
			  
			assertEquals(3,ContactService.contactList.size());
			  
			test.deleteContact("1");
			  
			assertEquals(2,ContactService.contactList.size());
			 
			//This loops through the array and checks the IDs
			for(int i = 0; i < ContactService.contactList.size(); i++) {
				if(ContactService.contactList.get(i).getContactID() == 1) {
					testBool = true;
				}
			}		
			assertFalse(testBool);				 
		}
		@DisplayName("Test editing a phone number")
		@Test
		void testEditPhone() {
			
			String contactID = "2";
	      	String firstName = "John";
	        String lastName = "Jeff";
	        String phoneNumber = "2222222222";
	        String address = "222222222wodjajdjw";
			  
			ContactService test = new ContactService();
			test.addContact(firstName, lastName, address, phoneNumber);
			
			assertEquals(phoneNumber, ContactService.contactList.get(0).getNumber());
			
			test.changeNumber(contactID, "2222222222");
			assertEquals("2222222222", ContactService.contactList.get(0).getNumber());
		}
		
		@DisplayName("Test editing a first name")
		@Test
		void testEditFirst() {
			
	      	String firstName = "John";
	        String lastName = "Jeff";
	        String phoneNumber = "2222222222";
	        String address = "222222222wodjajdjw";

			ContactService test = new ContactService();
			test.addContact(firstName, lastName, address, phoneNumber);
			
			assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
			
			test.changeFirstName("0", "Test");
			assertEquals("Test", ContactService.contactList.get(0).getFirstName());
		}
		
		@DisplayName("Test editing a last name")
		@Test
		void testEditLast() {
			
	      	String firstName = "John";
	        String lastName = "Jeff";
	        String phoneNumber = "2222222222";
	        String address = "222222222wodjajdjw";
			  
			ContactService test = new ContactService();
			test.addContact(firstName, lastName, address, phoneNumber);
			
			assertEquals(lastName, ContactService.contactList.get(0).getLastName());
			
			test.changeLastName("0", "Test");
			assertEquals("Test", ContactService.contactList.get(0).getLastName());
		}
		
		@DisplayName("Test editing an address")
		@Test
		void testEditAddress() {
			
			String firstName = "John";
	        String lastName = "Jeff";
	        String phoneNumber = "2222222222";
	        String address = "222222222wodjajdjw";;

			ContactService test = new ContactService();
			test.addContact(firstName, lastName, address, phoneNumber);
			
			assertEquals(address, ContactService.contactList.get(0).getAddress());
			
			test.changeAddress("0", "Test_Address");
			assertEquals("Test_Address", ContactService.contactList.get(0).getAddress());
		}

}
