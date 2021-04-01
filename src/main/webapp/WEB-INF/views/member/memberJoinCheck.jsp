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
		<h1>MemberJoin Check Page</h1>
		
		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input" value="" name="c1" id="all">전체 동의
			</label>
		</div>

		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input check" value="" name="c1" >동의
			</label>
		</div>

		<div class="jumbotron">
			<h1>약관1d</h1>
		</div>


		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input check" value="" name="c1" >동의
			</label>
		</div>

		<div class="jumbotron">
			<h1>약관2</h1>
		</div>


		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input check" value="" name="c1" >동의
			</label>
		</div>

		<div class="jumbotron">
			<h1>약관3</h1>
		</div>
		
		<div class="form-check">
			<label class="form-check-label"> <input type="checkbox"
				class="form-check-input check" value="" name="c1" >동의
			</label>
		</div>

		<div class="jumbotron">
			<h1>약관4</h1>
		</div>

	<button  class="btn btn-dark">Join</button>
<script type="text/javascript" src="../resources/js/memberJoinCheck.js"></script>


	</div>

</body>
</html>