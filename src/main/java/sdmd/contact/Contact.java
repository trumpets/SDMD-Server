package sdmd.contact;


import static sdmd.OfyService.factory;

import com.googlecode.objectify.Key;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;

import sdmd.PersistableEntity;

@Entity
@Cache
public class Contact extends PersistableEntity {
	
	public static Key<Contact> createKey(long id) {
		return Key.create(Contact.class, id);
	}
	
	public static Key<Contact> allocateKey() {
		return factory().allocateId(Contact.class);
	}

	private String firstName;
	private String lastName;
	private String phone;
	
	@SuppressWarnings("unused")
	private Contact(){}
	
	public Contact(long id, ContactForm form) {
		super(id);
		this.updateWithContactForm(form);
	}
	
	public void updateWithContactForm(ContactForm form) {
		this.firstName = form.getFirstName();
		this.lastName = form.getLastName();
		this.phone = form.getPhone();
	}
	
	public String getWebsafeKey() {
        return createKey(this.getId()).getString();
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
