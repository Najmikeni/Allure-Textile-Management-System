<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
  <%
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);

  if(session.getAttribute("sessionEmail")==null)	  
      response.sendRedirect("/AllureTextile/login.jsp");
  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="css/staff.css">		
	<title>Update Supplier</title>
</head>
<body style="background-color: #FFDAB9;">
<div class="container"></div>
<div class="container">
<br>
<h3>Update Supplier</h3>
<br><br>
  <form action="SupplierController" method="POST">
  <div class="mb-3">
    <label for="SupplierID" class="form-label">Supplier Id</label>
        <input type="text" class="form-control" name="SupplierID" value="<c:out value="${supplier.getSupplierID()}"/>" readonly/> 
  </div><br>
    <div class="mb-3">
    <label for="StaffID" class="form-label">Staff Id</label>
        <input type="text" class="form-control" name="StaffID" value="<c:out value="${supplier.getStaffID()}"/>" readonly/> 
  </div><br>
    <div class="mb-3">
    <label for="Supplier_Name" class="form-label">Supplier Name</label>
    <input type="text" class="form-control" id="Supplier_Name" name="Supplier_Name" value="<c:out value="${supplier.getSupplier_Name()}"/>" required>    
  </div><br>
  <div class="mb-3">
    <label for="Address" class="form-label">Address</label>
    <input type="text" class="form-control" id="Address" name="Address" value="<c:out value="${supplier.getAddress()}"/>" required>   
  </div><br>
  <div class="mb-3">
    <label for="Email" class="form-label">Email</label>
    <input type="text" class="form-control" id="Email" name="Email" value="<c:out value="${supplier.getEmail()}"/>" required>   
  </div><br>
   <div class="mb-3">
    <label for="NoPhone" class="form-label">Phone Number</label>
        <input type="text" class="form-control" id="NoPhone" name="NoPhone" value="<c:out value="${supplier.getNoPhone()}"/>" required>
  </div><br>
  <div class="mb-3">
    <input type="submit" class="btn1" value="Submit">
    <input type="reset" class="btn1" value="Reset">
  </div><br>    
  <div class="container1">
  	<a href="SupplierController?action=viewSupplier&SupplierID=<c:out value="${supplier.getSupplierID()}"/>" class="btn1 effect04"><span>Back</span></a>
  </div> 
  </form>
</div>
</body>
</html>