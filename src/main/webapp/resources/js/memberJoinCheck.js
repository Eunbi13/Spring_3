/**
 * 전체동의 누르면 전부 체크되고 그 반대도 되고,,,
근데 내가 중간에 하나를 빼면 전체동의도 사라져야 하고
내가 전체동의를 클릭 안하더라도 나머지들을 전부 체크 한다면 전체동의도 체크되어야 함
 */


	
	const all = document.getElementById('all');
	let check = document.getElementsByClassName("check");
	
	
	all.addEventListener("click", function(){
		//alert("click")
		for(let ch of check){
			ch.checked = all.checked;
		}
		
	});

	
	
	for(let ch of check){
		ch.addEventListener("click", function(){
			
			let result = true;
			for(let c of check){
				if(!c.checked){
					result = false;
					break;
				}
			}
			all.checked = result;		
		});
		
	}
	
	
		/*for(let one of ones){
			one.checked = all.checked
		}
		*/
	/*let result = true;
		
	for(one of check){
		if(!one.checked){
			result = false;
			break;
		}
	}
*/
	
	

