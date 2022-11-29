import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		int choice,num;
		
	StudentDAO dao = new StudentDAOImpl();
	Student s;
		
	while(true) {
		
		
			System.out.println("<-------Menu------>");
			System.out.println("1.Get Student by ID");
			System.out.println("2.Add Student");
			System.out.println("3.Update Student");
			System.out.println("4.Delete Student");
			System.out.println("5.Get all Student");
			System.out.println("6.Exit");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
		
		
		switch(choice)
		{
		case 1: System.out.println("Enter the ID of Student: ");
				String id1 = sc.next();
				s = dao.getStudentById(id1);
			break;
			
		case 2: System.out.println("Enter Student Details: ");
				System.out.println("Enter Student ID : ");
				String id2 = sc.next();
				System.out.println("Enter Student First Name : ");
				String fname = sc.next();
				System.out.println("Enter Student last Name : ");
				String lname = sc.next();
				System.out.println("Enter email: ");
				String email = sc.next();
				System.out.println("Enter Student address : ");
				String address = sc.next();
				Student e1 = new Student(id2, fname, lname,email,address);
				s = dao.addStudent(e1);
			break;
			
		case 3:	System.out.println("Enter the ID to change record: ");
				String id3 = sc.next();
				System.out.println("Enter the new Name: ");
				String name1 = sc.next();
				s = dao.updateStudent(id3, name1);
			break;
			
		case 4: System.out.println("Enter the ID to delete record");
				String id4 = sc.next();
				s = dao.delStudent(id4);
				break;
			
		case 5: System.out.println("---------------- Student Data -----------------------");
				dao.getAllStudents();
				System.out.println("-----------------------------------------------------");
				break;
				
		case 6:
			System.exit(1);
			
		default:
			System.out.println("Wrong input..!"); 
			break;
		}
		
		}
	}

	

}
