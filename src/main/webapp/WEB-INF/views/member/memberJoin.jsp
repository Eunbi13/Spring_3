<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>memberJoin page</h1>
	<div class="container">
		<form action="./memberJoin" method="post">
			<div class="form-group">
				<label for="id">ID:</label> <input type="text"
					class="form-control" placeholder="Enter id" id="id" name="id">
			</div> <!-- id는 6글자 이상 -->
			
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="pw" name="pw">
			</div> <!-- pw는 8글자 이상 -->
			
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="pw2" name="pw">
			</div> <!-- 비번 확인용, 일치하는지 -->
			
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control exist" placeholder="Enter email" id="email" name="email">
			</div> <!-- 비어잇음 x -->
			
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control exist" placeholder="Enter name" id="name" name="name">
			</div> <!-- 비어잇음 x -->
			
			<div class="form-group">
				<label for="phone">Phone:</label> <input type="text"
					class="form-control exist" placeholder="Enter phone" id="phone" name="phone">
			</div> <!-- 비어잇음 x -->
			
			<button type="submit" class="btn btn-primary">Submit</button>
			<input type="button" value="join" class="btn btn-primary" onclick="memberJoin()">
		</form>
	<script type="text/javascript" src="../resources/js/memberJoin.js"></script>

	</div>
	
</body>
</html>