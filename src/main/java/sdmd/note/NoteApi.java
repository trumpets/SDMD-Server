package sdmd.note;

import static sdmd.OfyService.ofy;

import java.util.List;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.NotFoundException;
import com.googlecode.objectify.Key;

import sdmd.Constants;

@Api(name = "notes", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = { Constants.WEB_CLIENT_ID,
		Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID,
		Constants.API_EXPLORER_CLIENT_ID }, audiences = { Constants.ANDROID_AUDIENCE }, description = "notes api")
public class NoteApi {

	@ApiMethod(name = "createNote", path = "note", httpMethod = HttpMethod.POST)
	public Note createNote(final NoteForm form) {

		// Allocate Id first, in order to make the transaction idempotent.
		final Key<Note> key = Note.allocateKey();
		Note note = new Note(key.getId(), form);

		ofy().save().entity(note).now();

		return note;
	}

	@ApiMethod(name = "getNotes", path = "note", httpMethod = HttpMethod.GET)
	public List<Note> getNotes() {
		return ofy().load().type(Note.class).list();
	}
	
	@ApiMethod(name = "deleteNote", path = "note/{websafeKey}", httpMethod = HttpMethod.DELETE)
    public Note deleteNotet(@Named("websafeKey") final String websafeKey) throws NotFoundException {

        Key<Note> key = Key.create(websafeKey);
        final Note note = ofy().load().key(key).now();
        if (note == null) {
            throw new NotFoundException("No Note found with the key: " + websafeKey);
        }

        ofy().delete().entity(note).now();
        
        return note;
    }
}
 