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
	
	
	<ol id="result">
		<li>A</li>
	</ol>
	
	<select id="mon"><!-- 1월부터 12월까지 다 들어가면 좋겠다,,? 12번을,,해라,,, -->
		
	</select>
	
	
	<script type="text/javascript">
		$("#btn").click(function(){//이거 걍 안쓰고 반복문만 쓰면 페이지 열리자 마자 자바스크립트 활동함 ㅇㅇ
			for(let i=1; i<13; i++){
			$("#mon").append("<option>"+i+"</option>");
			}
		});
	
	
	
		$("#btn2").click(function(){
			
			$("#result").prepend('<option>월</option>')
			
		})
	/* 
		$(".b").click(function(){
			alert($("#t").text());
		}); */
		
	</script>
</body>
</html>