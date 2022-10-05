
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



function event_stop(){
	let result = confirm("정말로 이벤트 베팅을 종료하시겠습니까?");
	
	if(result == true) {
		location.href='event_stop.do';
	} else {
		return 0;
	}
}



function event_end_set(){
	let result = confirm('정말로 해당 항목에 포인트를 지급하시겠습니까?');
	
	if(result == true) {
	
	victory_team = document.getElementById('victory_team').value;
	
		if (victory_team != null) {
		document.getElementById('event_add_form').submit();
		} else {
		alert('반드시 하나의 항목을 선택해야 합니다.');
		return false;
		}	
	}
}

// window.onload
// info.style.backgroundColor= '#00B4DB';