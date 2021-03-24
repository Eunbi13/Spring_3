<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>bankbook Update Form </h1>
	
	<form action="./bankbookUpdate" method="post">
		Num<input type="hidden" name="bookNum" value="${dto.bookNum }" readonly="readonly"><br>
		<%-- Num<input type="text" name="bookNum" value="${dto.bookNum }" readonly="readonly"><br> --%>
		Name<input type="text" name="bookName" value="${dto.bookName }"><br>
		Rate<input type="text" name="rate" value="${dto.rate }"><br>
		Sale<input type="text" name="sal" value="${dto.sal }"><br>
		<button>Update</button>
	</form>
	
	
</body>
</html>