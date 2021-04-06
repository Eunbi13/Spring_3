/**
 * 
 */

$("#btn").click(function(){
	/*
	let writer=$("#writer").val() !="";
	let title=$("#title").val() !="" ;
	let contents=$("#contents").val().length !=0;
	*/
	
	let result = true;
	$(".mycheck").each(function(s, m){//하나꺼내서 s에 담는다. 일종의 배열임 클래스니까
		console.log(s);//인덱스 번호 찍힘
		console.log(m);//element옴
		console.log(this);//속성element
		console.log($(m).val());
		console.log($(this).val());
		
		if($(this).val()==""){
			result=false;
		}
	});
	
	if(result){
		alert("okok")
		$("#frm").submit();
	}else{
		alert("nono")
	}
});

