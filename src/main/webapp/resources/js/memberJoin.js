/**
 * 
 */
	let id = document.getElementById('id');
	let pw = document.getElementById('pw');
	let pw2 = document.getElementById('pw2');
	let btn = document.getElementById('btn');
	let exist = document.getElementsByClassName('exist');//phone, name, email 클래스로 묶은 거 
	let message="";
	let css="";
	
	
	btn.addEventListener("click", function(){//btn이 클릭되면 실행되는 함수들
	
	
		let frm = document.getElementById("frm");
		let check = id.value.length>5//true
		let check2 = pw.value.length>7//true
		let check3= true;
		for(let has of exist){
			 check3 = true;//공백아이면 true
			if(has.value==""){
				//공백일 경우에 
				check3=false;
				break;
				//공백이면 false넣어져서 submit X
			}
		}
		console.log(check);
		console.log(check2);
		console.log(check3);
		
	//조건이 만족한다면 form 태그에 sumit이 들어잇으니까,,,, 실행시키고 싶다.
		if(check&&check2&&check3){
			frm.submit();
		}else{
			alert("nonop")
		}
	});

	id.addEventListener('focus', function(){
		console.log("hi")
	});
	
	id.addEventListener("blur", function(){

		message = "6글자 미만입니다.";
		css = "r1";
		console.log(id.value.length);
		if(id.value.length>5){
			message="6글자 이상입니다."
			css = "r2";
		};
		let idResult = document.getElementById("idResult");
		idResult.innerHTML=message;
		idResult.setAttribute("class", css);
	});
	
	pw.addEventListener('focus', function(){
		console.log('pwhi');
	});
	
	pw.addEventListener("change", function(){
		pw2.value="";
	});
	
	pw.addEventListener('blur', function(){
		message="8글자 미만입니다.";
		css = "r1";
		if(pw.value.length>7){
			message="8글자 이상입니다.";
			css="r2";
		}
		let pwResult = document.getElementById("pwResult");
		pwResult.innerHTML=message;
		pwResult.setAttribute("class", css);
	});
	
	
	pw2.addEventListener('blur', function(){
		message="일치합니다.";
		css="r2";
		if(pw.value != pw2.value){
			pw2.value="";
			message="일치하지 않습니다.";
			css="r1";
		}
		let pw2Result = document.getElementById("pw2Result");
		pw2Result.innerHTML=message;
		pw2Result.setAttribute("class", css);
	});


		

