/**
 * 
 */

let count = $('#files').attr("title");//전역변수
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
	
			
		