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

<h1>${board } select page </h1>

<div class="container">
	<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Title</th>
					<th>Contents</th>
					<th>Date</th>
					<th>Hit</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.title }</td>
					<td>${dto.contents }</td>
					<td>${dto.date }</td>
					<td>${dto.hit }</td>
				</tr>
			</tbody>
	</table>
	
	<a href="./${board }Update?num=${dto.num}" class="btn btn-danger">Update</a>
	<a href="./${board }Delete?num=${dto.num}" class="btn btn-info">Delete</a>
</div>

</body>
</html>