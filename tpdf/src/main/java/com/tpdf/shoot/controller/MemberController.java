package com.tpdf.shoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	
	@GetMapping("/login.do")
	public String login() {
		return "member/login";
	}
	
	@GetMapping("/join.do")
	public String join() {
		return "member/join";
	}
	
	@PostMapping("/login_process.do") // 추후 로그인때 이곳에 매개변수 넘어가는 과정 처리해주어야 함
	public String login_process() {
		return "member/login_process";
	} 
	
	@PostMapping("/join_process.do") // 추후 회원가입때 이곳에 매개변수 넘어가는 과정 처리해주어야 함
	public String join_process() {
		return "member/join_process";
	}
	
	@GetMapping("/find_ippw.do")
	public String find_ippw() {
		return "member/find_idpw";
	}
	
	@PostMapping("/find_idpw_process.do") // 추후 아이디/비밀번호 찾을 때 이곳에 매개변수 넘어가는 과정 처리해주어야 함
	public String find_idpw_process() {
		return "member/find_idpw_process";
	}
	
	@GetMapping("/mypage_check.do")
	public String mypage_check() {
		return "member/mypage_check";
	}
	
	@PostMapping("/mypage_check_process.do") // 추후 마이 페이지 진입할 때 이곳에 매개변수 넘어가는 과정 처리해주어야 함
	public String mypage_check_process() { // 이후 쿠키값을 부여해 10분간은 자동으로 넘어가지게 만들어야 함
		return "member/mypage";// 추후 마이페이지가 아닌 mypage_check_process가 되도록 수정해주어야 함
	}
	
	@GetMapping("/mypage.do")
	public String mypage() {
		return "member/mypage";
	}
	
	@GetMapping("/point_check.do")
	public String point_check() {
		return "member/point_check";
	}
	
	@GetMapping("/modify.do")
	public String modify() {
		return "member/modify";
	}
	
	@PostMapping("/modify_process.do") // 추후 수정되는 회원정보 매개변수 넘어가는 과정 처리해주어야 함
	public String modify_process() {
		return "member/modify_process";
	}
	
	@GetMapping("/point_pass.do")
	public String point_pass() {
		return "member/point_pass";
	}
	
	@PostMapping("/point_pass_process.do") // 추후 포인트를 전달할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String point_pass_process() {
		return "member/point_pass_process";
	}
	
	@PostMapping("/mypage_drop_process.do") // 추후 회원탈퇴할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String mypage_drop_process() {
		return "member/myptage_drop_process";
	}
	
	
	
		
	
	
	
	
	
	
	
	
}
