<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="css/style.css">	
	<title>Update Product</title>
</head>
<body>
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">        
  		<a class="navbar-brand" class="active" href="StaffController?action=mainPage">Home</a>
  		<a class="navbar-brand" href="CustomerListController">Manage Customer</a>
  		<a class="navbar-brand" href="StaffController?action=listStaff">Staff List</a> 
  		<a class="navbar-brand" href="SupplierController?action=listSupplier">Manage Supplier</a>  	
   </div>
    </nav>
</div>
<body style="background-color: #FFDAB9;">

<div class="container"></div>
<div class="container">
<br><br>
<h3>Update Product</h3>
<br><br>
  <form action="ProductController" method="POST">
  <div class="mb-3">
    <label for="ProductID" class="form-label">Product Id</label>    
    <input type="text" class="form-control" id="ProductID" name="ProductID" value="<c:out value="${product.getProductID()}"/>" readonly>   
  </div>     
  <div class="mb-3">
    <label for="Product_Name" class="form-label">Product Name</label>    
    <input type="text" class="form-control" id="Product_Name" name="Product_Name" value="<c:out value="${product.getProduct_Name()}"/>" required>   
  </div>
  <div class="mb-3">
    <label for="Product_Desc" class="form-label">Product Description</label>    
    <input type="text" class="form-control" id="Product_Desc" name="Product_Desc"value="<c:out value="${product.getProduct_Desc()}"/>" required>   
  </div>
 
  <div class="mb-3">
    <label for="Product_Price" class="form-label">Price</label>    
    <input type="number" class="form-control" id="Product_Price" name="Product_Price" value="<c:out value="${product.getProduct_Price()}"/>" required>   
  </div>
  <div class="mb-3">
    <label for="Product_Quantity" class="form-label">Quantity</label>    
    <input type="number" class="form-control" id="Product_Quantity" name="Product_Quantity" value="<c:out value="${product.getProduct_Quantity()}"/>" required>    
  </div>
  <div class="mb-3">
  <label for="SupplierID" class="form-label">Supplier Id</label>    
  <select class="form-control" id="SupplierID" name="SupplierID">  
    	<c:forEach items="${suppliers}" var="supplier"> 
      		<option value="${supplier.getSupplierID()}" ${supplier.getSupplierID() == selectedSupplier ? 'selected="selected"':''}>
      		<c:out value="${supplier.getSupplierID()}" /> - <c:out value="${supplier.getSupplier_Name()}" /></option>
      	</c:forEach>
    </select>         
  </div>
  <div class="mb-3">
    <input type="submit" class="btn1 effect04" value="Submit"> 
    <input type="reset" class="btn1 effect04" value="Reset">  
  </div>
  </form>
</div>

</body>
</html>