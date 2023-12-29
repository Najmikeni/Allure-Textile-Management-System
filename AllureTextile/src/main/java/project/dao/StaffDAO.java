package project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.connection.ConnectionManager;
import project.model.Staff;

public class StaffDAO {
	//declare
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	
	String staff_Name,address,noPhone;
	int staffID, id;
	
	//get all the staff
	public static List<Staff> getAllStaffs(){ //return many staff
		List<Staff> staffs = new ArrayList<Staff>();	
		try {
			con = ConnectionManager.getConnection(); 			
			String sql ="SELECT * FROM staff ORDER BY staffID";	
			stmt = con.createStatement();	
			
			//run query with loop
			rs = stmt.executeQuery(sql);	
			while(rs.next()) {	
				Staff staff = new Staff();
				staff.setStaffID(rs.getInt("staffID")); 
				staff.setStaff_Name(rs.getString("staff_Name"));
				staff.setAddress(rs.getString("address"));
				staff.setNoPhone(rs.getString("noPhone"));
				staff.setId(rs.getInt("id"));
				staffs.add(staff); //add staff to array Staff
			}
			con.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return staffs;
	}
		
	//get staff by StaffID
	public static Staff getStaffById(int staffID){
		Staff staff = new Staff();
		try {		
			con = ConnectionManager.getConnection(); 
			String sql ="SELECT * FROM staff WHERE staffID=?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, staffID);
			rs = ps.executeQuery();	
			if(rs.next()) {	//find staff id that matches
				staff.setStaffID(rs.getInt("staffID")); 
				staff.setStaff_Name(rs.getString("staff_Name"));
				staff.setAddress(rs.getString("address"));
				staff.setNoPhone(rs.getString("noPhone"));
				staff.setId(rs.getInt("id"));
			}
			con.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
		return staff;
	}
	
	//add staff
	public void addStaff(Staff bean) {
		staff_Name = bean.getStaff_Name();
		address = bean.getAddress();
		noPhone = bean.getNoPhone();
		id = bean.getId();
		
		try {
			con = ConnectionManager.getConnection();
			
			String add ="INSERT INTO staff(staff_Name,address,noPhone,id)VALUES(?,?,?,?)";
			ps = con.prepareStatement(add);
			
			ps.setString(1, staff_Name);
			ps.setString(2, address);
			ps.setString(1, noPhone);
			ps.setInt(4, id);
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	//update staff
	public void updateStaff(Staff bean) {
		staffID = bean.getStaffID(); //need for update
		staff_Name = bean.getStaff_Name();
		address = bean.getAddress();
		noPhone = bean.getNoPhone();
		id = bean.getId();
		
		try {	
			con = ConnectionManager.getConnection(); 			
			String sql ="UPDATE staff SET staff_Name=?,address=?,noPhone=? WHERE staffID=?";
			ps = con.prepareStatement(sql);	
			
			ps.setString(1, staff_Name);
			ps.setString(2, address);
			ps.setString(3, noPhone);
			
			ps.setInt(4, staffID);
			ps.executeUpdate();
			
			con.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
		
	//delete staff
	public void deleteStaff(int staffID) {
		try {		
			con = ConnectionManager.getConnection(); 			
			String sql = "DELETE FROM staff WHERE staffID=?";
			ps = con.prepareStatement(sql);	
			
			ps.setInt(1, staffID);
			ps.executeUpdate();	
			
			con.close();	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
