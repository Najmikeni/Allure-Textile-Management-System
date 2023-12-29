package project.model;


public class Orders {
	private int OrderID;
	private int CustomerID;
	private int ProductID;
	private String Product_name;
	private double Price,Total;
	private int Quantity;
	public int getOrderID() {
		return OrderID;
	}
	public void setOrderID(int OrderID) {
		this.OrderID = OrderID;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int CustomerID) {
		this.CustomerID = CustomerID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int ProductID) {
		this.ProductID = ProductID;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		Total = total;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
}
