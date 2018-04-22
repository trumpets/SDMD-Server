package sdmd.contact;

public class ContactForm {

	private String firstName;
	private String lastName;
	private String phone;

	@SuppressWarnings("unused")
	private ContactForm() {
	}

	public ContactForm(String firstName, String lastName, String phone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}
}
