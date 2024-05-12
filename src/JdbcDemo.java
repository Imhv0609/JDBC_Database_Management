//STEP 1. Import required packages
import java.util.*;
import java.sql.*;

public class JdbcDemo {

   // Set JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost:3306/companydb?useSSL=false";

   // Database credentials
   static final String USER = "root";// add your user
   static final String PASSWORD = "hondacityzx";// add password

   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);

      Connection conn = null;
      Statement stmt = null;

      
      // STEP 2. Connecting to the Database
      try {
         // STEP 2a: Register JDBC driver
         Class.forName(JDBC_DRIVER);
         // STEP 2b: Open a connection
         System.out.println("Connecting to database...");
         conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         conn.setAutoCommit(false);
         // STEP 2c: Execute a query
         System.out.println("Creating statement...");
         stmt = conn.createStatement();

         // INSERT, UPDATE, DELETE
         //stmt.executeUpdate(createEmployee);

         // STEP 3: Query to database
         System.out.println();
         System.out.println("MENU:");
         System.out.println("1. Select fname, ssn for employees earning more than a certain amount:");
         System.out.println("2. Select names and addresses of employees whose name starts with 'J':");
         System.out.println("3. Select employees who do not have a supervisor (assuming 'super_ssn' is null if they don't have one):");
         System.out.println("4. Select the highest salary in each department:");
         System.out.println("5. Select the number of employees in each department:");
         System.out.println("6. List departments and their managers' social security numbers, but only for departments named 'Research' or 'Administration':");
         System.out.println("7. Sort departments by the manager's start date in descending order:");
         System.out.println("8. Sum of hours worked by each employee:");
         System.out.println("9. Count the number of projects in each location:");
         System.out.println("10. Find dependents who are older than a certain age (e.g., older than 30 years):");
         System.out.println("11. List all employees working under a given project");
         System.out.println("12. Adding a new employee and updating its super_ssn");
         System.out.println("13. Adding a new department and updating its mgr_ssn");
         System.out.println("14. Deleting an entry from a table");
         System.out.println();

         System.out.print("Enter your query choice: ");
         int choice = sc.nextInt();

         if(choice == 1){
            System.out.println("Enter amount:");
            int x=sc.nextInt();
            String Query1 = "SELECT fname,ssn,salary FROM employee WHERE salary > "+x+";";
            ResultSet rs = stmt.executeQuery(Query1);
            int c=0;

         // STEP 4: Extract data from result set
         while 
         (rs.next()) {
         c++;
         // Retrieve by column name
         String fname = rs.getString("fname");
         Integer ssn = rs.getInt("ssn");
         Integer salary = rs.getInt("salary");

         // Display values
         System.out.print("fname: " + fname);
         System.out.print(", lname: " + ssn);
         System.out.println(", salary: " + salary);
         }
         if(c==0) System.out.println("There is no one earning more than the given amount.");

         
         // STEP 5: Clean-up environment
         rs.close();
         stmt.close();
         conn.close();
      }

      if(choice == 2){
         String Query2 = "SELECT fname, lname, address FROM employee WHERE fname LIKE 'J%';";
         ResultSet rs = stmt.executeQuery(Query2);
      
      // STEP 4: Extract data from result set
      while 
      (rs.next()) {

      // Retrieve by column name
      String fname = rs.getString("fname");
      String lname = rs.getString("lname");
      String address = rs.getString("address");

      // Display values
      System.out.print("fname: " + fname);
      System.out.print(", lname: " + lname);
      System.out.println(", address: " + address);
      }

      
      // STEP 5: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
   }


   if(choice == 3){
      String Query3 = "SELECT fname, lname FROM employee WHERE super_ssn IS NULL;";
      ResultSet rs = stmt.executeQuery(Query3);
   
   // STEP 4: Extract data from result set
   while 
   (rs.next()) {

   // Retrieve by column name
   String fname = rs.getString("fname");
   String lname = rs.getString("lname");

   // Display values
   System.out.print("fname: " + fname);
   System.out.println(", lname: " + lname);
   }

   
   // STEP 5: Clean-up environment
   rs.close();
   stmt.close();
   conn.close();
}


if(choice == 4){
   String Query4 = "SELECT dno, MAX(salary) AS max_salary FROM employee GROUP BY dno;";
   ResultSet rs = stmt.executeQuery(Query4);

// STEP 4: Extract data from result set
while 
(rs.next()) {

// Retrieve by column name
Integer dno = rs.getInt("dno");
Integer salary = rs.getInt("max_salary");

// Display values
System.out.print("dno: " + dno);
System.out.println(",highestSalary : " + salary);
}


// STEP 5: Clean-up environment
rs.close();
stmt.close();
conn.close();
}


if(choice == 5){
   String Query5 = "SELECT dno, COUNT(*) AS num_employees FROM employee GROUP BY dno;";
   ResultSet rs = stmt.executeQuery(Query5);

// STEP 4: Extract data from result set
while 
(rs.next()) {

// Retrieve by column name
Integer dno = rs.getInt("dno");
Integer noOfEmployees = rs.getInt("num_employees");

// Display values
System.out.print("dno: " + dno);
System.out.println(",noOfEmployees : " + noOfEmployees);
}


// STEP 5: Clean-up environment
rs.close();
stmt.close();
conn.close();
}

if(choice == 6){
   String Query6 = "SELECT dname, Mgr_Ssn FROM department WHERE dname IN ('Research', 'Administration');";
   ResultSet rs = stmt.executeQuery(Query6);

// STEP 4: Extract data from result set
while 
(rs.next()) {

// Retrieve by column name
String dname = rs.getString("dname");
Integer Mgr_Ssn = rs.getInt("mgr_ssn");

// Display values
System.out.print("dname: " + dname);
System.out.println(",mgr_ssn : " + Mgr_Ssn);
}


// STEP 5: Clean-up environment
rs.close();
stmt.close();
conn.close();
}

if(choice == 7){
   String Query7 = "SELECT dname, Mgr_start_date FROM department ORDER BY Mgr_start_date DESC;";
   ResultSet rs = stmt.executeQuery(Query7);

// STEP 4: Extract data from result set
while 
(rs.next()) {

// Retrieve by column name
String dname = rs.getString("dname");
String Mgr_Start_date = rs.getString("mgr_start_date");

// Display values
System.out.print("dname: " + dname);
System.out.println(",mgr_start_date : " + Mgr_Start_date);
}



// STEP 5: Clean-up environment
rs.close();
stmt.close();
conn.close();
}


if(choice == 8){
   String Query8 = "SELECT Essn, SUM(Hours) AS Total_Hours FROM works_on GROUP BY Essn;";
   ResultSet rs = stmt.executeQuery(Query8);

// STEP 4: Extract data from result set
while 
(rs.next()) {

// Retrieve by column name
String Essn = rs.getString("essn");
String Total_Hours = rs.getString("Total_Hours");

// Display values
System.out.print("essn: " + Essn);
System.out.println(",total_hours : " + Total_Hours);
}



// STEP 5: Clean-up environment
rs.close();
stmt.close();
conn.close();
}


if(choice == 9){
   String Query9 = "SELECT Plocation, COUNT(*) AS Project_Count FROM project GROUP BY Plocation;";
   ResultSet rs = stmt.executeQuery(Query9);

// STEP 4: Extract data from result set
while 
(rs.next()) {

// Retrieve by column name
String plocation = rs.getString("plocation");
Integer total_projects = rs.getInt("Project_Count");

// Display values
System.out.print("plocation: " + plocation);
System.out.println(",total_count : " + total_projects);
}



// STEP 5: Clean-up environment
rs.close();
stmt.close();
conn.close();
}


if(choice == 10){
   System.out.println("Enter the certain age:");
   int x=sc.nextInt();
   String Query10 = "SELECT Dependent_name, Bdate FROM dependent WHERE Bdate <= DATE_SUB(CURDATE(), INTERVAL "+x+" YEAR);";
   ResultSet rs = stmt.executeQuery(Query10);
   int c=0;
// STEP 4: Extract data from result set
while 
(rs.next()) {
c++;
// Retrieve by column name
String dependent_name = rs.getString("dependent_name");
String bdate = rs.getString("Bdate");

// Display values
System.out.print("dependent_name: " + dependent_name);
System.out.println(",olderThan : " + bdate);
}
if(c==0) System.out.println("There are no dependents older than the given age.");


// STEP 5: Clean-up environment
rs.close();
stmt.close();
conn.close();
}


if(choice == 11){
   System.out.println("Enter project name:");
   String x=sc.next();
   String Query11 = "SELECT e.fname, e.lname, p.pname FROM employee as e inner join works_on as w on w.essn=e.ssn inner join project as p on p.pnumber=w.pno WHERE p.pname='"+x+"'";
   ResultSet rs = stmt.executeQuery(Query11);
// STEP 4: Extract data from result set
while 
(rs.next()) {
// Retrieve by column name
String fname = rs.getString("fname");
String lname = rs.getString("lname");

// Display values
System.out.print("fname: " + fname);
System.out.println(",lname : " + lname);
}


// STEP 5: Clean-up environment
rs.close();
stmt.close();
conn.close();
}

if(choice == 12){
   System.out.println("Enter first name:");
   String fname=sc.next();

   System.out.println("Enter middle name:");
   String minit=sc.next();

   System.out.println("Enter last name:");
   String lname=sc.next();

   System.out.println("Enter ssn:");
   int ssn=sc.nextInt();

   System.out.println("Enter birth date:");
   String bdate=sc.next();

   System.out.println("Enter address:");
   String address=sc.next();

   System.out.println("Enter gender:");
   String sex=sc.next();

   System.out.println("Enter salary:");
   int salary=sc.nextInt();

   System.out.println("Enter super_ssn:");
   int super_ssn=sc.nextInt();

   System.out.println("Enter dno:");
   int dno=sc.nextInt();

   String Query12 = "INSERT into employee values('"+fname+"','"+minit+"','"+lname+"','"+ssn+"','"+bdate+"','"+address+"','"+sex+"','"+salary+"',NULL,'"+dno+"')";
   stmt.executeUpdate(Query12);

   String Query12a = "UPDATE Employee SET super_ssn='"+super_ssn+"' WHERE ssn='"+ssn+"'";
   stmt.executeUpdate(Query12a);
   conn.commit();
}


if(choice == 13){
   System.out.println("Enter department name:");
   String dname=sc.next();

   System.out.println("Enter department number:");
   int dnumber=sc.nextInt();

   System.out.println("Enter Mgr ssn:");
   int mgr_ssn=sc.nextInt();

   System.out.println("Enter Mgr start date:");
   String mgr_start_date=sc.next();

   String Query13 = "INSERT into department values('"+dname+"','"+dnumber+"',NULL,'"+mgr_start_date+"')";
   stmt.executeUpdate(Query13);

   String Query13a = "UPDATE department SET mgr_ssn='"+mgr_ssn+"' WHERE dnumber='"+dnumber+"'";
   stmt.executeUpdate(Query13a);
   conn.commit();
}

if(choice == 14){
   
   System.out.println("Enter department number for that entry to be deleted:");
   int x=sc.nextInt();
   String Query14 = "DELETE from department where dnumber='"+x+"'";

   if(stmt.executeUpdate(Query14) == 0){
      System.out.println("Dnumber " + x + " does not exist.");
   }
   conn.commit();
}


    } catch (SQLException se) { // Handle errors for JDBC
         //Handle errors for JDBC
         se.printStackTrace();
         // If there is an error then rollback the changes.
         System.out.println("Rolling back data here....");
         try{
            if(conn!=null)
                conn.rollback();
         }catch(SQLException se2){
	         System.out.println("Rollback failed....");
                 se2.printStackTrace();
         }
      } catch (Exception e) { // Handle errors for Class.forName
         e.printStackTrace();
      } finally { // finally block used to close resources regardless of whether an exception was
                  // thrown or not
         try {
            if (stmt != null)
               stmt.close();
         } catch (SQLException se2) {
         }
         try {
            if (conn != null)
               conn.close();
         } catch (SQLException se) {
            se.printStackTrace();
         } // end finally try
      } // end try
      System.out.println("End of Code");
   } // end main
} // end class

// Note : By default autocommit is on. you can set to false using
// con.setAutoCommit(false)
