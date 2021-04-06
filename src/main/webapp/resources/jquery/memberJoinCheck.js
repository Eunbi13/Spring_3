	/**
 * 
 */
$("#all").click(function(){
	
	let check=$("#all").prop("checked");
	console.log(check)
	
	$(".check").prop("checked", check);
	//개별적으로 할땐 반복문 돌리지만 이렇게 한번에 할땐 반복문 안씀
});

$(".check").click(function(){

	let result=true;
	
	$(".check").each(function(){
		if(! $(this).prop("checked")){
			result=false;
		}
	});
	
	$("#all").prop("checked", result);
	
});

$("#btn").click(function(){
		let result = $("#all").prop("checked");
	if(result){
		location.href="./memberJoin";
	}else{
		alert("약관에 동의 해주세요")
	}
});