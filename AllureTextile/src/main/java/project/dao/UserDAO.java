package project.dao;

import java.security.*;
import java.sql.*;
import java.util.*;

import project.connection.ConnectionManager;
import project.model.User;

public class UserDAO {

	static Connection con = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String Email, Password, Role;
	static int id;

	//login
	public static User login(User bean) throws NoSuchAlgorithmException{
		Email = bean.getEmail();
		Password = bean.getPassword();
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(Password.getBytes());

		byte byteData[] = md.digest();
		//hexadecimal format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}

		String query = "select * from user where Email='" + Email + "'AND password='" + sb.toString() + "'";

		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			boolean more = rs.next();
			if (more) {
				int id = rs.getInt("id");
				String Email = rs.getString("Email");
				String Role = rs.getString("Role");
				bean.setId(id);
				bean.setEmail(Email);
				bean.setRole(Role);
				System.out.println(Role);
				bean.setValid(true);
			}
			else if (!more) {
				bean.setValid(false);
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return bean;
	}

	//register
	public void add(User bean) throws NoSuchAlgorithmException{
		Email = bean.getEmail();
		Password = bean.getPassword();
		Role = bean.getRole();
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(Password.getBytes());
		byte byteData[] = md.digest();
		// hexadecimal format
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		String pass = sb.toString();
		try {
			con = ConnectionManager.getConnection(); 
			ps=con.prepareStatement("insert into user(Email,Password,Role)values(?,?,?)");
			ps.setString(1,Email);
			ps.setString(2,pass);
			ps.setString(3,Role);
			ps.executeUpdate();			
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

	}

	//get user
	public static User getUser(User bean)  {   
		//get email
		Email = bean.getEmail();
		String searchQuery = "select * from user where Email='" +Email+ "'";
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			// if user exists set the isValid variable to true
			if (more) {
				String Email = rs.getString("Email");
				bean.setEmail(Email);
				bean.setValid(true);
			}
			// if user does not exist set the isValid variable to false
			else if (!more) {
				bean.setValid(false);
			}
			//5. close connection
			con.close();	
		}catch(Exception e) {
			e.printStackTrace();		
		}
		return bean;
	}

	//get user by Email
	public static User getUserByUname(String Email) {
		User us = new User();
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from user where Email=?");
			ps.setString(1, Email);
			rs = ps.executeQuery();
			if (rs.next()) {	            
				us.setId(rs.getInt("id"));
				us.setEmail(rs.getString("Email"));				
				us.setPassword(rs.getString("Password"));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return us;
	}

	//get user by id
	public static User getUserById(int id) {
		User us = new User();
		try {

			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("select * from user where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				us.setId(rs.getInt("id"));
				us.setEmail(rs.getString("Email"));
				us.setPassword(rs.getString("Password"));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return us;
	}
	

	public static List<User> getUserId() {
		List<User> users = new ArrayList<User>();
		try {
			con = ConnectionManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select id, Email from user");
			while (rs.next()) {
				User us = new User();
				us.setId(rs.getInt("id"));
				us.setEmail(rs.getString("Email"));
				users.add(us);
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}

		return users;
	}
	public static List<User> getAllUsers(){
		List<User> users = new ArrayList<User>();
		try {	
			con = ConnectionManager.getConnection(); 

			String sql= "SELECT * FROM user ORDER BY id";
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getString("Role"));
				users.add(user);
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	//delete user
	public void deleteUser(int id) {
		try {
			con = ConnectionManager.getConnection();
			ps=con.prepareStatement("delete from user where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();		
		}
	}		

}

