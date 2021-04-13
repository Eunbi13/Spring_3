<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<c:import url="./template/bootStrap.jsp"></c:import>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c51ee4c7970b637c5011566ac517d44d"></script>
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
	
	<div id="map" style="width:500px;height:400px;"></div>
	
	
	
	
	
	<script type="text/javascript">
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};

	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	<!-- 0409 -->
		/* $("#btn2").click(function(){
			//jquery의 ajax문법
			$.get("./test?num=3", function(data){//여기 데이타로 응답이 온다
				$("#d2").html(data);
				console.log(data);
			});
		}); */
		
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