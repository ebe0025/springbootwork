<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member JPA #02 - Select ${title }</h1>
	<c:forEach items="${mlist}" var="member">
		ID : ${member.id }<br>
		userName : ${member.username }<br>
		email : ${member.email }<hr>
	</c:forEach>
</body>
</html>