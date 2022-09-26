package com.tpdf.shoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	
	@GetMapping("/board_list.do")
	public String board() {
		return "board/board";
	}
	
	@GetMapping("/board_insert.do")
	public String board_insert() {
		return "board/board_insert";
	}
	
	@GetMapping("/board_view.do")
	public String board_view() {
		return "board/board_view";
	}
	
	@GetMapping("/board_modify.do")
	public String board_modify() {
		return "board/board_modify";
	}
	
	@PostMapping("/board_insert_process.do") // 추후 게시글 작성할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String board_insert_process() {
		return "board/board_insert_process";
	}
	
	@PostMapping("/board_comment_insert_process.do") // 추후 댓글 작성할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String board_comment_insert_process() {
		return "board/board_comment_insert_process";
	}
	
	@PostMapping("/board_modify_process.do") // 추후 게시글 수정할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String board_modify_process() {
		return "board/board_modify_process";
	}
	
	@PostMapping("/board_delete_process.do") // 추후 게시글 삭제할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String board_delete_process() {
		return "board/board_delete_process";
	}
	
	
	
	
	
}
