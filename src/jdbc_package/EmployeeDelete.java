package jdbc_package;

import java.sql.*;

public class EmployeeDelete
{

	public static void main(String[] args) throws Exception
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/Student";
			String username = "root";
			String password = "Sujatha@01";
			
			con = DriverManager.getConnection(url, username, password);
			
			pstmt = con.prepareStatement("delete from employee where eid=9");
			
			int i = pstmt.executeUpdate();
			System.out.println("No: of rows effected : " + i);
		}
		
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		finally
		{
			con.close();
			pstmt.close();
		}

	}

}
