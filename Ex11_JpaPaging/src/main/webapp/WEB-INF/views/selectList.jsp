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

	<h1>JPA Paging - Name Like Paging</h1>
	총 게시글의 갯수 : ${totalElements }<br>
	총 페이지 수  : ${totalPages }<br>
	한 페이지당 항목 수 : ${size }<br>
	현재 페이지 항목수 : ${numberOfElements }<br>
	
	<c:forEach items="${members }" var="member">
	ID : ${member.id }<br>
	NAME= ${member.name }<br>
	Email = ${member.email }<hr>
	</c:forEach>

</body>
</html>