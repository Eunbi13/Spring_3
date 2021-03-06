<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>

<style type="text/css">
	.r1{
		color: red;
	}
	.r2{
		color: blue;
	}

</style>


<title>Insert title here</title>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
	<h1>memberJoin page</h1>
	<h1>v5</h1>
	<div class="container">
		<form id="frm" action="./memberJoin" method="post"  enctype="multipart/form-data">
			<div class="form-group">
				<label for="id">ID:</label> <input type="text"
					class="form-control" placeholder="Enter id" id="id" name="id">
					<h6 id="idResult"></h6>
			</div> <!-- id는 6글자 이상 아이디에서 블러 이벤트,,6글자 미만이면 <h4>사이에 6글자 미만입니다 출력-->
			
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="pw" name="pw">
					<h6 id="pwResult"></h6>
			</div> <!-- pw는 8글자 이상 -->
			
			<div class="form-group">
				<label for="pw">Password:</label> <input type="password"
					class="form-control" placeholder="Enter password" id="pw2" name="pw2"><!-- 어차피 안쓰는 파라미터 네임은 빼도 된다. -->
					<h6 id="pw2Result"></h6>
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
			
			<div class="form-group">
				<label for="avatar">Avatar</label> <input type="file"
					class="form-control exist" placeholder="Enter avatar" id="avatar" name="avatar">
			</div>
			
			<input type="submit" value="Join" id="btn" class="btn btn-primary" >
		</form>

	</div>
	<!-- <script type="text/javascript" src="../resources/js/memberJoin.js"></script> -->
	
</body>
</html>