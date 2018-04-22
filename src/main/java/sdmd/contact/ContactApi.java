package sdmd.contact;

import static sdmd.OfyService.ofy;

import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.NotFoundException;
import com.googlecode.objectify.Key;

import sdmd.Constants;

@Api(name = "contacts", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = { Constants.WEB_CLIENT_ID,
		Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID,
		Constants.API_EXPLORER_CLIENT_ID }, audiences = { Constants.ANDROID_AUDIENCE }, description = "contacts api")
public class ContactApi {

	@ApiMethod(name = "createContact", path = "contact", httpMethod = HttpMethod.POST)
	public Contact createContact(final ContactForm form) {

		// Allocate Id first, in order to make the transaction idempotent.
		final Key<Contact> key = Contact.allocateKey();
		Contact contact = new Contact(key.getId(), form);

		ofy().save().entity(contact).now();

		return contact;
	}

	@ApiMethod(name = "getContacts", path = "contact", httpMethod = HttpMethod.GET)
	public List<Contact> getContacts() {
		return ofy().load().type(Contact.class).list();
	}
	
	@ApiMethod(name = "deleteContact", path = "contact/{websafeKey}", httpMethod = HttpMethod.DELETE)
    public Contact deleteContact(@Named("websafeKey") final String websafeKey) throws NotFoundException {

        Key<Contact> key = Key.create(websafeKey);
        final Contact contact = ofy().load().key(key).now();
        if (contact == null) {
            throw new NotFoundException("No Contact found with the key: " + websafeKey);
        }

        ofy().delete().entity(contact).now();
        
        return contact;
    }
}
 