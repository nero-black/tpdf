$(function(){ // 닉네임 입력 방지 (한글 조합없는 자모음, 영어, 숫자, 특수문자, 공백)
	$( '#member_name' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ]/g, '' ) );	
		$(this).val( $(this).val().replace( /[a-z|A-Z|0-9]/g, '' ) );
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) );
		$(this).val( $(this).val().replace( ' ', '' ) );
	});
})

$(function(){ // 이메일 입력 방지 (한글, 특수문자(_ 제외), 공백)
	$( '#member_email' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/g, '' ) );
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?.,;:|\)*~`!^\-+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) );
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

$(function(){ // 아이디 입력 방지 (한글 조합없는 자모음, 특수문자(_ 제외), 공백)
	$( '#member_id' ).on("blur keyup", function() {
		$(this).val( $(this).val().replace( /[ㄱ-ㅎ|ㅏ-ㅣ]/g, '' ) );	
		$(this).val( $(this).val().replace( /[\{\}\[\]\/?.,;:|\)*~`!^\-+┼<>@\#$%&\'\"\\\(\=]/gi, '' ) );
		$(this).val( $(this).val().replace( ' ', '' ) );
	});
})

function find_id() {
	member_name = document.getElementById('member_name').value;
	member_email = document.getElementById('member_email').value;
	member_tel = document.getElementById('member_tel').value;	
	if (member_name == '') { alert('닉네임을 입력해주세요.'); return false; }
	if (member_email == '') { alert('이메일를 입력해주세요.'); return false; }
	if (member_tel == '') { alert('전화번호를 입력해주세요.'); return false; }
	
	request = 'find_id.do?member_name=' + member_name + '&member_email=' + member_email + '&member_tel=' + member_tel;

	window.open(request, "ID 찾기", "width=500px, height=200px, resizeable=no, scrollbars=no");
	
}

function find_pw() {
	member_id = document.getElementById('member_id').value;
	if (member_id == '') { alert('아이디를 입력해주세요.'); return false; }

	request = 'find_pw.do?member_id=' + member_id;

	window.open(request, "비밀번호 찾기", "width=500px, height=200px, resizeable=no, scrollbars=no");
	
}



// window.onload
// info.style.backgroundColor= '#00B4DB';