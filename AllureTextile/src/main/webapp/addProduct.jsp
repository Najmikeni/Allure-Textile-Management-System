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
	<title>Add Product</title>
</head>
<body>
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
<h3>Add Product</h3>
<br><br>
  <form action="ProductController" method="POST">  
  <div class="mb-3">
    <label for="Product_Name" class="form-label">Product Name</label>    
    <input type="text" class="form-control" id="Product_Name" name="Product_Name" placeholder="Product Name.." required>   
  </div>
  <div class="mb-3">
    <label for="Product_Desc" class="form-label">Product Description</label>    
    <input type="text" class="form-control" id="Product_Desc" name="Product_Desc" placeholder="Product Description.." required>   
  </div>
  <div class="mb-3">
    <label for="Product_Price" class="form-label">Price</label>    
    <input type="text" class="form-control" id="Product_Price" name="Product_Price" placeholder="Price.." required>   
  </div>
  <div class="mb-3">
    <label for="Product_Quantity" class="form-label">Quantity</label>    
    <input type="number" class="form-control" id="Product_Quantity" name="Product_Quantity" placeholder="Quantity.." required>    
  </div>

  <div class="mb-3">
  <label for="Supplier_Name" class="form-label">Supplier Id</label>    
  <select class="form-control" id="sid" name="SupplierID">  
    	<c:forEach items="${suppliers}" var="supplier"> 
      		<option value="<c:out value='${supplier.getSupplierID()}'/>"><c:out value="${supplier.getSupplierID()}" /> - <c:out value="${supplier.getSupplier_Name()}" /></option>
      	</c:forEach>
    </select>         
  </div>
  <div class="mb-3">
    <input type="submit" class="btn1 effect04" value="Submit"> 
    <input type="reset" class="btn1 effect04" value="Reset">  
  </div>
  <div class="container1">
  <a href="ProductController?action=listProductStaff" class="btn1 effect04"><span>Back</span></a>
  </div>
  </form>
</div>

</body>
</html>