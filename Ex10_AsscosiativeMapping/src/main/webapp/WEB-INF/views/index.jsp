<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="minsert" method="post">
		ID : <input name="id"><br><br>
		NAME : <input name="name"><br><br>
		 PASSWORD : <input type="password" name="password"><br><br>
		 <button>회원가입</button>
	</form>
	<form action="binsert" method="post">
		제목 : <input name="title"><br><br>
		내용 : <input name="content"><br><br>
		<button>게시글 작성</button>
	</form>
	
	<form action="mupdate?id=vince" method="post">
		변경할 이름 : <input name="name"><br><br>
		 <button>회원가입</button>
	</form>
</body>
</html>