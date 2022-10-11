function close_window() {
	close();
}


function quest_answer() {

	answer = document.getElementById('member_answer').value;
	
	if (answer != '') {
	document.getElementById('quest_form').submit();
	} else {
	alert('정답을 입력해주세요.');
	return false;
	}

}
	

// window.onload
// info.style.backgroundColor= '#00B4DB';