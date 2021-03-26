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
	<h1>memberLogin page</h1>

	<div class="container">
		<form action="./memberLogin" method="post">
			<div class="form-group">
				<label for="id">ID:</label> <input type="text"
					class="form-control" placeholder="Enter id" id="id" name="id">
			</div>
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="pw" name="pw">
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox"> Remember me
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>
</body>
</html>