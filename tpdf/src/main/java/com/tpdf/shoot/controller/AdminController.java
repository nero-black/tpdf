package com.tpdf.shoot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tpdf.shoot.service.admin.AdminService;
import com.tpdf.shoot.vo.AdminVo;
import com.tpdf.shoot.vo.VideoVo;

@Controller
public class AdminController {
	
	private AdminService adminService;
	
	@Autowired (required = false)
	public void setAdminService(@Qualifier("a_service") AdminService adminService) {
		this.adminService = adminService;
	}
	
	@ResponseBody
	@RequestMapping("/invalid.do")
	public String invalid(HttpSession session) {
		session.invalidate();
		String request_mapping = "<script>alert('권한이 없습니다.');"+ "location.href='login.do'</script>";
	
	return request_mapping;
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
	public String admin_ban(Model model) {
		
		List<AdminVo> memberList = adminService.member_list();
		model.addAttribute("memberList", memberList);
		
		return "admin/admin_ban";
	}
	
	@RequestMapping("/admin_ban_search.do")
	public String video_search(String search_value, HttpServletRequest request, Model model) {
		
		String search_type = (String)request.getParameter("search_type");
		
		
		if (search_type.equals("id")) {
			List<AdminVo> memberList = adminService.member_search_id(search_value);
			model.addAttribute("memberList", memberList);
		}
		
		if (search_type.equals("name")) {
			List<AdminVo> memberList = adminService.member_search_name(search_value);
			model.addAttribute("memberList", memberList);
		}
		
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
	
	@ResponseBody
	@GetMapping("/admin_ban_process.do") // 추후 강제탈퇴할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String admin_ban_process(int member_idx, Model model) {
		
		String request_mapping = "<script>alert('알 수 없는 오류로 인해 강제 탈퇴에 실패하였습니다.'); location.href='admin_ban.do';</script>";
		
		int ban_check = adminService.admin_ban_check(member_idx);
		
		if (ban_check == 1) {
			request_mapping = "<script>alert('이미 탈퇴된 회원입니다.'); location.href='admin_ban.do';</script>";
		}
		
		if (ban_check == 0) {
			int ban_process = adminService.admin_ban_process(member_idx);
			if (ban_process == 1) {
				request_mapping = "<script>alert('강제탈퇴가 완료되었습니다.'); location.href='admin_ban.do';</script>";			
			}
		}
		
		List<AdminVo> memberList = adminService.member_list();
		model.addAttribute("memberList", memberList);
		
		return request_mapping;
	}
	
	
	
	
	
	
	
	
	
	
	
}
