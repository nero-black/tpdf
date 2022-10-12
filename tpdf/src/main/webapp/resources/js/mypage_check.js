
function mypage_submit(){
		
	member_pw = document.getElementById('member_pw').value;
	
	if (member_pw != '') {
	document.getElementById('mypage_form').submit();
	} else {
	alert('비밀번호를 입력해야 합니다.');
	return false;
	}
}

// window.onload
// info.style.backgroundColor= '#00B4DB';