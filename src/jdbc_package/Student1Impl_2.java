package jdbc_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student1Impl_2 
{
	public static void main(String[] args) throws Exception 
	{
		//2.loading the Driver class
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/Student";//add your database name at myproject
		String username="root";//add your username of mysql
		String pwd="Sujatha@01";//add password of mysql
		
		//3.establishing connection
		Connection con=DriverManager.getConnection(url, username,pwd );
		
		//4.create statement
		Statement st=con.createStatement();
		
		//5.Execute the statement
		ResultSet set=st.executeQuery("select * from Student1");//create and add student1 table
		 
		 //6.Print the o/p
		 System.out.println("sid:"+"        "+"sname:"+"         "+"course:");
		 while(set.next())
			 System.out.println(set.getInt("sid")+"       "+set.getString("sname")+"          "+set.getString("course"));
		 
		 //7.close the connections
		 con.close();
		 st.close();
		 set.close();
			
	}

}
