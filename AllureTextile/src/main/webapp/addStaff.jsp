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
	<title>Add Staff</title>
</head>
<body style="background-color: #E9967A;">
<div class="container">
    <div class="main1">
	  <header style="font-size: 0px; background-color:#CD5C5C;">
	    <ul>
	      <li><a href="StaffController?action=mainPage">Home</a></li>
	      <li><a href="CustomerController?action=listCustomer">Manage Customer</a></li>
	      <li><a href="StaffController?action=listStaff">Staff List</a></li>
	      <li><a href="RegisterController">Register</a></li>
	      <li><a href="SupplierController?action=listSupplier">Manage Supplier</a></li>
	    </ul>
	  </header>
	 </div>	
	 </div>
<div class="container">
<div class="container1">
	<h1>Add Staff</h1>
</div><br>
<form action="StaffController" method="post">
 <div class="mb-3">
	<label for="staff_Name" class="form-label">Staff Name:</label>    
	 	<input type="text" class="form-control" id="name" name="name" placeholder="Name.." required><br>
    <label for="address" class="form-label">Address:</label>    
    	<input type="text" class="form-control" id="address" name="address" placeholder="Address.." required>   
  </div><br>
  <div class="mb-3">
    <label for="noPhone" class="form-label">No Phone:</label>    
    <input type="text" class="form-control" id="noPhone" name="noPhone" placeholder="NoPhone.." required>   
  </div><br>
  <label for="id" class="form-label">User ID:</label>    
	<select class="form-control" id="id" name="id">  
	   	<c:forEach items="${users}" var="user"> 
     		<option value="<c:out value='${user.id}'/>"><c:out value="${user.id}" /> - <c:out value="${user.email}" /></option>
   		</c:forEach>
	</select><br/> 
    <input type="submit" class="btn1" value="Submit"> 
    <input type="reset" class="btn1" value="Reset">
  </form>
</div>
</body>
</html>