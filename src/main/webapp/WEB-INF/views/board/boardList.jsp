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

<div class="container">
		<h1>${board } List Page</h1>

		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>Num</th>
					<th>Title</th>
					<th>Name</th>
					<th>Date</th>
					<th>Hit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.num }</td>
						<td><a href="./${board }Select?num=${dto.num }">
						<!-- depth begin에는 0넣으면 안됨 왜냐하면 end가 포함이라서 begin < x <= end 로 만들어짐-->
							<c:catch>
								<c:forEach begin="1" end="${dto.depth }">--</c:forEach>
							</c:catch>
							${dto.title}
						</a></td>
						<td>${dto.writer}</td>
						<td>${dto.regDate}</td>
						<td>${dto.hit }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<c:if test="${not empty member.id }">
			<a href="./${board }Insert" class="btn btn-dark float-right" >Write</a>
		</c:if>
	</div>

	<div class="container">
		<ul class="pagination">

			<c:if test="${pager.pre }">
				<li class="page-item"><a class="page-link p"
					href="#" title="${pager.startNum-1 }">Previous</a></li>
			</c:if>
			<c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
				<li class="page-item "><a class="page-link p"
					href="#" title="${i }">${i}</a></li>
			</c:forEach>

			<c:if test="${pager.next }">
				<li class="page-item"><a class="page-link p"
					href="#" title="${pager.lastNum+1}">Next</a></li>
			</c:if>
		</ul>
	</div>
<!--------------------------------------- search ----------------------------------------------------->
	<div class="container">

		<div class="input-group mt-3 mb-3">
			<form action="./${board }List" class="form-inline" id="frm">
			
			<input type="hidden" name="curPage" value="1" id="curPage"> <!-- 아닛? 여기서 보내네 -->
			
				<div class="input-group-prepend">
					<select class="form-control"  name="kind" id="kind" > <!-- 벨류값이 없음 셀렉트는 선택한 애에게 벨류가 있음-->
						<option class="sel">Title</option>
						<option class="sel">Contents</option>
						<option class="sel">Writer</option>
					</select>
				</div>
				<input type="text" class="form-control" placeholder="Search" name="search" id="search" value="${pager.search }"> 
				<div class="input-group-append">
					<button class="btn btn-success" type="submit">Search</button>
				</div>
			</form>
		</div>

	</div>
	<!-- ㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜ퓨ㅠㅜ퓨ㅜ푸ㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠㅜㅠ -->
	
	<script type="text/javascript">
	$('.sel').each(function(){
		let kind = '${pager.kind}';//이거 왜 안적음 멍청아!
		let t = $(this).text();   //kind값을 받음 첫번째로 Title 뜸, Contents, Writer 뜸 
		if(t == kind){			//t에 있는것이 kind와 같냐
			$(this).prop("selected", true);//selected가 true속성이면 <option selected>이케 됨
		}
	})
	$(".p").click(function(){
		let curPage = $(this).attr("title");
		 $("#curPage").val(curPage);//폼태그의 벨류에 넣어둔거임 
		 //====파라미터로 넘길 curPage을 찾는 과정====
		$("#frm").submit(); 
		//이게 그 검색어랑 옵션 선택한게 남아있도록 하려는 건데 그건 form태그에서 value로 pager.kind, pager.search로 받아서 ㅇㅋㅇㅋ
		
		
		
		/*
		let kind = '${pager.kind}';
		let search= '${pager.search}'; 
		$('#curPage').val(curPage);
		$('#kind').val(kind);
		$('#search').val(search);
		$("#frm").submit(); //전송해버리겠다. 
		*/
	
		/* 
		$(this).attr("curPage", curPage)
		$(this).attr("kind", '${pager.kind}')
		$(this).attr("search", '${pager.search}')
		location.href="./${board}List" 
		 */
	});
	</script>
</body>
</html>