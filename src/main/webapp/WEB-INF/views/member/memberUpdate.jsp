<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>member update</h1>
	<form action="memberUpdate" method="post">
		id<input type="text" readonly="readonly" name="id" value="${sessionScope.member.id }"><br>
		pw<input type="password" name="pw" value="${member.pw }"><br>
		name<input type="text" name="name" value="${member.name }"><br>
		email<input type="email" name="email" value="${member.email }"><br>
		phone<input type="text" name="phone" value="${member.phone }"><br>
		<button>button</button>



	</form>
</body>
</html>