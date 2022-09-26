window.onload = function update_color() {
	var today = new Date();
	var month = today.getMonth()+1;
	// var month = 10;
	
	if (month>=4 & month<=6) {
		header.style.backgroundColor= '#0BC904';
		other.style.backgroundColor= '#0BC904';
		info.style.backgroundColor= 'green';
		// console.log(month+" (봄으로 색 변경)");
	} else if (month>=7 & month<=9) {
		header.style.backgroundColor= '#0054FF';
		other.style.backgroundColor= '#0054FF';
		info.style.backgroundColor= 'blue';
		// console.log(month+" (여름으로 색 변경)");
	} else if (month>=10 & month<=12) {
		header.style.backgroundColor= 'orange';
		other.style.backgroundColor= 'orange';
		info.style.backgroundColor= '#A56100';
		// console.log(month+" (가을로 색 변경)");
	} else {
		header.style.backgroundColor= '#5CD1E5';
		other.style.backgroundColor= '#5CD1E5';
		info.style.backgroundColor= '#00B4DB';
		// console.log(month+" (겨울로 색 변경)");
	}
}

// header.style.backgroundColor= '#000000';
// setInterval(update_color,10000); // 일정 시간(단위:ms)마다 함수 호출