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

	<style type="text/css">
	#d1{
		width: 200px;
		height: 200px;
		background-color: salmon;
		overflow: hidden;
	}
	
	#d2{
		width: 50px;
		height: 50px;
		background-color: yellow;
		margin: 75px auto;
	}
	</style>

<title>Home!</title>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>

	<button class="b">Button</button>
	<button id="btn" class="b">Click</button>
	<button id="btn2" class="b">Click</button>
	<h1 id="t">version 2</h1>
	
	
	<ol id="result">
		<li>A</li>
	</ol>
	
	<select id="mon"><!-- 1월부터 12월까지 다 들어가면 좋겠다,,? 12번을,,해라,,, -->
		
	</select>
	
	<div id="d1">
		<div id="d2">
			
		</div>
	</div>
	
	<!-- 0409 -->
	<script type="text/javascript">
		$("#btn2").click(function(){
			//jquery의 ajax문법
			$.get("./test?num=3", function(data){//여기 데이타로 응답이 온다
				$("#d2").html(data);
				console.log(data);
			});
		});
		
	</script>
	
	<!-- <script type="text/javascript">
		$("#btn").click(function(){//이거 걍 안쓰고 반복문만 쓰면 페이지 열리자 마자 자바스크립트 활동함 ㅇㅇ
			for(let i=1; i<13; i++){
			$("#mon").append("<option>"+i+"</option>");
			}
		});
	
	
	
		$("#btn2").click(function(){
			
			$("#result").prepend('<option>월</option>')
			
		})
		
		
		$("#d1").click(function(){
			console.log("parent");
		});//#d1
		
		$("#d2").click(function(){
			console.log("child");
		});//#d2
		
	/* 
		$(".b").click(function(){
			alert($("#t").text());
		}); */
		
	</script> -->
</body>
</html>