package com.tpdf.shoot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tpdf.shoot.service.admin.AdminService;
import com.tpdf.shoot.vo.AdminVo;

@Controller
public class AdminController {
	
	private AdminService adminService;
	
	@Autowired (required = false)
	public void setAdminService(@Qualifier("a_service") AdminService adminService) {
		this.adminService = adminService;
	}
	
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
	
	@ResponseBody
	@RequestMapping("/admin_point_process.do")
	public String admin_point_process(AdminVo adminVo, HttpServletRequest request) {
		
		String name = (String)request.getParameter("member_name"); // 폼 입력값 받아옴
		String point = (String)request.getParameter("member_point");
		
		String request_mapping = "<script>alert('" + name + "은(는) 존재하지 않는 닉네임입니다.');" + "location.href='admin_point.do'</script>";

		int member_check = adminService.admin_point_check(adminVo); // 유효여부 확인

		if (member_check == 1) {
			
			adminService.admin_point(adminVo); // 포인트 지급
			request_mapping = "<script>alert('" + name + "님에게 " + point + "포인트 지급이 완료되었습니다.');" + 
							  "location.href='admin_point.do'</script>";
		}
		
		return request_mapping;
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
