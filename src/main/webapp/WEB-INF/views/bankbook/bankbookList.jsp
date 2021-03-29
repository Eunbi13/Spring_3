<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<c:import url="../template/bootStrap.jsp"></c:import>

<title>BankBook</title>
</head>
<body>

<c:import url="../template/header.jsp"></c:import>

<div class="container">
<h2>BankBook List</h2>

<table class="table">
	<thead class="thead-dark">
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
</div>
<div class="container">
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="#">Previous</a></li>
			
			<c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
				<li class="page-item"><a class="page-link" href="./bankbookList?curPage=${i}">${i}</a></li>
			</c:forEach> 
			
			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		</ul>
	</div>
</body>
</html>