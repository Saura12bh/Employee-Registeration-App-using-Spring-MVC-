<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/SpringMvcRegApp/resources/css/style.css">
</head>
<body>
	<h1>Enter name </h1>
	<input type="text" id="name" onkeyup="sr()">
	<table>
	<thead>
	<th>Name</th>
	<th>Email</th>
	<th>Password</th>
	<th>Delete</th>
	<th>Update</th>
	</thead>
	<tbody id="tb">
	<c:forEach var="c" items="${m}">
        <tr>
            <td>${c.getName()}</td>
            <td>${c.getEmail()}</td>
            <td>${c.getPassword()}</td>
            <td><a href="delete?name=${c.getName()}">delete</a></td>
            <td><a href="update?name=${c.getName()}&email=${c.getEmail()}&password=${c.getPassword()}">update</a>
        </tr>
    </c:forEach>
    </tbody>
	</table>
<%-- <script src="${pageContext.request.contextPath}/resources/js/main.js"> --%>
</script>
<script type="text/javascript">
function sr() {

    let name = document.getElementById("name").value;

    fetch("search?name=" + name)
        .then(res => res.json())
        .then(data => {

            let tbody = document.getElementById("tb");

            // clear old rows
            tbody.innerHTML = "";

            data.forEach(emp => {

                // create row
                let tr = document.createElement("tr");

                // create columns
                let tdName = document.createElement("td");
                tdName.innerText = emp.name;

                let tdEmail = document.createElement("td");
                tdEmail.innerText = emp.email;

                let tdPass = document.createElement("td");
                tdPass.innerText = emp.password;

                //update emp
                let tdUpdate = document.createElement("td");
                let a = document.createElement("a");
                a.innerText = "Update";

                a.href = "update?name=" + emp.name + 
                         "&email=" + emp.email + 
                         "&password=" + emp.password;

                tdUpdate.appendChild(a);
                tr.appendChild(tdUpdate);
                
                //delet
                 let tddelet = document.createElement("td");
                let a1 = document.createElement("a");
                a1.innerText = "Delete";

                a1.href = "delete?name=" + emp.name;
                tddelet.appendChild(a1);
                tr.appendChild(tddelet);
  
  				tr.appendChild(tdName);
                tr.appendChild(tdEmail);
                tr.appendChild(tdPass);
				tr.appendChild(tddelet);
				tr.appendChild(tdUpdate);
                // add tr into table body
                tbody.appendChild(tr);
            });
        });
}



</script>
</body>
</html>