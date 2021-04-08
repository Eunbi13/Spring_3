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
		<c:if test="${board=='notice' }">
			<c:forEach items="${dto.noticeFiles }" var="file">
				<a href="../resources/upload/${board}/${file.fileName}">${file.origineName }</a>
			</c:forEach>
		</c:if>
		<c:if test="${board=='qna' }">
			<c:forEach items="${dto.qnaFiles }" var = "file">
				<a href="../resources/upload/${board }/${file.fileName}">${file.origineName  }</a>
			</c:forEach>
		</c:if>
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
<script type="text/javascript">
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