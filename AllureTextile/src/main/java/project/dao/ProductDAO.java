package project.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.connection.ConnectionManager;
import project.model.Product;

public class ProductDAO {
	static Connection con = null;
	static ResultSet rs = null;
	static PreparedStatement ps = null;
	static Statement stmt = null;
	int ProductID, Product_Quantity, SupplierID;
	String Product_Name,Product_Desc;
	double Product_Price;
	
	//add product
	public void addProduct(Product bean) {
		//get the product
		Product_Name = bean.getProduct_Name();
		Product_Desc = bean.getProduct_Desc();
		
		Product_Price = bean.getProduct_Price();
		Product_Quantity = bean.getProduct_Quantity();
		
		SupplierID = bean.getSupplierID();
		
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "INSERT INTO product(Product_Name,Product_Desc,Product_Price,Product_Quantity,SupplierID)VALUES(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, Product_Name);
			ps.setString(2, Product_Desc);
			ps.setDouble(3, Product_Price);
			ps.setInt(4, Product_Quantity);
			ps.setInt(5, SupplierID);		
			//4. execute query
			ps.executeUpdate();	
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//get product by id
	public static Product getProductById(int ProductID) {
		Product product = new Product();
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "SELECT * FROM product WHERE ProductID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ProductID);			
			//4. execute query
			rs = ps.executeQuery();
			if(rs.next()) {
				product.setProductID(rs.getInt("ProductID"));
				product.setProduct_Name(rs.getString("Product_Name"));
				product.setProduct_Desc(rs.getString("Product_Desc"));
				product.setProduct_Price(rs.getDouble("Product_Price"));
				product.setProduct_Quantity(rs.getInt("Product_Quantity"));
				product.setSupplierID(rs.getInt("SupplierID"));
			}	
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}				
		return product;
	}
	
	//get all products
	public static List<Product> getAllProducts(){
		List<Product> products = new ArrayList<Product>();
		
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "SELECT * FROM product ORDER BY ProductID";
			stmt = con.createStatement();			
			//4. execute query
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Product product = new Product();
				product.setProductID(rs.getInt("ProductID"));
				product.setProduct_Name(rs.getString("Product_Name"));
				product.setProduct_Desc(rs.getString("Product_Desc"));
				product.setProduct_Price(rs.getDouble("Product_Price"));
				product.setProduct_Quantity(rs.getInt("Product_Quantity"));
				product.setSupplierID(rs.getInt("SupplierID"));
				products.add(product);
			}	
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}				
		
		return products;
	}
	
	
	//update product
	public void updateProduct(Product bean,int prodid) {
		//get product
		ProductID = bean.getProductID();
		Product_Name = bean.getProduct_Name();
		Product_Desc = bean.getProduct_Desc();
		Product_Price = bean.getProduct_Price();
		Product_Quantity = bean.getProduct_Quantity();
		SupplierID = bean.getSupplierID();

		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "UPDATE product SET Product_Name=?,Product_Desc=?,Product_Price=?,Product_Quantity=?,SupplierID=? WHERE ProductID=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Product_Name);
			ps.setString(2, Product_Desc);
			ps.setDouble(3, Product_Price);
			ps.setInt(4, Product_Quantity);
			ps.setInt(5, SupplierID);	
			ps.setInt(6, prodid);
			//4. execute query
			ps.executeUpdate();				
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
		
	//delete product
	public void deleteProduct(int ProductID) {
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "DELETE FROM product WHERE ProductID=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, ProductID);
			//4. execute query
			ps.executeUpdate();				
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	//update stock
	public void updateStock(Product bean,int prodid,int quantity) {
		//get product
		ProductID = bean.getProductID();
		Product_Name = bean.getProduct_Name();
		Product_Desc = bean.getProduct_Desc();
		Product_Price = bean.getProduct_Price();
		Product_Quantity = bean.getProduct_Quantity();
		SupplierID = bean.getSupplierID();
		
		Product_Quantity = Product_Quantity - quantity;
		try {			
			//call getConnection() method from ConnectionManager class
			con = ConnectionManager.getConnection();			
			//3. create statement			
			String sql = "UPDATE product SET Product_Quantity=? WHERE ProductID=?";
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Product_Quantity);
				
			ps.setInt(2, prodid);
			//4. execute query
			ps.executeUpdate();				
			//5. close connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
}

