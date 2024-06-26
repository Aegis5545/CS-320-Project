package Contact;
public class Contact {
	private String contactID;
	private String firstName;
	private String lastName;
	private String address;
	private String phoneNumber;
	
	//This makes sure the Contact ID is correct, and returns a true/false statement
	private final boolean validateID(String contactID) {
		if(contactID == null || contactID.length() > 10) {
			return false;
		}
		return true;
	}
	//This makes sure the last name is correct, and returns a true/false statement
		private final boolean validateLastName(String lastName) {
			if(lastName == null || lastName.length() > 10) {
				return false;
			}
			return true;
		}
		
		//This makes sure the first name is correct, and returns a true/false statement
				private final boolean validateFirstName(String firstName) {
					if(firstName == null || firstName.length() > 10) {
						return false;
					}
					return true;
				}
				//This makes sure the phone number is correct, and returns a true/false statement
				private final boolean validateNumber(String phoneNumber) {
					if(phoneNumber == null || phoneNumber.length() != 10) {
						return false;
					}
					return true;
				}
				//This makes sure the address is correct, and returns a true/false statement
				private final boolean validateAddress(String address) {
					if(address == null || address.length() > 30) {
						return false;
					}
					return true;
				}
				
				//This throws new IllegalArgument Exceptions
				public Contact(String contactID,
			               String firstName,
			               String lastName,
			               String address,
			               String phoneNumber) {
			    if (!this.validateID(contactID)) {
			        throw new IllegalArgumentException("Invalid contact ID");
			    }
			    
			    // Initialize the contactID field
			    this.contactID = contactID;
			    
			    if (!this.validateFirstName(firstName)) {
			        throw new IllegalArgumentException("Invalid first name");
			    }
			    this.firstName = firstName;
			    
			    if (!this.validateLastName(lastName)) {
			        throw new IllegalArgumentException("Invalid last name");
			    }
			    this.lastName = lastName;
			    
			    if (!this.validateAddress(address)) {
			        throw new IllegalArgumentException("Invalid address");
			    }
			    this.address = address;
			    
			    
			    if (!this.validateNumber(phoneNumber)) {
			        throw new IllegalArgumentException("Invalid Phone Number");
			    }
			    this.phoneNumber = phoneNumber;
			}
			
				//Getters and Setters
				public int getContactID() {
					return Integer.valueOf(contactID);
				}
				
				//First Name
				
				public String getFirstName() {
					return firstName;
				}
				
				/*This throws a message that the first name failed
				 * the validateFirstName function, and then sets this first name to
				 * new first name
				 * I will be using this same function for
				 * the other variables
				 */
				
				public void setFirstName(String firstName) {
					if(!this.validateFirstName(firstName)) {
						throw new IllegalArgumentException("This first name is Invalid");
					}
					this.firstName = firstName;
				}
				
				//Last Name
				public String getLastName() {
					return lastName;
				}
				public void setLastName(String lastName) {
					if(!this.validateLastName(lastName)) {
						throw new IllegalArgumentException("This last name is Invalid");
					}
					this.lastName = lastName;
				}
				
				//Address
				public String getAddress() {
					return address;
				}
				public void setAddress(String address) {
					if(!this.validateAddress(address)) {
						throw new IllegalArgumentException("This address is Invalid");
					}
					this.address = address;
				}
				
				//Phone Number
				public String getNumber() {
					return phoneNumber;
				}
				public void setNumber(String phoneNumber) {
					if(!this.validateNumber(phoneNumber)) {
						throw new IllegalArgumentException("This phone number is Invalid");
					}
					this.phoneNumber = phoneNumber;
				}
}
