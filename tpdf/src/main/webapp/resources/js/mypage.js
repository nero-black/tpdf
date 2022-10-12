function drop(){
	let result1 = confirm("더이상 이 계정을 이용할 수 없게됩니다.\n정말로 탈퇴하시겠습니까?");
	
	if (result1 == true) {
		let result2 = confirm("회원 탈퇴를 원하시면 [취소] 버튼을 눌러주세요.");
		
		if (result2 == true) { return false;}
			else { location.href="mypage_drop_process.do" }
	} else { return false; }
}

// window.onload
// info.style.backgroundColor= '#00B4DB';