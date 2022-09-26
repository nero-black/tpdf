function modify_video() {
	null_checker = 0;
	title = document.getElementById('title').value;
	video_source = document.getElementById('video_source').value;
	content = document.getElementById('content').value;
	input_array = [title, video_source, content];
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
	
	if (null_checker >= 3) {
	document.getElementById('modify_form').submit();
	} else {
	alert('입력하지 않은 내용이 있습니다.');
	return false;
	}

}












