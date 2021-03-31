/**
 * 전체동의 누르면 전부 체크되고 그 반대도 되고,,,
근데 내가 중간에 하나를 빼면 전체동의도 사라져야 하고
내가 전체동의를 클릭 안하더라도 나머지들을 전부 체크 한다면 전체동의도 체크되어야 함
 */


function check(){
	alert("check");
	
	let all = document.getElementById("all");
	let ones = document.getElementsByClassName("one");
	
	console.log(all.checked);
	
		/*for(let one of ones){
			one.checked = all.checked
		}
		*/
		for(let one of ones){
			all.checked=one.checked;

			if(!one.checked){
				break;
			}
		}

	
	
	
}
