package project.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.*;
import project.connection.ConnectionManager;
import project.model.Orders;

public class OrderDAO {
	//declaration
		static Connection con = null;
		static ResultSet rs = null;
		static PreparedStatement ps = null;
		static Statement stmt = null;
		DateFormat formatter;
		
		 int OrderID;
		 int CustomerID;
		 int ProductID;
		 String Product_name;
		 double Price,Total;
		 int Quantity;
		//add order method
		public void addOrder(Orders bean) { 
			//get order
			CustomerID = bean.getCustomerID();
			OrderID = bean.getOrderID();
			ProductID = bean.getProductID();
			Product_name = bean.getProduct_name();
			Price = bean.getPrice();			
			Quantity = bean.getQuantity();
			Total = Price*Quantity;
			
			
	        
	        
			try {
				con = ConnectionManager.getConnection(); 			
				//create statement
				String sql ="INSERT INTO orders(CustomerID,ProductID,Product_name,Price,Total,Quantity)VALUES(?,?,?,?,?,?)";
				
				ps = con.prepareStatement(sql);	
				
				
				ps.setInt(1, CustomerID);
				ps.setInt(2, ProductID);
				ps.setString(3, Product_name);
				ps.setDouble(4, Price);
				ps.setDouble(5, Total);
				ps.setInt(6, Quantity);
				ps.executeUpdate();	
				
				con.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

		//update orders
		public void updateOrder(Orders bean,int ordid) {
			//get order 
			CustomerID = bean.getCustomerID();
			OrderID = bean.getOrderID();
			ProductID = bean.getProductID();
			Product_name = bean.getProduct_name();
			Price = bean.getPrice();
			
			Quantity = bean.getQuantity(); 
			Total = Price*Quantity;
			

			
			try {	
				con = ConnectionManager.getConnection(); 			

				String sql ="UPDATE orders SET ProductID=?,Product_name=?,Price=?,Quantity=?,Total=? WHERE orderID=?";
				
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, ProductID);
				ps.setString(2, Product_name);
				ps.setDouble(3, Price);
				ps.setInt(4, Quantity);
				ps.setDouble(5, Total);
				ps.setInt(6, ordid);
				ps.executeUpdate();				

				con.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}
		
		//get all order
		public static List<Orders> getAllOrder(){ 
			List<Orders> orders = new ArrayList<Orders>();
			try {		
				con = ConnectionManager.getConnection(); 			
				//create statement
				String sql ="SELECT * FROM orders ORDER BY orderID";
				stmt = con.createStatement();	
				//execute query
				rs = stmt.executeQuery(sql);
				while(rs.next()) {	
					Orders order = new Orders();
					order.setOrderID(rs.getInt("orderID"));
					order.setCustomerID(rs.getInt("customerID")); 
					order.setPrice(rs.getDouble("Price"));
					order.setProduct_name(rs.getString("Product_name"));
					order.setProductID(rs.getInt("ProductID"));
					order.setQuantity(rs.getInt("Quantity"));
					double totalSQL = rs.getDouble("Price")*rs.getInt("Quantity");
					order.setTotal(totalSQL);
					orders.add(order); 	
				}
				con.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}
			return orders;
		}
		//get all order by customer id
				public static List<Orders> getAllOrderbyCusID(int cusid){ 
					List<Orders> orders = new ArrayList<Orders>();
					try {		
						con = ConnectionManager.getConnection(); 			
						//create statement
						String sql ="SELECT * FROM orders WHERE CustomerID=? ORDER BY orderID ";
						ps = con.prepareStatement(sql);
						ps.setInt(1, cusid);
						//execute query
						rs = ps.executeQuery();
						while(rs.next()) {	
							Orders order = new Orders();
							order.setOrderID(rs.getInt("orderID"));
							order.setCustomerID(rs.getInt("customerID")); 
							order.setPrice(rs.getDouble("Price"));
							order.setProduct_name(rs.getString("Product_name"));
							order.setProductID(rs.getInt("ProductID"));
							order.setQuantity(rs.getInt("Quantity"));
							double totalSQL = rs.getDouble("Price")*rs.getInt("Quantity");
							order.setTotal(totalSQL);
							orders.add(order); 	
						}
						con.close();	
					}catch(Exception e) {
						e.printStackTrace();
					}
					return orders;
				}
		// get Order by OrderID
		public static Orders getOrderById(int orderID) { //return the object
			Orders order = new Orders();
			try {		
				con = ConnectionManager.getConnection(); 			

				String sql ="SELECT * FROM orders WHERE orderID=?";
				ps = con.prepareStatement(sql);
				
				ps.setInt(1, orderID);
				rs = ps.executeQuery();		
				if(rs.next()) {	
					order.setOrderID(rs.getInt("orderID"));
					order.setCustomerID(rs.getInt("customerID")); 
					order.setPrice(rs.getDouble("Price"));
					order.setProduct_name(rs.getString("Product_name"));
					order.setProductID(rs.getInt("ProductID"));
					order.setQuantity(rs.getInt("Quantity"));
					double totalSQL = rs.getDouble("Price")*rs.getInt("Quantity");
					order.setTotal(totalSQL);
				}
				//close connection
				con.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}
			return order;
		}
		
		//delete order
		public void deleteOrder(int orderID) {
			try {
				con = ConnectionManager.getConnection(); 			

				String sql = "DELETE FROM orders WHERE orderID=?";
				ps = con.prepareStatement(sql);	
				
				ps.setInt(1, orderID);
				ps.executeUpdate();			

				con.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}
		}	
	
	
}
