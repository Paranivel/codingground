import java.sql.*;
import java.util.*;
public class Customer
{
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   static final String DB_URL = "jdbc:mysql://localhost/CODINGGROUND";
   static final String USER = "root";
   static final String PASS = "root";
   
   int customerid;
   String customername , dob;
   float balance=20;
   public static void main(String[] args) {
      Connection conn = null;
      Statement stmt = null;

   try{
      Customer custobj = new Customer();
      Class.forName("com.mysql.jdbc.Driver");
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);
   
   // Finding a customer 
      PreparedStatement psf = conn.prepareStatement("Select customeridtab,customernametab,dobtab,balancetab from customertable where customeridtab = ? ");
      psf.setInt(1,custobj.customerid);
      psf.executeQuery();
      
   // Updating a customer
      PreparedStatement psu = conn.prepareStatement("Update customertable set customernametab = ? ,dobtab = ? ,balancetab = ?  where customeridtab = ? ");
      psu.setString(1,custobj.customername);
      psu.setString(2,custobj.dob);
      psu.setFloat(3,custobj.balance);
      psu.setInt(4,custobj.customerid);
      psu.executeUpdate();
      
   // Inserting a customer
      PreparedStatement psi = conn.prepareStatement("Insert into table customertable values (?,?,?,?)");
      psi.setString(1,custobj.customername);
      psi.setString(2,custobj.dob);
      psi.setFloat(3,custobj.balance);
      psi.setInt(4,custobj.customerid);
      psi.executeUpdate();
      
   // Deleting a customer
      PreparedStatement psd = conn.prepareStatement("Delete from customertable where customeridtab =? ");
      psd.setInt(1,custobj.customerid);
      psd.executeUpdate();
      
   // Selecting ALL customer (Not yet defined properly)
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("Select customeridtab,customernametab,dobtab,balancetab from customertable");
      ArrayList<String> al = new ArrayList<String>();
      while (rs.next())
      {
          new Customer();
          al.add("custobj");
      }
      }
      catch(Exception e)
      {
        System.out.println("Error in Creating Connection " + e);
      }  
    }
  
}
