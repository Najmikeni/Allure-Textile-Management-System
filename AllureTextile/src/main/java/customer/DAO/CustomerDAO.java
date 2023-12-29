package customer.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import customer.connection.Connection_Manager;
import customer.model.Customer;

public class CustomerDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	int CustomerID,id;
	String Cust_name,Email,Address,CustNo;
	
	
	//Add customer method
	public void AddCustomer(Customer bean) throws SQLException {
		Cust_name = bean.getCust_name();
		Email = bean.getEmail();
		Address = bean.getAddress();
		CustNo = bean.getCustNo();
		id = bean.getID();
		
		
		//connection
		con = Connection_Manager.getConnection();
		
		//Query
		String sql = "INSERT into customer(Cust_name,Email,Address,CustNo) VALUES(?,?,?,?)";
		
		//statement
		ps = con.prepareStatement(sql);
		//set the values
		ps.setString(1,Cust_name);
		ps.setString(2,Email);
		ps.setString(3,Address);
		ps.setString(4,CustNo);
		
		//execute query
		ps.executeUpdate();
		//close connection
		con.close();
		
		}
	
	//Get Customer by CustomerID
	public Customer getCustomerbyID(int CustomerID) throws SQLException {
		Customer customer = new Customer();
		//connection
		con = Connection_Manager.getConnection();
		//query
		String sql = "SELECT*FROM customer WHERE CustomerID=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1,CustomerID);
		
		rs = ps.executeQuery();
		//if else condition = customerID exist
		if(rs.next()) {
			
			customer.setCustomerID(rs.getInt("CustomerID"));
			customer.setCust_name(rs.getString("Cust_name"));
			customer.setEmail(rs.getString("Email"));
			customer.setAddress(rs.getString("Address"));
			customer.setCustNo(rs.getString("CustNo"));
			customer.setID(rs.getInt("id"));
		}
		//close
		con.close();
		
		//return object of Customer:customer
		return customer;
	}
	//get customer by user id
	public Customer getCustUserID(int id) throws SQLException {
		Customer customer = new Customer();
		//connection
		con = Connection_Manager.getConnection();
		//query
		String sql = "SELECT*FROM customer WHERE id=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1,id);
		
		rs = ps.executeQuery();
		//if else condition = id exist
		if(rs.next()) {
			
			customer.setCustomerID(rs.getInt("CustomerID"));
			customer.setCust_name(rs.getString("Cust_name"));
			customer.setEmail(rs.getString("Email"));
			customer.setAddress(rs.getString("Address"));
			customer.setCustNo(rs.getString("CustNo"));
			customer.setID(rs.getInt("id"));
		}
		//close
		con.close();
		
		//return object of Customer:customer
		return customer;
	}
	
	//Get list of all customer
	public static List<Customer> getAllCustomer() throws SQLException{
		List<Customer> customerlist = new ArrayList<Customer>();
		//connection
		con = Connection_Manager.getConnection();
		//query
		String sql = "SELECT*FROM customer ORDER BY CustomerID";
		//create statement to parse and compile
		stmt = con.createStatement();
		//execute
		rs = stmt.executeQuery(sql);
		//loop to get all Customer
		while(rs.next()) {
			Customer customer = new Customer();
			
			customer.setCustomerID(rs.getInt("CustomerID"));
			customer.setCust_name(rs.getString("Cust_name"));
			customer.setEmail(rs.getString("Email"));
			customer.setAddress(rs.getString("Address"));
			customer.setCustNo(rs.getString("CustNo"));
			customer.setID(rs.getInt("id"));
			
			//add customer to list
			customerlist.add(customer);
		}
		
		con.close();
		
		//return list
		return customerlist;
	}
	
	//Delete Customer from database
	public void deleteCustomer(int CustomerID) throws SQLException {
		
		//open connection
		con = Connection_Manager.getConnection();			
		//sql query		
		String sql = "DELETE FROM customer WHERE CustomerID=?";
		ps = con.prepareStatement(sql);
		//set customerID to delete
		ps.setInt(1, CustomerID);
		
		//execute query
		ps.executeUpdate();	
		
		//close connection
		con.close();
	}
	
	//Edit or update Customer
	public void updateCustomer(Customer bean,int cusid) throws SQLException {
		CustomerID = bean.getCustomerID();
		Cust_name = bean.getCust_name();
		Email = bean.getEmail();
		Address = bean.getAddress();
		CustNo = bean.getCustNo();
		id = bean.getID();
		
		//open connection
		con = Connection_Manager.getConnection();
		String sql = "UPDATE customer SET Cust_name=?,Email=?,Address=?,CustNo=? WHERE CustomerID=?";
		ps = con.prepareStatement(sql);
		
		
		
		ps.setString(1,Cust_name);
		ps.setString(2,Email);
		ps.setString(3,Address);
		ps.setString(4,CustNo);
		ps.setInt(5,cusid);
		
		
		//updated the data in database
		
		ps.executeUpdate();
		
		con.close();
		
	}
	
}
