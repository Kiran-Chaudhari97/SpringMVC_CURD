<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file = "./base.jsp" %>
</head>
<body>
			<div class ="container mt-3">
				
				<div class = "row">
				
					<div class = "col-md-6 offset-md-3">
						
						<h1 class ="text-center mb-3"> Chaange Product Detail's </h1>
						<form action="${pageContext.request.contextPath }/handle-product" method="post">
						<input type = "text" value = "${product.id }" name = id"/>
							<div class = "form-group">
								<label for="name">Product Name</label>
								<input type="text"
									   class ="form-control" 
									   id = "name" 
									   aria-describedby = "emailHelp"	
									   name="name" 
									   placeholder="Enter Your Product Name"
									   value = " ${product.name }">
							</div>
							
							<div class="form-group">
							<label for="discription">Product Discription</label>		
							<textarea type="text"
									  class ="form-control" 
									  id = "discription" 
									  name = "discription" 
									  row="5" 
									  placeholder="Enter Your Product Discription">${product.discription }
									  </textarea>
									  </div>
							
							<div class = "form-group">
								<label for="price">Product Price</label>
								<input type="text"
									   class ="form-control" 
									   id = "price" 
									   placeholder ="Enter Your Product Price" 
									   name = "price"
									   value = " ${product.price }">
							           </div>
						
							<div class = "container text-center">
							<a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
							
							<button type="submit" class = "btn btn-primary">Update</button>
							</div>
						</form>
					</div>
				</div>
			</div>
</body>
</html>