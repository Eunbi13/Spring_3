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
			</div>
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="pw" name="pw">
			</div>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email"
					class="form-control" placeholder="Enter email" id="email" name="email">
			</div>
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" placeholder="Enter name" id="name" name="name">
			</div>
			<div class="form-group">
				<label for="phone">Phone:</label> <input type="text"
					class="form-control" placeholder="Enter phone" id="phone" name="phone">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
	
	
</body>
</html>