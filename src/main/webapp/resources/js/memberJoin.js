	/**
 * 
 */
	let id = document.getElementById('id');
	let pw = document.getElementById('pw');
	let pw2 = document.getElementById('pw2');
	let btn = document.getElementById('btn');
	let exist = document.getElementsByClassName('exist');//phone, name, email 클래스로 묶은 거 
	let idCheck = false;
	let pwCheck  = false;
	let pw2Check  = false;
	let existCheck = true;//공백 아닌것을 디폴트로 봄
	let message="";
	let css="";
	

//******************** */id check********************************************** */

	id.addEventListener("blur", function(){
		

		message = "6글자 미만입니다.";
		css = "r1";
		console.log(id.value.length);
		if(id.value.length>5){
			message="6글자 이상입니다."
			css = "r2";
			idCheck=true;//6글자 이상이면 트루
		}else{
			idCheck=false;
		}
		
		let idResult = document.getElementById("idResult");
		idResult.innerHTML=message;
		idResult.setAttribute("class", css);
	});
	//**************************pw******************************************** */

	pw.addEventListener('blur', function(){
		message="8글자 미만입니다.";
		css = "r1";
		if(pw.value.length>7){
			message="8글자 이상입니다.";
			css="r2";
			pwCheck=true;//7글자 넘으면 트루
		}else{
			idCheck=false;
		}
		     
		let pwResult = document.getElementById("pwResult");
		pwResult.innerHTML=message;
		pwResult.setAttribute("class", css);
	});
	
	pw.addEventListener("change", function(){
		pw2.value="";
	});
//**********************pw2************************************************ */	
	
	pw2.addEventListener('blur', function(){//이 함수는 여길 안건들면 아예 실행이 안됨 그래서 내가 아까 아예 터치를 안해서 넘어간거임;;
		message="일치합니다.";
		css="r2";
		if(pw.value != pw2.value){
			message="일치하지 않습니다.";
			css="r1";
		}else{
			pw2Check=true;
		}
		let pw2Result = document.getElementById("pw2Result");
		pw2Result.innerHTML=message;
		pw2Result.setAttribute("class", css);
	});

//*****************************//btn이 클릭되면 실행되는 함수들 위의 함수들이 실행되고 실행되는 거니까 ㅇㅇ***************************************** */
	btn.addEventListener("click", function(){

		for(let has of exist){
			if(has.value==""){
				existCheck=false;
				break;
				//공백이면 false넣어져서 submit X
			}
		}
		console.log(idCheck);
		console.log(pwCheck);
		console.log(pw2Check);
		console.log(existCheck);
		
	//조건이 만족한다면 form 태그에 sumit이 들어잇으니까,,,, 실행시키고 싶다.
		if(idCheck&&pwCheck&&pw2Check&&existCheck){
			alert("pass")
			//frm.submit();
		}else{
			alert("nonop")
			
		}
	});

//===============ID 중복 확인=========================

	$('#id').blur(function(){
		let id = $('#id').val();
		$.get("./memberIdCheck?id="+id, function(result){//여기도 매개변수라서 선언된거 
			//요청이 발생하면 결과물(ajaxResult.jsp)은 result로 응답함
			result = result.trim();//ajax를 다룰때 공백이 올수도잇음 그래서 trim으로 공백 제거함
			//0오면 불가능 1오면 가능
			let str="사용가능한 ID입니다.";
			if(result=='0'){
				str="사용 불가능한 ID입니다.";
			}
			
			$('#idCheckResult').html(str);
		});
	});
