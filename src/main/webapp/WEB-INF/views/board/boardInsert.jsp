<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
<!-- summernote -->
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>

<style type="text/css">
#sample {
	display: none;/*  자리도 없고 내용도 없어서 버튼도 안눌리고 걍 투명취급 */
}
</style>

<title>Insert title here</title>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
		<h1>Notice Insert Page</h1>
		<h1>v7</h1>
		<form id="frm" action="./${board }Insert" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="writer">writer</label> <input type="text"
					class="form-control mycheck" readonly="readonly" id="writer"
					value="${member.name}" name="writer">
			</div>

			<div class="form-group">
				<label for="title">Title</label> <input type="text"
					class="form-control exist mycheck" id="title" placeholder="Title"
					name="title">
			</div>
			<!-- 비어있음 x -->

			<div class="form-group">
				<label for="contents">Contents</label>
				<textarea class="form-control exist mycheck" id="contents" rows="3"
					name="contents"></textarea>
			</div>
			<!-- 비어잇음 x -->

			<input type="button" id="add" value="ADD" class="btn btn-danger float-right"> 
			<input type="button" id="del" value="DELETE" class="btn btn-primary float-right">
			
			<div id="files" title="0">
				<!-- add를 클릭하면 sample태그가 이 div 내부에 붙여넣기 되면 좋겠다.append쓰래 단, 최대 5개까지만 만들어지도록 -->

			</div>
			<input type="button" id="btn" value="write"
				class="btn btn-dark float-right">
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


	<script type="text/javascript" src="../resources/jquery/boardInsert.js"></script>
	<script type="text/javascript" src="../resources/jquery/fileAdd.js"></script>
	<script type="text/javascript" src="../resources/jquery/summerFile.js"></script>
	<script type="text/javascript">
		$('#contents').summernote({
			 height: 500,
			 placeholder: 'write here...',
			 callbacks: {
				onImageUpload: function(files) {//files는 배열이고 이미지고 
				// upload image to server and create imgNode...
				//$summernote.summernote('insertNode', imgNode);
				 uploadFile(files);
				}
			}
		});
		
		
		
	</script>
</body>
</html>