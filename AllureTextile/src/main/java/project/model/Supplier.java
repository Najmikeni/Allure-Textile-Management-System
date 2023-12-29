package project.model;

public class Supplier {
	private int SupplierID;
	private String Supplier_Name;
	private String Address;
	private String Email;
	private String NoPhone;
	private int StaffID;

	public Supplier() {}
	
	public int getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(int supplierID) {
		SupplierID = supplierID;
	}
	public String getSupplier_Name() {
		return Supplier_Name;
	}
	public void setSupplier_Name(String supplier_Name) {
		Supplier_Name = supplier_Name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNoPhone() {
		return NoPhone;
	}
	public void setNoPhone(String noPhone) {
		NoPhone = noPhone;
	}
	public int getStaffID() {
		return StaffID;
	}

	public void setStaffID(int staffID) {
		StaffID = staffID;
	}
	
}
