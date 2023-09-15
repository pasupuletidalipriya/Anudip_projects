package jdbc_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class BatchDemo
{

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","Sujatha@01");
		java.sql.PreparedStatement pst=con.prepareStatement("select * from Employee");
		ResultSet rset=pst.executeQuery();
		while(rset.next())
			System.out.println(rset.getInt(1)+" "+rset.getString(2)+" "+rset.getInt(3));
		
		//inserting records into the Employee table
		pst.addBatch("insert into Employee values(7,'Sam',40000)");
		pst.addBatch("insert into Employee values(8,'John',60000)");
		pst.addBatch("insert into Employee values(9,'Rahim',100000)");
		
		//updating the values in the Employee table
		pst.addBatch("update Employee set ename='Preetam' where eid=6");
		
		int[] i=pst.executeBatch();
        System.out.println("No.of Records inserted :" + i.length);

     }

}
