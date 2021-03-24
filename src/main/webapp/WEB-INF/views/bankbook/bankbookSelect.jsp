<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>bankbook select page</h1>
	
	<h3> Name: ${dto.bookName }</h3>
	<h3> Rate: ${dto.rate }</h3>
	<h3> Sale: ${dto.sal }</h3>
	
	<a href="./bankbookDelete?bookNum=${dto.bookNum }">Delete</a>
	<a href="./bankbookUpdate?bookNum=${dto.bookNum }">Update</a>
	
</body>
</html>