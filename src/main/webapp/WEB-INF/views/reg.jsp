<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/SpringMvcRegApp/resources/css/style.css">
<script src="/SpringMvcRegApp/resources/js/main.js"> </script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">
   <script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
	></script>
</head>
<body>
<div class="container">
		
	<form action="save" method="post">
  <div class="mb-3">
    <label for="name" class="form-label">Enter name</label>
    <input type="text" name="name"  class="form-control" id="name" aria-describedby="emailHelp">
  </div>
  
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Enter Email</label>
    <input type="text" name="email"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Enter Password</label>
    <input type="text"  name="password"class="form-control" id="exampleInputPassword1">
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
				
		</div>
</body>
</html>