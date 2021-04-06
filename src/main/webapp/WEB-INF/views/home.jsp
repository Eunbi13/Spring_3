<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<c:import url="./template/bootStrap.jsp"></c:import>
<link rel="stylesheet" href="./resources/css/test.css">

	

<title>Home!</title>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>

	<button class="b">Button</button>
	<button id="btn" class="b">Click</button>
	<button id="btn2" class="b">Click</button>
	<h1 id="t">version 8</h1>
	
	<script type="text/javascript">
	
		$(".b").click(function(){
			alert($("#t").text());
		});
		
	</script>
</body>
</html>