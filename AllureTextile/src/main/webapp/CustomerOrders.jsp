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
	<title>Your Orders</title>
</head>
<body style="background-color: #FFDAB9;">
<div class="container">
<div class="main1">
	<header style="font-size: 0px; background-color:#CD5C5C;">
  <ul>
	<li><a href="CustomerHome.html">Home</a></li>
	<li></li>
	<li></li>
	<li></li>
	<li><a href="LogoutController">Logout</a></li>
  </ul>
  </header>
  </div>
  </div>
<div class="container">
<div class="container1">
<h1>Your Orders</h1>
</div>

<table class="table table-striped" style="width:100%">
  <tr>
    <th>Order ID</th>
    <th>Product Name</th>
    <th>Quantity</th>    
    <th>Total</th>
    <th colspan="1"></th>
  </tr>
 <c:forEach items="${ordercuslist}" var="order" varStatus="ordercuslist">
  <tr>
    <td><c:out value="${order.getOrderID()}" /></td>
    <td><c:out value="${order.getProduct_name()}" /></td>
    <td><c:out value="${order.getQuantity()}" /></td>    
    <td><c:out value="${order.getTotal()}" /></td>
    <td><div class="container1">
    <a href = "InvoiceController?OrderID=<c:out value="${order.getOrderID()}"/>" class="btn1 effect01"><span>Invoice</span></a>
    <a href = "orderdetails?OrderID=<c:out value="${order.getOrderID()}"/>" class="btn1 effect02"><span>Detail</span></a>
  </div></td>
  </tr>
  </c:forEach>
</table>
</div>
</body>
</html>