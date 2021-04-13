/**
 * 
 */

function uploadFile(files){//이미지 업로드 하면 호출
	
	//파일업로드할때 메서드가 post형식이여야 하고 enctype: multypart/...뭐지?
	const formData = new FormData();//form태긋 ㅐㅇ성성
	formData.append('file',files[0]);//input type="file" 태그 생성 했고 name이file임<<이거 insertr.jsp에서 배열이라고 적어둔 그거 ㅇㅇ이 파일을 아래의 ajax를 통해 보내는거임
	//비어있는 폼이 완성된거
	//이제 보내야지
	$.ajax({
		type: "POST",
		url: "./summerFileUpload",
		data: formData,
		enctype: "multypart/form-data",
		cache: false,
		processData: false,
		contentType: false,
		success: function(result){
			//응답은 view가 온다.
			console.log(result);
		}
	});
	
	
}