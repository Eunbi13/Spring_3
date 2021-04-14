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

	<button class="b" id="btn1">Button</button>
	<button id="btn" class="b">Click</button>
	<button id="btn2" class="b">Click</button>
	<input type="text" id="num">
	<h1 id="t">version 2</h1>
	<button id="btn3">here</button>
	<input type="text" id="exchange">
	<div>
		<h3 id="krw"></h3>
		<h3 id="usd"></h3>
	</div>
	
	<ol id="result">
		<li>A</li>
	</ol>
	
	<select id="mon"><!-- 1월부터 12월까지 다 들어가면 좋겠다,,? 12번을,,해라,,, -->
		
	</select>
	
	<div id="d1">
		<h3 id="d3"></h3>
		<h3 id="d4"></h3>
		<div id="d2">
			<!-- title, contents 뿌리기  -->
		</div>
	</div>
	
	<div id="map" style="width:500px;height:400px;"></div>
	
	
	
	
	
	<script type="text/javascript">
	
	getMap(33.450701, 126.570667);
	
	function getMap(lat, lng){
		
		var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
		var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(lat, lng), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
			};
		var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	}
	

	//json실습
	$('#btn2').click(function(){
		let num = $("#num").val();
		console.log(num);
		$.get("https://jsonplaceholder.typicode.com/posts/"+num, function(data){
			alert(data);//Object object
			console.log(data);//내용물 뜸 
			
			$("#d3").text(data.title);
			$("#d4").html(data.body);
			
			
			//data = JSON.parse(data);이미 json이다.parse필요 없다.
			//alert(data.title);
		});
		
	});
	
	$("#btn3").click(function(){
		let money=$("#exchange").val();
		$.ajax({
			type:"GET",
			url:"https://api.manana.kr/exchange/price.json",
			data:{
				base:"KRW",
				price: money,
				code:"KRW,USD,JPY"
			},
			success: function(data){
				console.log(data)
				$("#krw").html(data.KRW);
				$("#usd").html(data.USD)
			}
		})
				
	});
	
	$("#btn1").click(function(){
		$.get("https://jsonplaceholder.typicode.com/users", function(data){
			console.log(data)
			for(index of data){
				console.log(index.company);
				console.log(index.company.name)
			}
			
			console.log(data[0].address.geo.lat)
			console.log(data[0].address.geo.lng)
			let t = parseFloat(data[0].address.geo.lat)
			let n = parseFloat(data[0].address.geo.lng)
			getMap(33.333333, 126.555555);
		})
		
		//첫번째 유저의 geo중 lat, lng속성이 있음 
		
	});
	
	
	
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