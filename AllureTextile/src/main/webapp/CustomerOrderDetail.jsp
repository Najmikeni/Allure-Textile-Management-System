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
<title>Your Order</title>
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
		<a class = "split-right">Logout</a>
	</div>
	
		<h1> Order ID <c:out value = "${order.getOrderID()}" /></h1>
	<div class="home-container">
			
			<label>Customer ID</label><br>
			<c:out value = "${order.getCustomerID()}" /><br>
			<label>Product Name</label><br>
			<c:out value = "${order.getProduct_name()}" /><br>
			<label>Product ID</label><br>
			<c:out value = "${order.getProductID()}" /><br>
			<label>Price</label><br>
			<c:out value = "${order.getPrice()}" /><br>
			<label>Quantity</label><br>
			<c:out value = "${order.getQuantity()}" /><br>
			<label>Total</label><br>
			<c:out value = "${order.getTotal()}" /><br>
			
			<a href="OrderController?action=OrderCusList" class = "button-to-product">Back</a>
			
	</div>
	


</body>
</html>