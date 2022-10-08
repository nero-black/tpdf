id_check = 0;
name_check = 0;

$(function(){ // 입력 방지 (한글, 영어 대문자, 특수문자('_'제외), 공백)
	$( '#member_id' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|A-Z]/g, '' ) );
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?.,;:|\)*~`!^\-+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) ); // ('_'는 제외하였다.)
		$(this).val( $(this).val().replace( ' ', '' ) );
	});
})

$(function(){ // 닉네임 입력 방지 (한글 조합없는 자모음, 영어, 숫자, 특수문자, 공백)
	$( '#member_name' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ]/g, '' ) );	
		$(this).val( $(this).val().replace( /[a-z|A-Z|0-9]/g, '' ) );
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) );
		$(this).val( $(this).val().replace( ' ', '' ) );
	});
})

$(function(){ // 전화번호 입력 방지 (한글, 영어, 특수문자, 공백)
	$( '#member_tel1' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) );
		$(this).val( $(this).val().replace( /[a-z|A-Z]/g, '' ) );
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) );
		$(this).val( $(this).val().replace( ' ', '' ) );
	});
})

function id_checker() {
	member_id = document.getElementById('member_id').value;
	
	if (member_id == '') {
		alert('아이디를 입력해주세요.');
		return false;
	}
	
	request = 'id_check.do?member_id=' + member_id;
			  
	window.open(request, "ID 중복 확인", "width=500px, height=200px, resizeable=no, scrollbars=no");
	
}

$(function(){ // 아이디 중복 체크 후 내용 변경시 무효처리
	$('#member_id').on("change keyup", function() {
	if (id_check == 1) { id_check = 0; }
	});
})

function name_checker() {
	member_name = document.getElementById('member_name').value;
	
	if (member_name == '') {
		alert('닉네임을 입력해주세요.');
		return false;
	}

	request = 'name_check.do?member_name=' + member_name;

	window.open(request, "ID 중복 확인", "width=500px, height=200px, resizeable=no, scrollbars=no");
}

$(function(){ // 닉네임 중복 체크 후 내용 변경시 무효처리
	$('#member_name').on("change keyup", function() {
	if (name_check == 1) { name_check = 0; }
	});
})

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
		
		if (id_check == 0 && name_check == 1) {
		alert('아이디 중복 여부를 확인해주세요.');
		return false;
		}
		
		if (name_check == 0 && id_check == 1) {
		alert('닉네임 중복 여부를 확인해주세요.');
		return false;
		}
		
		if (name_check == 0 && id_check == 0) {
		alert('아이디와 닉네임 중복 여부를 확인해주세요.');
		return false;
		}
	
	
		member_quest = document.getElementById('member_quest').value;
		member_answer = document.getElementById('member_answer').value;
		member_email = document.getElementById('member_email').value;
		member_tel = document.getElementById('member_tel1').value;
		member_birth = document.getElementById('member_birth1').value;
		member_addr1 = document.getElementById('member_addr1').value;
		member_addr2 = document.getElementById('member_addr2').value;
		member_addr = member_addr1 + " " + member_addr2;
		
		if (member_quest != "" && member_answer == "") {
		alert('비밀번호 찾기 질문을 설정하려면 답변도 작성해야 합니다.');
		return false;
		}
		
		if (member_quest == "" && member_answer != "") {
		alert('비밀번호 찾기 답변을 설정하려면 질문도 작성해야 합니다.');
		return false;
		}
		
		if (member_quest == "" && member_answer == "") {member_quest = '설정된 질문이 없습니다. 사이트 관리자에게 문의해주세요.'; member_answer= '-';}
		if (member_email == "") {member_email = '-';}
		if (member_tel == "") {member_tel = '-';}
		if (member_birth == "") {member_birth = '-';}
		if (member_addr == " ") {member_addr = '-';}
		
		document.getElementById("member_quest").value = member_quest;
		document.getElementById("member_answer").value = member_answer;
		document.getElementById("member_email").value = member_email;
		document.getElementById("member_tel").value = member_tel;
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