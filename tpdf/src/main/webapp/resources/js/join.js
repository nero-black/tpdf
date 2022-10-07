function id_check() {
	member_id = document.getElementById('member_id').value;
	request = 'id_check.do?id_check=' + member_id
	window.open(request, "ID 중복 확인", "width=500px, height=200px, resizeable=no, scrollbars=no");
	document.getElementById('id_check_form').submit();
}

function join(){
	let result = confirm("입력하신 내용으로 회원가입을 하시겠습니까?");
	
	if(result == true) {
	
	/* ==================== */
	
	null_checker = 0;
	member_id = document.getElementById('member_id').value;
	member_pw = document.getElementById('member_pw').value;
	member_name = document.getElementById('member_name').value;

	input_array = [member_id, member_pw, member_name];
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
	
		member_pw = document.getElementById('member_pw').value;
		member_pwc = document.getElementById('member_pwc').value;
		if (member_pw != member_pwc) {
			alert('비밀번호가 일치하지 않습니다.');
			pwc1.style.display= 'inline-block';
			pwc2.style.display= 'inline-block';
			return false;
		}
		if (member_pw == member_pwc) {
			pwc1.style.display= 'none';
			pwc2.style.display= 'none';
		}
	
	
		member_email = document.getElementById('member_email').value;
		member_tel = document.getElementById('member_tel1').value;
		member_birth = document.getElementById('member_birth1').value;
		member_addr1 = document.getElementById('member_addr1').value;
		member_addr2 = document.getElementById('member_addr2').value;
		member_addr = member_addr1 + " " + member_addr2;
		
		if (member_email == "") {member_email = '-';}
		if (member_tel == "") {member_tel = '-';}
		if (member_birth == "") {member_birth = '-';}
		if (member_addr == " ") {member_addr = '-';}
		
		document.getElementById("member_email").value = member_email;
		document.getElementById("member_tel").value = member_tel;
		document.getElementById("member_birth").value = member_birth;
		document.getElementById("member_addr").value = member_addr;
		
		return false;
		
		document.getElementById('join_form').submit();
		
	} else {
	alert('아이디, 비밀번호, 닉네임은 반드시 입력해야 합니다.');
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