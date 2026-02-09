<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
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
		
	<form action="saveSubject" method="post" enctype="multipart/form-data">
  <div class="mb-3">
    <label for="name" class="form-label">Enter Subject name </label>
    <input type="text" name="name"  class="form-control" id="name" aria-describedby="emailHelp">
  </div>
  
  <div class="mb-3">
    <label for="img" class="form-label">Enter Image  </label>
    <input type="file" name="img"  class="form-control" id="img" aria-describedby="emailHelp">
  </div>
  
  <div class="mb-3">
    <label for="pdf" class="form-label">Enter Subject name </label>
    <input type="file" name="pdf"  class="form-control" id="pdf" aria-describedby="emailHelp">
  </div>
  
<div class="form-group m2">
<h1>Select Subject</h1>
<c:forEach var="c" items="${empList}">
<input type="checkbox" name="course" value="${c.getName()}"> :${c.getName()}
</c:forEach> 
  
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
				
		</div>
		
</body>
</html>