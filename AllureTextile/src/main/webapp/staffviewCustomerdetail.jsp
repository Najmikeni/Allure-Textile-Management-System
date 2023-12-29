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
	<title>View Customer detail</title>
</head>
<body style="background-color: #FFDAB9;">
<div class="container"></div>
<div class="container">
<br><br>
<h3>Customer Detail</h3>
<br><br>
		<label for="CustomerID">Customer ID</label>: <c:out value="${customer.getCustomerID()}"/><br>
		<label for="id">ID</label>: <c:out value="${customer.getID()}"/><br>
    	<label for="Cust_name">Customer Name</label>: <c:out value="${customer.getCust_name()}"/><br>    	
    	<label for="Address">Address</label>: <c:out value="${customer.getAddress()}"/><br>	
      	<label for="Email">Email</label>: <c:out value="${customer.getEmail()}" /><br>    	 	        
        <label for="CustNo">Phone Number</label>: <c:out value="${customer.getCustNo()}"/><br><br>        
       
      
       <div class="container1">
		<a  href="CustomerListController" class="btn2 effect04"><span>Back</span></a>
		</div>
		

        
</div>
</body>
</html>