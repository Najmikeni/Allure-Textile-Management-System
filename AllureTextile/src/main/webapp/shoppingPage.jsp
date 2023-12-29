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
	<title>shopping page</title>

</head>
<body>
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">        
  		<a class="navbar-brand" class="active" href="CustomerHome.html">Home</a>
  		<a class="navbar-brand" href="LogoutController">Logout</a>  	
    </div>
  </nav>
</div>
<body style="background-color: #FFDAB9;">
<div class="container"></div>
<div class="container">
<br><br>
<h3>Shop Now!</h3>
<br><br>

<table class="table table-striped" style="width:100%">
  <tr>
    <th>Product Id</th>
    <th>Product Name</th>
    <th>Price</th>
    <th colspan="3">Action</th>
  </tr>
 <c:forEach items="${products}" var="product" varStatus="products">
  <tr>
    <td><c:out value="${product.getProductID()}" /></td>
    <td><c:out value="${product.getProduct_Name()}" /></td>
    <td><c:out value="${product.getProduct_Price()}" /></td>
    <td><div class="container1">
    <a href ="ProductController?action=viewProductCustomer&ProductID=<c:out value="${product.getProductID()}"/>" class="btn1 effect04"><span>PROCEED</span></a>
    </div></td>
 </tr>
  </c:forEach>
</table>
</div>
</body>
</html>
