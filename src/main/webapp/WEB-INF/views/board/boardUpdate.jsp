<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<style type="text/css">
	#sample{
	display: none;}
</style>
<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>

	<h1>${board }Update page</h1>

	<div class="container">
		<h2>${board}Update form</h2>
		<form id="frm" action="./${board}Update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${param.num}">
			<div class="form-group">
				<label for="writer">Writer:</label> <input type="text"
					readonly="readonly" value="${dto.writer}" class="form-control"
					id="writer" name="writer">
			</div>
			<div class="form-group">
				<label for="title">Title:</label> <input type="text"
					class="form-control" id="title" name="title" value="${dto.title}">
			</div>

			<div class="form-group">
				<label for="contents">Contents:</label>
				<textarea class="form-control" rows="5" id="contents"
					name="contents">${dto.contents}</textarea>
			</div>
			<!-- 파일수정 -->
			<c:forEach items="${dto.boardFiles }" var="file">
				<div >
					<span>${file.origineName }</span> <span class="fileDelete" title="${file.fileNum }" >X</span>
				</div>
			</c:forEach>
			
			
			<input type="button" id="add" value="ADD" class="btn btn-danger float-right"> 
			<div id="files" title="${dto.boardFiles.size() }">
				<!-- add를 클릭하면 sample태그가 이 div 내부에 붙여넣기 되면 좋겠다.append쓰래 단, 최대 5개까지만 만들어지도록 -->

			</div>

			<input type="submit" id="btn" value="UPDATE" class="btn btn-primary">
		</form>
	</div>
	
	
	<div id="sample">
		<div class="input-group" >
			<div class="custom-file">
				<input type="file" class="custom-file-input" id="inputGroupFile04"
					aria-describedby="inputGroupFileAddon04" name="files"> <label
					class="custom-file-label" for="inputGroupFile04" >Choose
					file</label>
			</div>
			<div class="input-group-append delete"><!-- class명 추가 -->
				<input class="btn btn-outline-secondary" type="button"
					id="inputGroupFileAddon04" value="Delete">
			</div>
		</div>
	</div>
	
	
	<script type="text/javascript" src="../resources/jquery/fileAdd.js"></script>
	<script type="text/javascript" src="../resources/jquery/boardUpdate.js"></script>
</body>
</html>