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

<h1>${board } select page </h1>

<div class="container">
	<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Title</th>
					<th>Contents</th>
					<th>Date</th>
					<th>Hit</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.title }</td>
					<td>${dto.contents }</td>
					<td>${dto.regDate }</td>
					<td>${dto.hit }</td>
				</tr>
			</tbody>
	</table>
	<div>
	
			<c:forEach items="${dto.boardFiles }" var="file">
				<a href="../resources/upload/${board}/${file.fileName}">${file.origineName }</a>
			</c:forEach>
	
		

	</div>
	
	<!-- 댓글 리스트 -->
	<div id="comments" title="${dto.num }"><!-- ajax에 넘길 데이터 태그에 넣기  -->
	
	</div>
	
	
	<!-- 댓글 폼 얘네가쓴 데이터를 ajax로 보내서 저장할거임 그리고 바로 출력한다구?-->
	<div>
		<div class="form-group">
			  <label for="writer">Name:</label>
			  <input type="text" class="form-control" id="writer" >
		</div>
		<div class="form-group">
 			 <label for="contents">Comment:</label>
 			 <textarea class="form-control" rows="5" id="contents" ></textarea>
		</div>
		
		<button type="button" class="btn btn-warning" id="write" title="${dto.num }">write</button>
	</div>
	
	
	
	<a href="./${board }Update?num=${dto.num}" class="btn btn-danger">Update</a>
	<a href="#" id="del" class="btn btn-info">Delete</a>
	<c:if test="${board ne 'notice' }"><!-- 답글 달 때는 부모글(현재 보는글)에 대해서 정보를 넘겨줘야함 -->
		<a href="./${board }Reply?num=${dto.num}" class="btn btn-dark">Reply</a>
	</c:if>
	
	<form  action="./${board }Delete" id="frm" >
		<input type="hidden" name="num" value="${dto.num}">
		
	</form>
	
	
	
	
</div>

<script type="text/javascript" src="../resources/jquery/comments.js"></script><!-- 위치 주의할것 -->

<script type="text/javascript" >
	const del = document.getElementById("del");
	const frm = document.getElementById("frm");
	
	del.addEventListener("click", function(){
		let result = window.confirm("Delete?")
		console.log(result);
		
		if(result){
		//	frm.setAttribute("method", "POST");
			frm.method="POST";
			frm.submit();
		//	location.href="./${board }Delete?num=${dto.num}";
		}
	});
</script>
</body>
</html>