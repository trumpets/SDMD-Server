package sdmd.note;


import static sdmd.OfyService.factory;

import com.googlecode.objectify.Key;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;

import sdmd.PersistableEntity;

@Entity
@Cache
public class Note extends PersistableEntity {
	
	public static Key<Note> createKey(long id) {
		return Key.create(Note.class, id);
	}
	
	public static Key<Note> allocateKey() {
		return factory().allocateId(Note.class);
	}

	private String content;
	private long dateInMillis;
	
	@SuppressWarnings("unused")
	private Note(){}
	
	public Note(long id, NoteForm form) {
		super(id);
		this.updateWithNoteForm(form);
	}
	
	public void updateWithNoteForm(NoteForm form) {
		this.content = form.getContent();
		this.dateInMillis = form.getDateInMillis();
	}
	
	public String getWebsafeKey() {
        return createKey(this.getId()).toString();
    }

	public String getContent() {
		return content;
	}

	public long getDateInMillis() {
		return dateInMillis;
	}
}
