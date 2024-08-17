<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<h2> 글 작 성</h2>
	<form action="write" method="post">
		작성자 : <input name="writer"><br><br>
		제목 : <input name="title"><br><br>
		내용 : <textarea rows="5" cols="50" name="content" ></textarea><br><br>
		<button>글쓰기</button>&emsp;
		<a href="list"><button type="button" class="btn btn-info">목록</button></a>
	</form>

<!-- 	<form action="" method="post">
		<label for="writer" class="visually-hidden">작성자</label>
		<input type="text" class="form-control-plaintext" id="writer" name="">
	</form> -->
</body>
</html>