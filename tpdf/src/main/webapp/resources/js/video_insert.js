function insert_cancel(){
	let result = confirm("정말로 업로드를 취소하시겠습니까?");
	
	if(result == true) {
		location.href='video_list.do';
	} else {
		return 0;
		/* window.history.back(); 뒤로가기 */
	}
}

function insert_video() {
	null_checker = 0;
	title = document.getElementById('title').value;
	video_source = document.getElementById('video_source').value;
	content = document.getElementById('content').value;
	file = document.getElementById('file').value;
	input_array = [title, video_source, content, file];
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
	document.getElementById('upload_form').submit();
	} else {
	alert('입력하지 않은 내용이 있습니다.');
	return false;
	}

}












