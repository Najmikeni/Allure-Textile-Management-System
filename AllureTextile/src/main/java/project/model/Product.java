package project.model;

public class Product {
	private int ProductID;
	private String Product_Name;
	private String Product_Desc;
	private double Product_Price;
	private int Product_Quantity;
	private int SupplierID;
	
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	public String getProduct_Desc() {
		return Product_Desc;
	}
	public void setProduct_Desc(String product_Desc) {
		Product_Desc = product_Desc;
	}

	
	public double getProduct_Price() {
		return Product_Price;
	}
	public void setProduct_Price(double product_Price) {
		Product_Price = product_Price;
	}
	public int getProduct_Quantity() {
		return Product_Quantity;
	}
	public void setProduct_Quantity(int product_Quantity) {
		Product_Quantity = product_Quantity;
	}

	
	public int getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}
	
	

}
