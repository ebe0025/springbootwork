<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	#outer { text-align: center;}
	body {width:800px; margin: 0 auto;}
	a {text-decoration: none; cursor: pointer; color:black;}
</style>
</head>
<body>
	<br>
	<h1 align="center">게 시 판</h1>
	<p>총 레코드수 : ${totalRecord }</p>
	${selectOne }
	<table class="table">
		<tr align="center">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${list }" var="bList">
			<tr>
				<td align="center">${bList.boardno}</td>
				<td align="center"><a href="detail?boardno=${bList.boardno}">${bList.title }</a></td>
				<td align="center">${bList.writer }</td>
				<td align="center"><a href="delete?boardno=${bList.boardno}"><button type="button" class="btn btn-outline-danger">삭제</button></a></td>
			</tr>
		</c:forEach>
	</table>
	<p align="right"><a href="writerForm"><button type="button" class="btn btn-info">글작성</button></a>
</body>
</html>