<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  response.addHeader("Pragma", "no-cache");
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  response.addHeader("Cache-Control", "pre-check=0, post-check=0");
  response.setDateHeader("Expires", 0);

  if(session.getAttribute("sessionEmail")==null)	  
      response.sendRedirect("/AllureTextile/login.jsp");
  %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/customerStyle.css">
<meta charset="ISO-8859-1">
<title>Update Customer</title>
<style>
h1{
font-size:24px;
text-align:center;
}
</style>
</head>
<body>
	<div class = "topbar-nav">
		<a href = "CustomerHome.html" class = "split-left">Home</a>
		<a href = "CustomerByIDController" class = "split-left">Your Account</a>
		<a href = "LogoutController" class = "split-right">Logout</a>
	</div>
	
	
		<h1>Update Account</h1>
		<form action ="updateCustomer" method ="POST">
		
			<label for = "Cust_name">Name</label><br>
			<input type="text" class="form-control" name = "Cust_name" placeholder = "Name" id="Cust_name" required><br>
			
			
			<label for = "CustNo">Phone Number</label><br>
			<input type="number" class="form-control" name = "CustNo" placeholder = "Phone Number" id="CustNo" required><br>
			
			<label for ="Address">Address</label><br>
			<textarea rows = "5" class="form-control" cols = "60" name = "Address" placeholder = "Address" id="Address" required>
			</textarea><br>
			<input type = "submit" class ="profile-update" value = "Update">
		
		</form>
		
		
		
	
	
</body>
</html>