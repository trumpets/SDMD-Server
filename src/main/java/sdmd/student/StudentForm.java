package sdmd.student;

public class StudentForm {

	private String firstName;
	private String lastName;
	private int age;

	@SuppressWarnings("unused")
	private StudentForm() {
	}

	public StudentForm(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
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
