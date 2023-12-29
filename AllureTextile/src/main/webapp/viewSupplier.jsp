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
	<title>View Supplier</title>
</head>
<body style="background-color: #FFDAB9;">
<div class="container"></div>
<div class="container">
<br><br>
<h3>Supplier Detail</h3>
<br><br>
		<label for="SupplierID">Supplier ID</label>: <c:out value="${supplier.getSupplierID()}"/><br>
    	<label for="Supplier_Name">Supplier Name</label>: <c:out value="${supplier.getSupplier_Name()}"/><br>    	
    	<label for="Address">Address</label>: <c:out value="${supplier.getAddress()}"/><br>	
      	<label for="Email">Email</label>: <c:out value="${supplier.getEmail()}" /><br>    	 	        
        <label for="NoPhone">Phone Number</label>: <c:out value="${supplier.getNoPhone()}"/><br><br>        
       
       <div class="container1">
       	<a href="SupplierController?action=updateSupplier&SupplierID=<c:out value="${supplier.getSupplierID()}" />" class="btn2 effect02"><span>Update</span></a>
       </div><br>
       <div class="container1">
       	<input type="hidden" id="SupplierID-${suppliers.index}" value="<c:out value="${supplier.getSupplierID()}"/>">
       	<a class="btn2 effect03" onclick="confirmation('${suppliers.index}')"><span>Delete</span></a>
       </div><br>
       <div class="container1">
		<a  href="SupplierController?action=listSupplier" class="btn2 effect04"><span>Back</span></a>
		</div>
		
		<script>
		function confirmation(index){					  
			  var SupplierID = $("#SupplierID-" + index).val();			 
			  console.log(SupplierID);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'SupplierController?action=deleteSupplier&SupplierID=' + SupplierID;
				  alert("Supplier successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
        
</div>
</body>
</html>