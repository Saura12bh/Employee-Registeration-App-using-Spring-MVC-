<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
	<th>Name</th>
	<th>Email</th>
	<th>Password</th>
	<th>Delete</th>
	<th>Update</th>
	<c:forEach var="c" items="${m}">
        <tr>
            <td>${c.getName()}</td>
            <td>${c.getEmail()}</td>
            <td>${c.getPassword()}</td>
            <td><a href="delete?name=${c.getName()}">delete</a></td>
            <td><a href="update?name=${c.getName()}&email=${c.getEmail()}&password=${c.getPassword()}">update</a>
        </tr>
    </c:forEach>
	</table>
	
</body>
</html>