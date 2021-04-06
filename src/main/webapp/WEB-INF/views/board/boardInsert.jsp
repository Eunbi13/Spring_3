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
		<h1>v7</h1>
		<form id="frm" action="./${board }Insert" method="post" >
			<div class="form-group">
				<label for="writer">writer</label> <input type="text"
					class="form-control mycheck" readonly="readonly" id="writer" value="${member.name}" name="writer">
			</div>
			
			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control exist mycheck" id="title" placeholder="Title" name="title">
			</div><!-- 비어있음 x -->
			
			<div class="form-group">
				<label for="contents">Contents</label>
				<textarea class="form-control exist mycheck" id="contents" rows="3" name="contents"></textarea>
			</div> <!-- 비어잇음 x -->
			
		
			<input type="button" id="btn" value="write" class="btn btn-dark float-right" >
		</form>
	</div>
			<!-- <script type="text/javascript" src="../resources/js/insertCheck.js"></script> -->
	<script type="text/javascript" src="../resources/jquery/boardInsert.js"></script>

</body>
</html>