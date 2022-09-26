package com.tpdf.shoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NoticeController {
	
	@GetMapping("/notice_list.do")
	public String notice() {
		return "notice/notice";
	}
	
	@GetMapping("/notice_insert.do")
	public String notice_insert() {
		return "notice/notice_insert";
	}
	
	@PostMapping("/notice_insert_process.do") // 추후 게시글 작성할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String notice_insert_process() {
		return "notice/notice_insert_process";
	}
	
	@GetMapping("/notice_view.do")
	public String notice_view() {
		return "notice/notice_view";
	}
	
	@GetMapping("/notice_modify.do")
	public String notice_modify() {
		return "notice/notice_modify";
	}
	
	@PostMapping("/notice_modify_process.do") // 추후 게시글 수정할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String notice_modify_process() {
		return "notice/notice_modify_process";
	}
	
	@PostMapping("/notice_delete_process.do") // 추후 게시글 삭제할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String notice_delete_process() {
		return "notice/notice_delete_process";
	}
	
	
	
	
	
}
