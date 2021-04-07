<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../template/bootStrap.jsp"></c:import>
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
		<form id="frm" action="./${board }Insert" method="post">
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

			<input type="button" id="add" value="ADD"
				class="btn btn-danger float-right"> <input type="button"
				id="del" value="DELETE" class="btn btn-primary float-right">
			<div id="files">
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
					aria-describedby="inputGroupFileAddon04"> <label
					class="custom-file-label" for="inputGroupFile04">Choose
					file</label>
			</div>
			<div class="input-group-append delete"><!-- class명 추가 -->
				<input class="btn btn-outline-secondary" type="button"
					id="inputGroupFileAddon04" value="Delete">
			</div>
		</div>
	</div>

	<script type="text/javascript">
		let count = 0;//전역변수
		$("#add").click(function() {
			let contents = $("#sample").html();

			if (count < 5) {
				$("#files").append(contents);
				count++;
			} else {
				alert("최대 5개까지 가능합니다.")
			}

		});//#add

		$('#del').click(function() {
			//$("#files").remove();//files태그도 사라져버림
			$("#files").empty();
		});//#del
		
		$("#files").on("click",".delete", function(){
			$(this).parent().remove();
			//this = .delete의 부모의 부모를 삭제 이래야 내가 선택한 태그가 삭제되는 것
			count--;
		});//#files 이벤트 위임
	
			//이벤트를 먼저 걸면서 페이지가 로드 되는데! 얘가 잇는 거의 display:none이라서 없는 취급당함 때문에 이 아이디에는 이벤트가 안걸리는 것
			//이미 이벤트 거는게 끝나서 실행이 안된다...그래서 이벤트 위임을 할거임!메모 참조
	
			
		
		
	</script>

	<script type="text/javascript" src="../resources/jquery/boardInsert.js"></script>

</body>
</html>