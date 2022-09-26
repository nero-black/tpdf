
function event_betting(){
	let result = confirm("정말로 베팅하시겠습니까?");
	
	if(result == true) {
	
	/* ==================== */
	
	null_checker = 0;
	member_idx = document.getElementById('member_idx').value; // member_idx는 세션값으로 가져옴. 추후 여기 또는 event.jsp text부분 수정
	betting_team = document.getElementById('betting_team').value;
	b_point = document.getElementById('b_point').value;
	event_idx = document.getElementById('event_idx').value;
	input_array = [member_idx, betting_team, b_point, event_idx];
	input_length = input_array.length;

	for (i=0; i<input_length; i++) {
	
		if (input_array[i] == "") {
			// console.log(i+'번째 값 null:'+input_array[i]);
			null_checker == 0;
		} else {
			// console.log(i+'번째 값 정상:'+input_array[i]);
			null_checker += 1;
		}
	}
	
	if (null_checker >= input_length) {
	document.getElementById('event_add_form').submit();
	} else {
	alert('입력하지 않은 내용이 있습니다.');
	return false;
	}
	
	/* ==================== */
	
	} else {
		return false;
		/* window.history.back(); 뒤로가기 */
	}
}

// window.onload
// info.style.backgroundColor= '#00B4DB';