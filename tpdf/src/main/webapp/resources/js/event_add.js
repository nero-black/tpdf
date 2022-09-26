
function event_add(){
	let result = confirm("정말로 해당 내용으로 이벤트를 추가하시겠습니까?");
	
	if(result == true) {
	
	/* ==================== */
	
	null_checker = 0;
	team_a = document.getElementById('team_a').value;
	team_b = document.getElementById('team_b').value;
	input_array = [team_a, team_b];
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
		return 0;
		/* window.history.back(); 뒤로가기 */
	}
}

// window.onload
// info.style.backgroundColor= '#00B4DB';