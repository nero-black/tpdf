package com.tpdf.shoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin_index.do")
	public String admin_index() {
		return "admin/admin_index";
	}
	
	@GetMapping("/admin_point.do")
	public String admin_point() {
		return "admin/admin_point";
	}
	
	@GetMapping("/admin_report.do")
	public String admin_report() {
		return "admin/admin_report";
	}
	
	@GetMapping("/admin_filter.do")
	public String admin_filter() {
		return "admin/admin_filter";
	}
	
	@GetMapping("/admin_ban.do")
	public String admin_ban() {
		return "admin/admin_ban";
	}
	
	@PostMapping("/admin_point_process.do") // 추후 포인트를 지급할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String admin_point_process() {
		return "admin/admin_point_process";
	}
	
	@PostMapping("/admin_filter_process.do") // 추후 필터를 추가할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String admin_filter_process() {
		return "admin/admin_filter_process";
	}
	
	@PostMapping("/admin_ban_process.do") // 추후 강제탈퇴할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String admin_ban_process() {
		return "admin/admin_ban_process";
	}
	
	
	
	
	
	
	
	
	
	
	
}
