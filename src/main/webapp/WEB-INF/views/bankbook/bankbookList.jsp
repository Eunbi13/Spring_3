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
		<c:if test="${pager.pre }">
			<li class="page-item"><a class="page-link" 
			href="./bankbookList?curPage=${pager.startNum-1 }&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
			</c:if>
			
			
			<c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
				<li class="page-item"><a class="page-link" href="./bankbookList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			</c:forEach> 
			<c:if test="${pager.next }">
			<li class="page-item"><a class="page-link" 
			href="./bankbookList?curPage=${pager.lastNum +1 }&kind=${pager.kind}&search=${pager.search}">Next</a></li>
			</c:if>
		</ul>
	</div>
	
	<div class="container">

		<div class="input-group mt-3 mb-3">
			<form action="./bankbookList" class="form-inline">
				<div class="input-group-prepend">
					<select class="form-control" id="sel1" name="kind">
						<option>BookNum</option>
						<option>BookName</option>
						<option>Sal</option>
					</select>
				</div>
				<input type="text" class="form-control" placeholder="Search" name="search">
				<div class="input-group-append">
					<button class="btn btn-success" type="submit">Search</button>
				</div>
			</form>
		</div>

	</div>
</body>
</html>