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
<meta charset="ISO-8859-1">
<title>Your Account</title>
<link rel="stylesheet" href="css/customerStyle.css">
<style>
h1{
font-size:30px;
text-align:center;
}
label{

font-size:18px;
margin:auto;
color:grey;
}
</style>
</head>
<body>
	<div class = "topbar-nav">
		<a href = "CustomerHome.html" class = "split-left">Home</a>
		<a href = "LogoutController" class = "split-right">Logout</a>
	</div>
	
		<h1>Your Account</h1>
	<div class="home-container">
			<label>UserName</label><br>
			<c:out value = "${customer.getID()}" /><br>
			<label>Customer ID</label><br>
			<c:out value = "${customer.getCustomerID()}" /><br>
			<label>Name</label><br>
			<c:out value = "${customer.getCust_name()}" /><br>
			<label>E-mail</label><br>
			<c:out value = "${customer.getEmail()}" /><br>
			<label>Phone Number</label><br>
			<c:out value = "${customer.getCustNo()}" /><br>
			<label>Address</label><br>
			<c:out value = "${customer.getAddress()}" /><br>
	</div>
			

	


</body>
</html>