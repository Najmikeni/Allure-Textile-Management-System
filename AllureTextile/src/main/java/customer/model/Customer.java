package customer.model;

public class Customer {
	private int CustomerID,id;
	private String Cust_name,Email,Address,CustNo;
	public Customer() {
	
}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		this.CustomerID = customerID;
	}
	public String getCust_name() {
		return Cust_name;
	}
	public void setCust_name(String cust_name) {
		this.Cust_name = cust_name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getCustNo() {
		return CustNo;
	}
	public void setCustNo(String custNo) {
		this.CustNo = custNo;
	}

}
