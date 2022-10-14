window.addEventListener('load', function() {
	var today = new Date();
	var month = today.getMonth()+1;
	// var month = 10;
	
		if (month>=4 & month<=6) {
		sub_menu.style.backgroundColor= '#0BC904';
		league_menu_a.style.backgroundColor= '#0BC904';
		league_menu_b.style.backgroundColor= '#0BC904';
		league_menu_c.style.backgroundColor= '#0BC904';
		league_menu_d.style.backgroundColor= '#0BC904';
		league_menu_e.style.backgroundColor= '#0BC904';
		// console.log(month+" (봄으로 색 변경)");
		
	} else if (month>=7 & month<=9) {
		sub_menu.style.backgroundColor= '#0054FF';
		league_menu_a.style.backgroundColor= '#0054FF';
		league_menu_b.style.backgroundColor= '#0054FF';
		league_menu_c.style.backgroundColor= '#0054FF';
		league_menu_d.style.backgroundColor= '#0054FF';
		league_menu_e.style.backgroundColor= '#0054FF';
		
		// console.log(month+" (여름으로 색 변경)");
	} else if (month>=10 & month<=12) {
		sub_menu.style.backgroundColor= 'orange';
		league_menu_a.style.backgroundColor= 'orange';
		league_menu_b.style.backgroundColor= 'orange';
		league_menu_c.style.backgroundColor= 'orange';
		league_menu_d.style.backgroundColor= 'orange';
		league_menu_e.style.backgroundColor= 'orange';

		// console.log(month+" (가을로 색 변경)");
	} else {
		sub_menu.style.backgroundColor= '#5CD1E5';
		league_menu_a.style.backgroundColor= '#5CD1E5';
		league_menu_b.style.backgroundColor= '#5CD1E5';
		league_menu_c.style.backgroundColor= '#5CD1E5';
		league_menu_d.style.backgroundColor= '#5CD1E5';
		league_menu_e.style.backgroundColor= '#5CD1E5';
		
		// console.log(month+" (겨울로 색 변경)");
	}

})
