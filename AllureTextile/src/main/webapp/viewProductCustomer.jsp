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
	<link rel="stylesheet" type="text/css" href="css/staff.css">
	<title>View Product</title>
</head>
<body style="background-color: #FFDAB9;">
<div class="container">
  <nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">        
  		<a class="navbar-brand" href="ProductController?action=shoppingPage">Back To Shopping Page</a>
    </div>
  </nav>
</div>
<form action="BuyController" method = "GET"> 
<div class="container">
<br><br>
<h3>Buy Now!</h3>
<br><br>
		<label for="ProductID">Product ID</label>: <c:out value="${product.getProductID()}"/><br>
    	<label for="Product_Name">Product Name</label>: <c:out value="${product.getProduct_Name()}"/><br>    	
    	<label for="Product_Desc">Product Description</label>: <c:out value="${product.getProduct_Desc()}"/><br>    	   	
    	<label for="Product_Price">Price</label>: <c:out value="${product.getProduct_Price()}"/><br>	
      	<label for="Product_Quantity">Stock</label>: <c:out value="${product.getProduct_Quantity()}" /><br>    	  	
        <label for="SupplierID">Supplier Id</label>: <c:out value="${product.getSupplierID()}"/><br><br>   	
        <div class="mb-3">
 	
  <div class="quantity">
        <button class="btn minus-btn disabled" type="button">-</button>
        <input type="text" id="Quantity" name="Quantity" value="1" >
        <button class="btn plus-btn" type="button">+</button>
    </div>
</div>
    <script>
        //setting default attribute to disabled of minus button
        document.querySelector(".minus-btn").setAttribute("disabled", "disabled");


        //plus button
        document.querySelector(".plus-btn").addEventListener("click", function() {
            //getting value of input
            valueCount = document.getElementById("Quantity").value;

            //input value increment by 1
            valueCount++;

            //setting increment input value
            document.getElementById("Quantity").value = valueCount;

            if (valueCount > 1) {
                document.querySelector(".minus-btn").removeAttribute("disabled");
                document.querySelector(".minus-btn").classList.remove("disabled")
            }
        })

        //plus button
        document.querySelector(".minus-btn").addEventListener("click", function() {
            //getting value of input
            valueCount = document.getElementById("Quantity").value;

            //input value increment by 1
            valueCount--;

            //setting increment input value
            document.getElementById("Quantity").value = valueCount

            if (valueCount == 1) {
                document.querySelector(".minus-btn").setAttribute("disabled", "disabled")
            }

        })
    </script>

        <br><br><input type="submit" class="btn1 effect04" value ="BUY" onclick="return confirm('Are you sure?')">
        <input type="hidden" id="ProductID" name = "ProductID"value="<c:out value="${product.getProductID()}"/>" readonly>
        
</div>
 </form>
</body>
</html>