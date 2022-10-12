$(function(){ // 닉네임 입력 방지 (한글 조합없는 자모음, 영어, 숫자, 특수문자, 공백)
	$( '#member_name' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ]/g, '' ) );	
		$(this).val( $(this).val().replace( /[a-z|A-Z|0-9]/g, '' ) );
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) );
		$(this).val( $(this).val().replace( ' ', '' ) );
	});
})

$(function(){ // 포인트 입력 방지 (한글, 특수문자(-, +제외), 공백)
	$( '#member_point' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) );
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?,;:|\)*~`!^\_┼<>\#$%&\'\"\\\(\=]/gi, '' ) );
		$(this).val( $(this).val().replace( ' ', '' ) );
	});
})

function admin_point(){
	let result = confirm("해당 내용대로 포인트를 지급하시겠습니까?");
	
	if(result == true) {
	
	/* ==================== */
	
	null_checker = 0;
	member_name = document.getElementById('member_name').value;
	member_point = document.getElementById('member_point').value;
	input_array = [member_name, member_point];
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
	document.getElementById('admin_point_form').submit();
	} else {
	alert('지급 대상과 지급할 포인트를 모두 입력해야 합니다.');
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