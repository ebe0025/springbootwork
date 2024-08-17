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
	<h1>JPQL - Name Like</h1>
	<c:forEach items="${member }" var="m">
		아이디 : ${m.id } <br>
		이름 : ${m.name } <br>
		이메일 : ${m.email }<hr>
	</c:forEach>
</body>
</html>