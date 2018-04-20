package sdmd.student;


import static sdmd.OfyService.factory;

import com.googlecode.objectify.Key;

import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;

import sdmd.PersistableEntity;

@Entity
@Cache
public class Student extends PersistableEntity {
	
	public static Key<Student> createKey(long id) {
		return Key.create(Student.class, id);
	}
	
	public static Key<Student> allocateKey() {
		return factory().allocateId(Student.class);
	}

	private String firstName;
	private String lastName;
	private int age;
	
	@SuppressWarnings("unused")
	private Student(){}
	
	public Student(long id, StudentForm form) {
		super(id);
		this.updateWithStudentForm(form);
	}
	
	public void updateWithStudentForm(StudentForm form) {
		this.firstName = form.getFirstName();
		this.lastName = form.getLastName();
		this.age = form.getAge();
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

	public int getAge() {
		return age;
	}
}
