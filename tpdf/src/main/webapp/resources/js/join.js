
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
	
		member_email = document.getElementById('member_email').value;
		member_tel = document.getElementById('member_tel').value;
		member_gender = document.getElementById('member_gender').value;
		member_birth = document.getElementById('member_birth').value;
		member_addr1 = document.getElementById('member_addr1').value;
		member_addr2 = document.getElementById('member_addr2').value;
		
		if (member_email == null) {member_email = '-';}
		if (member_tel == null) {member_tel = '-';}
		if (member_gender == null) {member_gender = '-';}
		if (member_birth == null) {member_birth = '-';}
		if (member_addr1 == null && member_addr2 == null) {member_addr = '-';}
		else {member_addr = member_addr1 + " " + member_addr2;}
		
		document.getElementById("member_email").value = member_email;
		document.getElementById("member_tel").value = member_tel;
		document.getElementById("member_gender").value = member_gender;
		document.getElementById("member_birth").value = member_birth;
		document.getElementById("member_addr").value = member_addr;
		
		
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