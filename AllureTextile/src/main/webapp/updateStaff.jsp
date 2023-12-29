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
	<title>Update Staff</title>
</head>
<body style="background-color: HoneyDew;">
<div class="container"></div>
<div class="container">
<br>
<h3>Update Staff</h3>
<br><br>
  <form action="StaffController" method="post">
  <div class="mb-3">
    <label for="staffID" class="form-label">Staff ID</label>    
    <input type="text" class="form-control" id="staffID" name="staffID" value="<c:out value="${staff.staffID}"/>" readonly>   
  </div><br>     
  <div class="mb-3">
    <label for="staff_Name" class="form-label">Name</label>    
    <input type="text" class="form-control" id="staff_Name" name="staff_Name" value="<c:out value="${staff.staff_Name}"/>" required>   
  </div><br>
  <div class="mb-3">
    <label for="address" class="form-label">Address</label>    
    <input type="text" class="form-control" id="address" name="address" value="<c:out value="${staff.address}"/>" required>   
  </div><br>
  <div class="mb-3">
    <label for="noPhone" class="form-label">No Phone</label>    
    <input type="number" class="form-control" id="noPhone" name="noPhone" value="<c:out value="${staff.noPhone}"/>" required>    
  </div><br>
 
  <div class="mb-3">
    <input type="submit" class="btn1" value="Submit"> 
    <input type="reset" class="btn1" value="Reset">
  </div><br>
  <div class="container1">
	<a href="StaffController?action=viewStaff&staffID=<c:out value="${staff.staffID}"/>" class="btn1 effect04"><span>Back</span></a>
  </div>
  </form>
</div>
</body>
</html>
