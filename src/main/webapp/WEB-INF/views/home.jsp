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

	<button onclick="go()" >Button</button>
	<button id="btn">Click</button>
	<button id="btn2">Click</button>
	<h1>version 8</h1>
	
	<script type="text/javascript">
	let btn = document.getElementById("btn");
	let btn2 = document.getElementById("btn2");
	
	//onclick은 이벤트 명이 아님 on 하고 오는 이름(click)이 이벤트 명
	//btn2.addEventListener('click', go)
	btn2.addEventListener('click', function() {
		alert("btn2");
		go();
	});//익명함수라는게,,, 이렇게까지 오는 함수였다니,,!
	
	//btn.onclick = go()하면은 이벤트가 미리 실행
	//btn.onclick = go;//밖에서 할때는 이렇게
	btn.onclick = function(){
		alert("익명함수");
		go();//다른 함수 안에서 할때는 이렇게
	}
	
	
	function go(){
		alert("hello");
	}
	
		
	</script>
</body>
</html>