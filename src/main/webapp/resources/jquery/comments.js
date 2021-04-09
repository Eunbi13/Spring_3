/**
 * 
 */
let num = $('#comments').attr("title");
$.get("../comments/commentsList?num="+num, function(data){
	console.log(data);
});//요청할 url,콜백함수