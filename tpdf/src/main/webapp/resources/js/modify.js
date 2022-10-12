$(function(){ // 메일 입력 방지 (한글, 특수문자(_, @, . 제외), 공백)
	$( '#member_email' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) );
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?,;:|\)*~`!^\-+┼<>\#$%&\'\"\\\(\=]/gi, '' ) );
		$(this).val( $(this).val().replace( ' ', '' ) );
	});
})

$(function(){ // 전화번호 입력 방지 (한글, 영어, 특수문자, 공백)
	$( '#member_tel' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) );
		$(this).val( $(this).val().replace( /[a-z|A-Z]/g, '' ) );
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) );
		$(this).val( $(this).val().replace( ' ', '' ) );
	});
})

$(function(){ // 주소 입력 방지 (특수문자, 공백)
	$( '#member_addr' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) );
		$(this).val( $(this).val().replace( ' ', '' ) );
	});
})

function modify(){
	let result = confirm("입력하신 내용대로 정보를 수정 하시겠습니까?");
	
	if(result == true) {
	
	/* ==================== */
	
	null_checker = 0;
	member_pw = document.getElementById('member_pw').value;
	member_email = document.getElementById('member_email').value;
	member_tel = document.getElementById('member_tel').value;
	member_addr = document.getElementById('member_addr').value;

	input_array = [member_pw, member_email, member_tel, member_addr];
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
		
		member_quest = document.getElementById('member_quest').value;
		member_answer = document.getElementById('member_answer').value;
		member_email = document.getElementById('member_email').value;
		member_tel = document.getElementById('member_tel').value;
		
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
		if (member_addr == " ") {member_addr = '-';}
		
		document.getElementById("member_quest").value = member_quest;
		document.getElementById("member_answer").value = member_answer;
		document.getElementById("member_email").value = member_email;
		document.getElementById("member_tel").value = member_tel;
		document.getElementById("member_addr").value = member_addr;
		
		document.getElementById('modify_form').submit();
		
	} else {
	alert('입력하지 않은 항목이 있는지 확인해주세요.');
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