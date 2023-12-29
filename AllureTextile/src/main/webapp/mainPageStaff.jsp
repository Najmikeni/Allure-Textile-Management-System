<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<link rel="stylesheet" type="text/css" href="css/ripple.css">	
	<title>Staff Main Page</title>
</head>
<body style="background-color: #FFF0F5;">
<div class="Iam">
<div class="fade-in">     
    	<img src="image/logo.png" style="border-radius: 30%;" > 
   	</div>
<b>
  <div class="innerIam">
    Welcome to Textile Allure<br/>
    New Trends of Textile Industries<br/>
    In one way or another<br />
    textile are nearly everything<br />
    we use everyday
    </div>
</b>
</div>
<div class="container">
    <div class="fade-in">     
    	<img src="image/picture.jpeg" width="200" height="200" style="border-radius: 80%;" > 
   	</div><br>
   	<div class="fade-in">      
    	<img src="image/picture2.jpg" width="220" height="220" style="border-radius: 80%;" > 
   	</div><br>
   	<div class="fade-in">
   		<img src="image/picture3.jpeg" width="250" height="250" style="border-radius: 80%;" >    
   	</div>	
</div>
<ul>
  <li><a href="StaffController?action=listStaff">Staff List</a></li>
  <li><a href="CustomerListController">Manage Customer</a></li>
  <li><a href="ProductController?action=listProductStaff">Manage Product</a></li>
  <li><a href="SupplierController?action=listSupplier">Manage Supplier</a></li>
  <li><a href="OrderController?action=listOrder">Manage Order</a></li>
  <li><a href="register.jsp">Register</a></li>
  <li><a href="LogoutController">Logout</a></li>
</ul>
</body>
</html>