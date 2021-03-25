<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page session="false" %> 이거 있으면 session사용 못함--%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<!-- 현재 위치가 root, -->
<a href="./bankbook/bankbookList"> BankBookList </a><br>

<c:if test="${empty sessionScope.member }">
<a href="./member/memberJoin">Join</a><br>
<a href="./member/memberLogin">Login</a>
</c:if>

<c:if test="${not empty sessionScope.member }">
<h1>${sessionScope.member.id }님 환영합니다</h1>
<a href="./member/memberPage">Mypage</a><br>
<a href="./member/memberLogout">Logout</a>
</c:if>
</body>
</html>
