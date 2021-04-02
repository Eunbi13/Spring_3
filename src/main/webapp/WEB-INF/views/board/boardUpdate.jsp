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

	<h1>${board } Update page</h1>


	<div class="container">
		<form action="./${board }Update?num=${dto.num}" , method="post">

			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control" value="${dto.title }" id="title" name="title">
			</div>
			<div class="form-group">
				<label for="contents">Contents</label> <input type="text"
					class="form-control" value="${dto.contents }" id="contents"
					name="contents">
			</div>



		</form>





	</div>

</body>
</html>