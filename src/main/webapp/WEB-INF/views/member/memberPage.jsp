<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>My Page</h1>
<h3>id: ${sessionScope.member.id }</h3>
<h3>pw: ${sessionScope.member.pw }</h3>
<h3>name: ${sessionScope.member.name }</h3>
<h3>phone: ${sessionScope.member.phone }</h3>
<h3>email: ${sessionScope.member.email }</h3>
<a href="./memberDelete">탈퇴</a>
<a href="./memberUpdate">수정</a>


</body>
</html>