import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAOImpl implements StudentDAO {

	static final String DB_url = "jdbc:mysql://localhost:3306/cogdb";
	static final String USER = "root";
	static final String PASS = "pass@word1";
	Student s = new Student();

	@Override
	public void getAllStudents() {
		try {
			String query = "select * from Student";
			Connection con = DriverManager.getConnection(DB_url, USER, PASS);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println("Student Id : " + rs.getInt("id"));
				System.out.println("Student First Name : " + rs.getString("fname"));
				System.out.println("Student Last Name : " + rs.getString("lname"));
				System.out.println("Student Email : " + rs.getString("email"));
				System.out.println("Student Address : " + rs.getString("address"));
				System.out.println("\n");
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Student getStudentById(String id) {
		try {
			String query = "select * from student where id="+id;
			Connection con = DriverManager.getConnection(DB_url, USER, PASS);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String id1 = rs.getString(1);
				s.setId(id1);
				String fnm = rs.getString(2);
				s.setFname(fnm);
				String lnm = rs.getString(3);
				s.setFname(lnm);
				String email = rs.getString(4);
				s.setFname(email);
				String address = rs.getString(5);
				s.setFname(address);

				System.out.println("------------------ Employee Data -----------------");
				System.out.printf("Student ID : "+id1 );
				System.out.printf("\nStudent First Name : "+fnm );
				System.out.printf("\nStudent Last Name : "+lnm );
				System.out.printf("\nStudent email : "+email );
				System.out.printf("\nStudent address : "+address );
				System.out.println("\n--------------------------------------------------");
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public Student addStudent(Student s) {
		try {
			Connection con = DriverManager.getConnection(DB_url, USER, PASS);
			PreparedStatement ps = con.prepareStatement("insert into Student values (?,?,?,?,?)");

			ps.setString(1, s.getId());
			ps.setString(2, s.getFname());
			ps.setString(3, s.getLname());
			ps.setString(4, s.getEmail());
			ps.setString(5, s.getAddress());

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Student addes successfully!!");
			} else {
				System.out.println("Failed to add record");
			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student delStudent(String id) {
		try {
			Connection con = DriverManager.getConnection(DB_url, USER, PASS);
			String query = "delete from student where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,id);

			int i = ps.executeUpdate();
			if (i > 0) {
				System.out.println("Record deleted successfully!!");
			} else {
				System.out.println("Failed to delete the data...");

			}
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Student updateStudent(String id, String fname) {
		try {
			Connection con = DriverManager.getConnection(DB_url, USER, PASS);
			String query ="update Student set fname=? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, fname);
			ps.setString(2, id);

			int i = ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Data updated successfully!!");
			}
			else {
				System.out.println("Failed to update the data...");

			}
			ps.close();
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	

}
