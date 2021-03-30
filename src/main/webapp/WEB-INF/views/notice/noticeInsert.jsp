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
		<h1>Notice Insert Page</h1>
		<form action="./noticeInsert" method="post">
			<div class="form-group">
				<label for="writer">writer</label> <input type="text"
					class="form-control" readonly="readonly" id="writer" placeholder="writer" name="writer">
			</div>
			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" id="title" placeholder="Title" name="title">
			</div>
			<div class="form-group">
				<label for="contents">Contents</label>
				<textarea class="form-control" id="contents" rows="3" name="contents"></textarea>
			</div>
			<button class="btn btn-dark float-right" >write</button>
		</form>
	</div>


</body>
</html>