import java.sql.*;
public class CreateCustomerDB
{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/CODINGGROUND";
   static final String USER = "root";
   static final String PASS = "root";
   
   public static void main(String[] args) throws Exception {
      Connection conn = null;
      Statement st = null;

   try{
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
      st = conn.createStatement();
      st.executeQuery("Create table customertable(customeridtab int,customernametab varchar(50),dobtab date,balancetab decimal(10,2))");
      conn.close();
   }
   catch(SQLException e){
       System.out.println("Error While creating CustomerDB" + e.getMessage());
   }
 }
}
