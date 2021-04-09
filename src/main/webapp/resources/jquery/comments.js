/**
 * 
 */
let num = $('#comments').attr("title");
$.get("../comments/commentsList?num="+num, function(data){
	data = data.trim();
	console.log(data);
	$('#comments').html(data);
});//요청할 url,콜백함수

$('#write').click(function(){
	let writer = $('#writer').val();
	let contents = $('#contents').val();
	console.log(writer)
	alert(writer);
	alert(contents);
	$.post("../comments/commentsInsert", {writer: writer, contents: contents}, function(data){
		alert(data);
	});
});