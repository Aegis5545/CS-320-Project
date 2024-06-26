package Contact;
import java.util.List;
import java.util.ArrayList;


public class ContactService {
	int currentID = 0; //setting the current ID
	
	//This creates a new array list to hold the objects in
	public static List<Contact> contactList = new ArrayList<Contact>();
	
	//This adds a contact with a unique ID
	public void addContact(String firstName, String lastName, String address, String phoneNumber) {
		String stringID = Integer.toString(currentID);
		
		Contact newContact = new Contact(stringID, firstName, lastName, address, phoneNumber);
		contactList.add(newContact.getContactID(),newContact);
		
		//Make sure the ID value increases per entry
		++currentID;
	}
	
	//This deletes the contact using the contact ID
	public void deleteContact(String ID) {
		int intID = Integer.valueOf(ID);
		
		for(int i = 0; i < ContactService.contactList.size(); i++) {
			if(ContactService.contactList.get(i).getContactID() == intID) {
				contactList.remove(i);
			}
		}
	}
	
	//This changes the first name of a Contact
	public void changeFirstName(String contactID, String firstName) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setFirstName(firstName);
			}
		}
	}
	
	//This Changes the last name of a Contact
	public void changeLastName(String contactID, String lastName) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setLastName(lastName);
			}
		}
	}
	
	//This Changes the address of a Contact
	public void changeAddress(String contactID, String address) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setAddress(address);
			}
		}
	}
	
	//This Changes the Phone Number of a Contact
	public void changeNumber(String contactID, String phoneNumber) {
		for(Contact iter : contactList) {
			if(iter.getContactID() == Integer.valueOf(contactID)) {
				iter.setNumber(phoneNumber);
			}
		}
	}
}
