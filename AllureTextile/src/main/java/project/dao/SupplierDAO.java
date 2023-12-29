package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.connection.ConnectionManager;
import project.model.Supplier;


public class SupplierDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	int SupplierID,StaffID;
	String Supplier_Name,Address,Email,NoPhone;
	
	//add supplier
	public void addSupplier(Supplier bean) {
		Supplier_Name = bean.getSupplier_Name();
		Address = bean.getAddress();
		Email = bean.getEmail();
		NoPhone = bean.getNoPhone();
		StaffID = bean.getStaffID();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "INSERT INTO supplier(Supplier_Name,Address,Email,NoPhone,StaffID) VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, Supplier_Name);
			ps.setString(2, Address);
			ps.setString(3, Email);
			ps.setString(4, NoPhone);
			ps.setInt(5, StaffID);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//get all supplier
	public static List<Supplier> getAllSuppliers(){
		List<Supplier> suppliers = new ArrayList<Supplier>();
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();
			
			//3. Create Statement
			String sql = "SELECT * FROM supplier ORDER BY SupplierID";
			stmt = con.createStatement();
			
			//4.execute query
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Supplier supplier = new Supplier();
				supplier.setSupplierID(rs.getInt("SupplierID"));
				supplier.setSupplier_Name(rs.getString("Supplier_Name"));
				supplier.setAddress(rs.getString("Address"));
				supplier.setEmail(rs.getString("Email"));
				supplier.setNoPhone(rs.getString("NoPhone"));
				supplier.setStaffID(rs.getInt("StaffID"));
				suppliers.add(supplier);
			}
			
			//5.Close connection
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return suppliers;
	}
	
	//get supplier by id
	public static Supplier getSupplierById(int SupplierID) {
		Supplier supplier = new Supplier();
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "SELECT * FROM supplier WHERE SupplierID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, SupplierID);
			
			//4. Execute Query
			rs = ps.executeQuery();
			if(rs.next()) {
				supplier.setSupplierID(rs.getInt("SupplierID"));
				supplier.setSupplier_Name(rs.getString("Supplier_Name"));
				supplier.setAddress(rs.getString("Address"));
				supplier.setEmail(rs.getString("Email"));
				supplier.setNoPhone(rs.getString("NoPhone"));
				supplier.setStaffID(rs.getInt("StaffID"));
			}
			
			//5. close connection
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return supplier;
	}
	//update supplier
	public void updateSupplier(Supplier bean) {
		//get supplier
		SupplierID = bean.getSupplierID();
		Supplier_Name = bean.getSupplier_Name();
		Address = bean.getAddress();
		Email = bean.getEmail();
		NoPhone = bean.getNoPhone();
		StaffID = bean.getStaffID();
		
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "UPDATE supplier SET Supplier_Name=?,Address=?,Email=?,NoPhone=?,StaffID=? WHERE SupplierID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Supplier_Name);
			ps.setString(2, Address);
			ps.setString(3, Email);
			ps.setString(4, NoPhone);
			ps.setInt(5, StaffID);
			ps.setInt(6, SupplierID);
			
			//4. execute query
			ps.executeUpdate();
			
			//5. close connection
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//delete supplier
	public void deleteSupplier(int SupplierID) {
		try {
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();
			
			//3. create statement
			String sql = "DELETE FROM supplier WHERE SupplierID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, SupplierID);
			
			//4. execute query
			ps.executeUpdate();
			
			//5.close connection
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
