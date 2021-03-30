/**
 * 
 */

 function go(){
 	//alert("Button Click");
 	console.log("print log");
 	//30 리터럴
 	//변수 선언: 데이터 타입 변수명;
 	var num=30;
 	console.log(num);
 	//문자열 iu, 문자 타입 없음 데이터베이스와 유사, 앞뒤로 '' or ""
 	var name="iu";
 	console.log(name);
 	num=name;
 	console.log(num);
 	
 	var num=1;
 	console.log(num);
 	
 	
 	const n1='choa'; //const는 상수
 	console.log(n1);
// 	n1='iu';
 //	console.log(n1);
 	
 	let n2 = "aaaa";
 	console.log(n2);
 	n2="bb";
 	console.log(n2);
 }
 
 
 function go2(){
 	console.log("go2확인");
 	var c1 =window.document.getElementById("c1");//jsp에서 아이디가 c1인거 가져와서 var c1에 담는다. 
 	alert(c1);		//[object HTMLDivElement]
 	console.log(c1);
 	
 	var c2 = c1.innerHTML;
 	//html 내부의 요소를 전부 가져오고 싶을 떄(엘리먼트까지)<h1 id="t1">Welcome Home Page</h1>
 	
 	console.log(c2);
 	window.alert(c2);
 	
 	var c3 = c1.innerText; //변수, 내부의 텍스트만 가져오겟다. Welcome Home Page
 	console.log(c3);
 	
 	var name=window.prompt("이름입력");
 	console.log(name);
	c1.innerText = name;
	c1.innerHTML = '<input type="text">';
	
 	
 }