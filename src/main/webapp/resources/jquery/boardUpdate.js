/**
 * 
 */

/*이건 필요없네 ㅎcount = $('#files').attr('title');*/
$('.fileDelete').click(function(){
	
	let check=confirm("삭제?");
	if(check){
		let fileNum = $(this).attr("title");
		let obj=$(this);
		//noticeFileDelete
		$.ajax({
			type:"GET",
			url:"./fileDelete",
			data:{fileNum: fileNum},
			success:function(result){
				result=result.trim();
				if(result>0){
					alert("삭제성공");
					$(obj).parent().remove();
					count--;
				}else{
					alert("삭제실패");
				}
			}
		});
	}
});