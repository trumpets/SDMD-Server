package sdmd.note;

public class NoteForm {

	private String content;
	private long dateInMillis;

	@SuppressWarnings("unused")
	private NoteForm() {
	}

	public NoteForm(String content, long dateInMillis) {
		super();
		this.content = content;
		this.dateInMillis = dateInMillis;
	}

	public String getContent() {
		return content;
	}

	public long getDateInMillis() {
		return dateInMillis;
	}
}
