<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>BankBook List</h1>

<table>
	<thead>
		<tr> 
			<th>Name</th>
			<th>Rate</th>
			<th>Sale</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${list }" var="dto">
		<tr>
			<td><a href="./bankbookSelect?bookNum=${dto.bookNum}" >${dto.bookName} </a></td><!-- 리스트에서  select하려면 북넘버를 보내줘야해 파라미터 공략에 따라 링크 씀-->
			<td>${dto.rate} </td><!-- dto.@@@이거 멤버dto클래스의 getter이름임 -->
			<td>${dto.sal} </td>
		</tr>
	</c:forEach>
	</tbody>
</table>

</body>
</html>