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
	<title>Add Supplier</title>
</head>
<body style="background-color: #FFDAB9;">
<div class="container">
<div class="main1">
	<header style="font-size: 0px; background-color:#CD5C5C;">
  <ul>
	<li><a href="StaffController?action=mainPage">Home</a></li>
	<li></li>
	<li></li>
	<li></li>
	<li><a href="SupplierController?action=listSupplier">Manage Supplier</a></li>
  </ul>
  </header>
  </div>
  </div>
<div class="container">
<div class="container1">
<h1>Add Supplier</h1>
</div><br>
 <form action="SupplierController" method="POST">
  <div class="mb-3">
    <label for="Supplier_Name" class="form-label">Supplier Name:</label>
    <input type="text" class="form-control" id="Supplier_Name" name="Supplier_Name" placeholder="Supplier Name" required><br>
    <label for="Address" class="form-label">Address:</label>
    <input type="text" class="form-control" id="Address" name="Address" placeholder="Supplier Address" required>
  </div><br>
  <div class="mb-3">
    <label for="Email" class="form-label">Email:</label>
    <input type="text" class="form-control" id="Email" name="Email" placeholder="Supplier Email" required><br>
    <label for="NoPhone" class="form-label">Phone Number:</label>
    <input type="text" class="form-control" id="NoPhone" name="NoPhone" placeholder="Supplier Phone Number" required>
  </div><br> 
  <label for = "Staff_Name" class="form-label">Staff ID:</label>
  	<select class="form-control" id="StaffID" name="StaffID">
  		<c:forEach items="${staffs}" var="staff">
  			<option value="<c:out value='${staff.staffID}'/>"><c:out value="${staff.staffID}"/>-<c:out value="${staff.staff_Name}"/></option>
  	</c:forEach>
  	</select><br>
  
    <input type="submit" class="btn1" value="Submit"> 
    <input type="reset" class="btn1" value="Reset"><br> 
    <div class="container1">
    <a href="SupplierController?action=listSupplier" class="btn1 effect04"><span>Back</span></a> 
    </div>
  </form>
</div>
</body>
</html>