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
<title>Update Order</title>
<style>
h1{
font-size:24px;
text-align:center;
}
</style>
</head>
<body>
	<div class = "topbar-nav">
		<a href = "mainPageStaff.jsp" class = "split-left">Home</a>
		
		
		
		<a href = "LogoutController" class = "split-right">Logout</a>
	</div>
	
		
		<h1>Update Order <c:out value="${order.getOrderID()}"/></h1>
		<form action ="updateOrderController" method ="POST">
			<label for = "ProductID">Product ID</label><br>
			<input type="text" class="form-control" name = "ProductID" placeholder = "Product ID" id="ProductID" value="<c:out value="${order.getProductID()}"/>" readonly><br>
			<label for = "Product_name">Product Name</label><br>
			<input type="text" class="form-control" name = "Product_name" placeholder = "Product name" id="Product_name" value="<c:out value="${order.getProduct_name()}"/>" required><br>
			<label for = "Price">Price</label><br>
			<input type="number" class="form-control" name = "Price" placeholder = "Price" id="Price" value="<c:out value="${order.getPrice()}"/>" required><br>
			<label for = "Quantity">Quantity</label><br>
			<input type="number" class="form-control" name = "Quantity" placeholder = "Quantity" id="Quantity" value="<c:out value="${order.getQuantity()}"/>" required><br>
			 
			<input type = "submit" class ="profile-update" value = "Update">
			<input type="hidden" value = "${order.getOrderID()}" name ="OrderID">
    		<button><a href="OrderController?action=listOrder">Back</a></button>
		</form>
		
		
		
	
	
</body>
</html>