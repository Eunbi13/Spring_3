<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<div class="container">
		<h1>Notice List Page</h1>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Title</th>
					<th>Name</th>
					<th>Date</th>
					<th>Hit</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.title}</td>
					<td>${dto.writer}</td>
					<td>${dto.regDate}</td>
					<td>${dto.hit }</td>
				</tr>
			</tbody>
		</table>
		<div class="container-fluid">
			
			${dto.contents }
		</div>
	<c:if test="${member.id eq 'admin' }">
		<a href="./noticeUpdate?num=${dto.num }" class="btn btn-dark" >Update</a> <a
			href="./noticeDelete?num=${dto.num }" class="btn btn-danger" >Delete</a>
	</c:if>
	</div>


</body>
</html>