/**
 * 
 */

function insertCheck(){
	
	alert("insertCheck");//여기까지 ㅇㅋ
	
	//방법1
	let t1 = document.getElementById('title')
	let con1 = document.getElementById('contents')//쌍따옴표쓰니까 지독하게 안되더니 홑따옴표쓰니까 됨;; 도라이 아니냐 이거 진짜 
	
	console.log("here")
	
	if(t1.value.length==0){
		alert("제목을 입력하세요")
	}
	if(con1.value==""){
		alert("내용을 입력하세요")
	}
	
	
	//방법2
	let exist = document.getElementsByClassName("exist");//아니 근데 얜 쌍따옴표 되잖아;; 진짜 도라이네
	for(let has of exist){
		console.log(has.value)
		if(has.value==""){
			alert("내용을 입력하세요");
			break;
		}
	}
	
	
	
	//return false;
}