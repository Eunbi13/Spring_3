/**
 * 
 */

function memberJoin(){
	
	alert("memberJoin")
	
	let id = document.getElementById('id');
	let pw = document.getElementById('pw');
	let pw2 = document.getElementById('pw2');
	
	if(id.value==""){
		alert("아이디를 입력하세요")
	}
	
	if(pw.value != pw2.value){
		alert("비밀번호가 일치하지 않습니다.")
	}
	
	let exist = document.getElementsByClassName('exist');
	for(let has of exist){
		if(has.value==""){
			if(has.id=="email"){
				alert("이메일을 입력하세요")
			}
			if(has.id=="phone"){
				alert("번호을 입력하세요")
			}
			if(has.id=="name"){
				alert("이름을 입력하세요")
			}
			
		}
	}
}