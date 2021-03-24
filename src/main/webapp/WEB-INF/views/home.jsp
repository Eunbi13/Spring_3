<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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

<a href="./member/memberJoin">Join</a><br>
<a href="./member/memberLogin">Login</a>


</body>
</html>
