/**
 * 
 */

	
	
	let frm = document.getElementById('frm');
	let writer = document.getElementById('writer');
	let title = document.getElementById('title');
	let btn = document.getElementById('btn');
	let contents = document.getElementById('contents');//쌍따옴표쓰니까 지독하게 안되더니 홑따옴표쓰니까 됨;; 도라이 아니냐 이거 진짜 
	//btn을 클릭하면 실행되는 이벤트들
	

	btn.addEventListener("click", function(){
		
		let check1 = writer.value != "";//true or false
		let check2 = title.value !="";//true or false
		console.log("here")
		console.log(check1)
		console.log(check2)
		if(check1 && check2){
			frm.submit();
		}else{
			alert("입력 항목을 확인 하세요")
		}
	
		if(contents.value==""){
			alert("내용을 입력하세요")
		}
	
	});
	/*
	//방법2
	let exist = document.getElementsByClassName("exist");//아니 근데 얜 쌍따옴표 되잖아;; 진짜 도라이네
	for(let has of exist){
		console.log(has.value)
		if(has.value==""){
			alert("내용을 입력하세요");
			break;
		}
	}*/
	
	
	