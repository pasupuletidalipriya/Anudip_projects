package jdbc_package;

import java.sql.*;

public class EmployeeUpdate
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
			
			pstmt = con.prepareStatement("update Employee set ename=? where eid=?");
			pstmt.setString( 1,"Sara" );
			pstmt.setInt(2, 6);
			
			int i = pstmt.executeUpdate();
			System.out.println("No: of rows effected : " + i);
			System.out.println();
			
			//selecting student1 table 
			ResultSet rs = pstmt.executeQuery("select * from Employee");
			
			while(rs.next())
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2)+"\t"+rs.getInt(3));
			
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

