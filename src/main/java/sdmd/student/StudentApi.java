package sdmd.student;

import static sdmd.OfyService.ofy;

import java.util.List;

import sdmd.Constants;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.googlecode.objectify.Key;

@Api(name = "students", version = "v1", scopes = { Constants.EMAIL_SCOPE }, clientIds = { Constants.WEB_CLIENT_ID,
		Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID,
		Constants.API_EXPLORER_CLIENT_ID }, audiences = { Constants.ANDROID_AUDIENCE }, description = "students api")
public class StudentApi {

	@ApiMethod(name = "createStudent", path = "student", httpMethod = HttpMethod.POST)
	public Student createStudent(final StudentForm form) {

		// Allocate Id first, in order to make the transaction idempotent.
		final Key<Student> key = Student.allocateKey();
		Student student = new Student(key.getId(), form);

		ofy().save().entity(student).now();

		return student;
	}

	@ApiMethod(name = "getStudents", path = "student", httpMethod = HttpMethod.GET)
	public List<Student> getStudents() {
		return ofy().load().type(Student.class).list();
	}
}
