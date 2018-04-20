package sdmd;

import java.util.Date;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.google.appengine.api.users.User;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

public abstract class PersistableEntity {
	
	@Id
	private Long id;

	protected PersistableEntity() {
	}
	
	public PersistableEntity(long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}
