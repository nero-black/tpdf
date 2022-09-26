
function insert_cancel(){
	let result = confirm("정말로 글 작성을 취소하시겠습니까?");
	
	if(result == true) {
		location.href='board_list.do';
	} else {
		return 0;
		/* window.history.back(); 뒤로가기 */
	}
}