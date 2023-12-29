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
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>View Product</title>
</head>
<body>
<body style="background-color: #FFDAB9;">

<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">        
  		<a class="navbar-brand" class="active" href="StaffController?action=mainPage">Home</a>
  		<a class="navbar-brand" href="CustomerController?action=listCustomer">Manage Customer</a>
  		<a class="navbar-brand" href="RegisterController">Staff List</a> 
  		<a class="navbar-brand" href="SupplierController?action=listSupplier">Manage Supplier</a>  	
    </div>
  </nav>
</div>
<body style="background-color: #FFDAB9;">

<div class="container">
<br><br>
<h3>View Product</h3>
<br><br>
		<label for="ProductID">Product ID</label>: <c:out value="${product.getProductID()}"/><br>
    	<label for="Product_Name">Product Name</label>: <c:out value="${product.getProduct_Name()}"/><br>    	
    	<label for="Product_Desc">Product Description</label>: <c:out value="${product.getProduct_Desc()}"/><br>    	   	
    	<label for="Product_Price">Price</label>: <c:out value="${product.getProduct_Price()}"/><br>	
      	<label for="Product_Quantity">Stock</label>: <c:out value="${product.getProduct_Quantity()}" /><br>    	    	
        <label for="SupplierID">Supplier Id</label>: <c:out value="${product.getSupplierID()}"/><br><br>
        <div class="container1">   			     
        	<a href="ProductController?action=listProductStaff" class="btn2 effect04"><span>Product List</span></a>
        </div>
        
</div>
</body>
</html>