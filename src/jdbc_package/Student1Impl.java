package jdbc_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student1Impl
{
	public static void main(String[] args) throws Exception 
	{
		//2.loading the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//3.establishing connection
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student", "root", "Sujatha@01");
		
		//4.create statement
		Statement st=con.createStatement();
		
		//5.Execute the statement
		 ResultSet set=st.executeQuery("select sname from Student1");
		 
		 //6.Print the o/p
		 System.out.println("sname");
		 while(set.next())
			 System.out.println(set.getString("sname"));
		 
		 
		 
		 //7.close the connections
		 con.close();
		 st.close();
		 set.close();
		
	}

}
