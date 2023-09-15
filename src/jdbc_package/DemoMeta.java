package jdbc_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DemoMeta
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/Student";
		String userName="root";
		String pwd="Sujatha@01";
		java.sql.Connection con=DriverManager.getConnection(url,userName,pwd);
		Statement st=con.createStatement();
		
		ResultSet rset=st.executeQuery("Select * from Employee");
		java.sql.ResultSetMetaData rsmd=rset.getMetaData();
		
		//retrieving table name
		System.out.println("Table name:"+rsmd.getTableName(1));
		//retrieving no.of columns
		System.out.println("No.of Columns:"+rsmd.getColumnCount());
		//retrieving column type
		System.out.println("Column Type Name:"+rsmd.getColumnTypeName(1));
		//retrieving the details of column 1
		System.out.println("Column Type:"+rsmd.getColumnType(1));
		System.out.println("Column class Name:"+rsmd.getColumnClassName(1));
		System.out.println("Column Name:"+rsmd.getColumnName(1));
		
		
	}

}
