package db;
/*
 * DatabaseConcepts
 * 
 * */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Jdbcon{  
public static void main(String args[]){  
try{  
Class.forName("com.mysql.cj.jdbc.Driver");   
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3306/employee","root","");   
Statement stmt=con.createStatement();

//Create

int rs1=stmt.executeUpdate("INSERT INTO employees(ename,eaddress,salary) VALUES('DINESH','India',8000),('RAVI','India',10000),('RAJA','India',12000)");  
System.out.println("INSERTION");
if(rs1 > 0)
System.out.println("Inserted");
else
	System.out.println("Wrong...!");
//Read
ResultSet rsss=stmt.executeQuery("SELECT * FROM employees");
System.out.println("ALL DETEILS");
while(rsss.next()) 
System.out.println(rsss.getString(1)+"\t"+rsss.getString(2)+"\t"+rsss.getString(3)+"\t"+rsss.getString(4));

ResultSet rs2=stmt.executeQuery("SELECT ename FROM employees WHERE ename LIKE 'RA%'");
System.out.println("LIKE");
while(rs2.next()) 
System.out.println(rs2.getString(1));
ResultSet rs3=stmt.executeQuery("SELECT employees2.ename,calc.2_unit FROM employees2 INNER JOIN calc ON employees2.eid = calc.eid");
System.out.println("JOINS");
while(rs3.next()) 
System.out.println(rs3.getString(1)+"\t"+rs3.getString(2));
ResultSet rs4=stmt.executeQuery("SELECT * FROM employees WHERE salary IN('8000','12000')");
System.out.println("IN");
while(rs4.next())  
System.out.println(rs4.getString(1)+"\t"+rs4.getString(2)+"\t"+rs4.getString(3)+"\t"+rs4.getString(4));
ResultSet rs5=stmt.executeQuery("SELECT ename,salary,(CASE WHEN ename = 'DINESH' THEN 100 ELSE 200 END)AS salary FROM employees");
System.out.println("CASE WHEN,AS,END ELSE");
while(rs5.next()) 
System.out.println(rs5.getString(1)+"\t"+rs5.getString(2)+"\t"+rs5.getString(3));
ResultSet rs6=stmt.executeQuery("SELECT ename,salary FROM employees ORDER BY ename DESC");
System.out.println("ORDER BY");
while(rs6.next()) 
System.out.println(rs6.getString(1)+"\t"+rs6.getString(2));
ResultSet rs7=stmt.executeQuery("SELECT ename,salary FROM employees GROUP BY ename");
System.out.println("GROUP BY");
while(rs7.next()) 
System.out.println(rs7.getString(1)+"\t"+rs7.getString(2));

//Update
 int rs=stmt.executeUpdate("UPDATE employees SET ename = 'Ravichandran' WHERE employees.eid = 21;");  
if(rs > 0)
System.out.println("Updated");
else
	System.out.println("Wrong...!");
//Delete
int rss=stmt.executeUpdate("DELETE FROM employees WHERE  salary = '12000' AND ename = 'RAJA'");//WHERE  eid = 27
if(rss > 0)
System.out.println("Deleted");
else
	System.out.println("Wrong...!");
	
con.close();   
}catch(Exception e){ System.out.println(e);}  
}  
}  
