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
	<title>List Product</title>

</head>
<body>
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">        
  		<a class="navbar-brand" class="active" href="StaffController?action=mainPage">Home</a>
  	
    </div>
  </nav>
  <body style="background-color: #FFDAB9;">
  
</div>
<div class="container"></div>
<div class="container">
<br><br>
<h3>List of Products</h3>
<br><br>
<div class="container1">
	<a href="ProductController?action=addProduct" class="btn2 effect04" ><span>ADD PRODUCT</span></a>
</div><br>
<table class="table table-striped" style="width:100%">
  <tr>
    <th>Product Id</th>
    <th>Product Name</th>
    <th>Price</th>
    <th>Status</th>
    <th colspan="3">Actions</th>
  </tr>
 <c:forEach items="${products}" var="product" varStatus="products">
  <tr>
    <td><c:out value="${product.getProductID()}" /></td>
    <td><c:out value="${product.getProduct_Name()}" /></td>
    <td><c:out value="${product.getProduct_Price()}" /></td>
    <td><div class="container1">
    	<a href="ProductController?action=viewProduct&ProductID=<c:out value="${product.getProductID()}" />" class="btn1 effect01"><span>View</span></a>
   	</div></td>
    <td><div class="container1">
    	<a href="ProductController?action=updateProduct&ProductID=<c:out value="${product.getProductID()}" />" class="btn1 effect02"><span>Update</span></a>
    </div></td>
    <td><div class="container1">
    
    	<a href="ProductController?action=deleteProduct&ProductID=<c:out value="${product.getProductID()}"/>" class="btn1 effect03" onclick="return confirm('Are you sure to delete?')"><span>Delete</span></a>
   	</div></td>   
  </c:forEach>
</table>
</div>

	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</body>
</html>
