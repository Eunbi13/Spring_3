<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>bankbook select page</h1>
	
	<h3> Name: ${requestScope.dto.bookName }</h3>
	<h3> Rate: ${requestScope.dto.rate }</h3>
	<h3> Sale: ${requestScope.dto.sal }</h3>
	
	<c:if test="${not empty member.id }">
	<a href="../account/accountInsert?bookNum=${dto.bookNum }">계좌 개설</a>
	</c:if>
	
	<c:catch><!-- 이셉션캐치(trycatch 마냥) 오류가 생기면 무시해버리겠다.  -->
	<c:if test="${member.id eq 'admin' }">
	<a href="./bankbookDelete?bookNum=${requestScope.dto.bookNum }">Delete</a>
	<a href="./bankbookUpdate?bookNum=${requestScope.dto.bookNum }">Update</a>
	</c:if>
	</c:catch>
	<%-- <c:if test="${not empty member && member.id eq 'admin'}">
	
	<a href="./bankbookDelete?bookNum=${requestScope.dto.bookNum }">Delete</a>
	<a href="./bankbookUpdate?bookNum=${requestScope.dto.bookNum }">Update</a>
	
	</c:if> --%>
	
</body>
</html>