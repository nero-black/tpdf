function video_share(link) {
	temp = prompt("Ctrl + C를 눌러 클립보드로 복사하세요.", link);
}

function video_delete() {
	remove_idx = document.getElementById('remove_idx').value;
	
	if (confirm('정말로 삭제하시겠습니까?')){
			location.href='video_delete_process.do?video_idx='+remove_idx;
		} else {
			return 0;
		}
}