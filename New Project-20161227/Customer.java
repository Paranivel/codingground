import java.sql.*;
public class Customer
{
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/CODINGGROUND";
    static final String USER = "root";
    static final String PWD = "root";
    
    int customer_id;
    String customer_name , dob;
    float balance=20;
    public static void main(String args[])
    {
      Connection conn = null;
      Statement stmt = null;
      try
      {
        Customer custobj = new Customer(); 
        System.out.println("Program executed " +  custobj.balance);
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConection(URL,USER,PWD);
        Boolean add_result = custobj.addCustomer(custobj);
        if (add_result)
        {
          System.out.println("Customer is Added");
          
        }
          
      }
      catch(Exception e)
      {
        System.out.println("Error in Creating Connection " + e);
      }  
    }
  public boolean addCustomer(Customer custobj)
  {
    try
    {
      System.out.println("Customer is created");
      return true;
    }
    catch(Exception e)
    {
       System.out.println("Error in ADDING CUSTOMER " + e);
    }
  }
  public Customer findCustomer(int customerid)
  {
      Customer custobj = new Customer();
      PreparedStatement ps = conn.prepareStatement("Select customeridtab,customernametab,dobtab,balancetab from customertable where customeridtab = ? ");
      ps.setInt(1,customerid);
      ps.executeQuery();
      return custobj;
  }
}
