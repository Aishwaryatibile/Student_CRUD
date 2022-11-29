
public interface StudentDAO {
	
	public void getAllStudents();
	public Student getStudentById(String id);
	public Student addStudent(Student s);
	public Student delStudent(String id);
	public Student updateStudent(String id, String fname);

}
