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

	<h1>${board }Update page</h1>

	<div class="container">
		<h2>${board}Update form</h2>
		<form id="frm" action="./${board}Update" method="post">
			<input type="hidden" name="num" value="${param.num}">
			<div class="form-group">
				<label for="writer">Writer:</label> <input type="text"
					readonly="readonly" value="${dto.writer}" class="form-control"
					id="writer" name="writer">
			</div>
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" id="title" name="title" value="${dto.title}">
			</div>

			<div class="form-group">
				<label for="contents">Contents:</label>
				<textarea class="form-control" rows="5" id="contents"
					name="contents">${dto.contents}</textarea>
			</div>

			<input type="submit" id="btn" value="UPDATE" class="btn btn-primary">
		</form>
	</div>
</body>
</html>