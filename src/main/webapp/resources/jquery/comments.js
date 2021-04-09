/**
 * 
 */
let num = $('#comments').attr("title");
getList();


//$('#remove').click(function(){
	//왜 안되느냐,, 이벤트를 먼저 스크립트랑 이벤트를 거는데 얘는 나중에 더한거임 그니까 이벤트 걸고 난 뒤에 ++된거지
	// 그래서 클라이언트에서 안돼 
	//때문에 이벤트 위임을 해야하는 거임 이런,,, 얘는 comments div에 속한 친구임 
	//부모 커멘츠에서 위임할거임
	$('#comments').on("click", "#remove", function(){
		const ar = [];//비어있는 배열
		$('.del').each(function(i){
			let ch = $(this).prop("checked");
			if(ch){
				//ch인줄,,ㅎ 이거 블리언 타입인데,,!
				ar.push($(this).val());//여기서 갑자기 자바스크립트 배열 메서드가 나올줄이야,,!
			}
		});
		console.log(ar);
		//ar을 ajax로 보낼건데 자바스크립트에서 쓰는 객체타입임,, 보내는건 get이나 post로 보내는건데,,이 둘은 단순한거
		//복잡한건 ajax로
		$.ajax({
			type: "post",
			url: "../comments/commentsDelete",
			traditional: true,//배열 보내고 싶을 때
			data: {commentNum: ar, num: num},
			success: function(data){
				console.log(data);
				getList();
			}
		});
	});





function getList(){
	$.get("../comments/commentsList?num="+num, function(data){
		data = data.trim();
		console.log(data);
		$('#comments').html(data);
	});//요청할 url,콜백함수
};

$('#write').click(function(){
	let writer = $('#writer').val();
	let contents = $('#contents').val();
	
	$.post("../comments/commentsInsert", {writer: writer, contents: contents, num: num}, function(data){
		data = data.trim();
		if(data==1){
			alert("등록 성공");
			$('#writer').val('');
			$('#contents').val('');
			getList();
		}else{
			alert("등록 실패");
		}
		
	});
});

