/**
 * 
 */
$('#contents').summernote({
	 height: 500,
	 placeholder: 'write here...',
	 callbacks: {
		onImageUpload: function(files) {//files는 배열이고 이미지고 
		// upload image to server and create imgNode...
		//$summernote.summernote('insertNode', imgNode);
		 uploadFile(files);
		},//==onImageUpload end
		onMediaDelete: function(files){//이미지 코드가 배열로 넘어온다
			deleteFile(files);
		}
		
	
	}//==callbacks end
});

		
		

function uploadFile(files){//이미지 업로드 하면 호출
	
	//파일업로드할때 메서드가 post형식이여야 하고 enctype: multypart/...뭐지?
	const formData = new FormData();//form태긋 ㅐㅇ성성
	formData.append('file',files[0]);//input type="file" 태그 생성 했고 name이file임<<이거 insertr.jsp에서 배열이라고 적어둔 그거 ㅇㅇ이 파일을 아래의 ajax를 통해 보내는거임
	//비어있는 폼이 완성된거
	let fileName="";
	//이제 보내야지
	$.ajax({//비동기식,, 동기식은 요청보내면 응답 나올때까지 기다림 근데 얜 보내고 안기다리고 할 일함 그래서 결과가 오기전에 리턴할수도 잇음 
		type: "POST",
		url: "./summerFileUpload",
		data: formData,
		enctype: "multypart/form-data",
		cache: false,
		processData: false,
		contentType: false,
		success: function(result){
			//응답은 view가 온다.common/ajaxResult가 옴
			fileName=result.trim();
			$('#contents').summernote('insertImage', fileName);//url, filename 우리는 합쳐서 가져와서 ㄴ상관
		}
	});
	
	
};



function deleteFile(files){//뒤에서 첫번째 슬러쉬
	let fileName = $(files[0]).attr("src");
	let index = fileName.lastIndexOf("/");
	fileName=fileName.substring(index+1);
	$.post("summerFileDelete", {fileName: fileName}, function(result){
		console.result;
	});
};