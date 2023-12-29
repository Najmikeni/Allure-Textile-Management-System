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
	<title>Staff List</title>
</head>
<body style="background-color: #FFDAB9;">
  	<div class="container">
    <div class="main1">
	  <header style="font-size: 0px; background-color:#CD5C5C;">
	    <ul>
	     	<li><a href="StaffController?action=mainPage">Home</a></li>
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
		<h1>Staff List</h1>
	</div>

</div><br>
	<table class="table table-striped" style="width:100%">
	  <tr>
	    <th>Staff ID</th>
	    <th>Name</th>
	    <th>Address</th>    
	    <th>Phone No</th>
	    <th>User ID</th>
	    <th colspan="1"></th>
	  </tr>
	 <c:forEach items="${staffs}" var="staff" varStatus="staffs">
	  <tr>
	    <td><c:out value="${staff.staffID}" /></td>
	    <td><c:out value="${staff.staff_Name}" /></td>
	    <td><c:out value="${staff.address}" /></td>    
	    <td><c:out value="${staff.noPhone}" /></td>
	    <td><c:out value="${staff.id}" /></td>
	    <td><div class="container1">
			<a href="StaffController?action=viewStaff&staffID=<c:out value="${staff.staffID}"/>" class="btn1 effect01"><span>Detail</span></a>
	  	</div></td>
	  </tr>   
	  </c:forEach>
	</table>
</div>
</body>
</html>
