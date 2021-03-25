<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>account List page</h1>
	
	<table>
	<thead>
		<tr> 
			<th>Id</th>
			<th>Account Num</th>
			<th>OpenData</th>
			<th>BookNum</th>
			<th>Balance</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${accountList }" var="dto">
		<tr>
			<td>${dto.id} </td><!-- dto.@@@이거 멤버dto클래스의 getter이름임 -->
			<td><a href="./accountSelect?accountNum=${dto.accountNum}" >${dto.accountNum} </a></td><!-- 리스트에서  select하려면 북넘버를 보내줘야해 파라미터 공략에 따라 링크 씀-->
			<td>${dto.openDate} </td>
			<td>${dto.bookNum} </td>
			<td>${dtp.balance} </td>
		</tr>
	</c:forEach>
	</tbody>
</table>
	
	
</body>
</html>