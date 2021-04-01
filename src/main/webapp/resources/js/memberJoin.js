/**
 * 
 */
	let id = document.getElementById('id');
	let pw = document.getElementById('pw');
	let pw2 = document.getElementById('pw2');

	id.addEventListener('focus', function(){
		console.log("hi")
	});
	
	id.addEventListener("blur", function(){

		let message = "6글자 미만입니다.";
		let css = "r1";
		console.log(id.value.length);
		if(id.value.length>5){
			message="6글자 이상입니다."
			css = "r2";
		};
		let idResult = document.getElementById("idResult");
		idResult.innerHTML=message;
		idResult.setAttribute("class", css);
	});

function memberJoin(){
	
	alert("memberJoin")
	
	
	if(id.value.length<6){
		alert("6글자 미만입니다.");
	}
	if(pw.value.length<8){
		alert("8글자 미만입니다.");
	}
	if(pw.value != pw2.value){
		alert("비밀번호가 일치하지 않습니다.");
	}
	
	let exist = document.getElementsByClassName('exist');
	for(let has of exist){
		if(has.value==""){
			if(has.id=="email"){
				alert("이메일을 입력하세요");
			}
			if(has.id=="phone"){
				alert("번호을 입력하세요");
			}
			if(has.id=="name"){
				alert("이름을 입력하세요");
			}
			
		}
	}
}