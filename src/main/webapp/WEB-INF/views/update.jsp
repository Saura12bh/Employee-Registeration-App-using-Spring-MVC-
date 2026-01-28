<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
		
	<form action="upd" method="post">
  <div class="mb-3">
    <label for="name" class="form-label">Enter name</label>
    <input type="text" name="name"  value="${name}" class="form-control" id="name" aria-describedby="emailHelp">
  </div>
  
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label">Enter Email</label>
    <input type="text" name="email" value="${email}"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Enter Password</label>
    <input type="text"  name="password" value="${password}" class="form-control" id="exampleInputPassword1">
  <button type="submit" class="btn btn-primary">Update</button>
  </div>
</form>
				
		</div>
</body>
</html>