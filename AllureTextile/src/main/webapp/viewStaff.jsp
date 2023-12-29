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
	<title>View Staff</title>
</head>
<body style="background-color: cornsilk;">
<div class="container"></div>
<div class="container">
<br><br>
<h3>Staff Detail</h3>
<br><br>
		<label for="staffID">Staff ID</label>: <c:out value="${staff.getStaffID()}"/><br>
    	<label for=staff_Name>Name</label>: <c:out value="${staff.staff_Name}"/><br>    	
    	<label for="address">Address</label>: <c:out value="${staff.address}"/><br>	
      	<label for="noPhone">No Phone</label>: <c:out value="${staff.noPhone}" /><br>    	
        <label for="id">User ID</label>: <c:out value="${staff.id}"/><br><br>    		     

		<div class="container1">
			<a href="StaffController?action=updateStaff&staffID=<c:out value="${staff.staffID}" />" class="btn2 effect02"><span>Update</span></a>
		</div><br>
		<div class="container1">
			<input type="hidden" id="staffID-${staffs.index}" value="<c:out value="${staff.staffID}"/>">
			<a class="btn2 effect03" onclick="confirmation('${staffs.index}')"><span>Delete</span></a>
		</div><br>
		<div class="container1">
		      <a  href="StaffController?action=listStaff" class="btn2 effect04"><span>Back</span></a>
		</div>
		<script>
			function confirmation(index){
				  var staffID = $("#staffID-" + index).val(); 
				  console.log(staffID);
				  var r = confirm("Delete confirmation?");
				  if (r == true) {				 		  
					  location.href = 'StaffController?action=deleteStaff&staffID=' + staffID;
					  alert("Staff successfully deleted");			
				  } else {				  
				      return false;	
				  }
			}
		</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</div>
</body>
</html>