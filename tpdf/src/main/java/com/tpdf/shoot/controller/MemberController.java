package com.tpdf.shoot.controller;

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

import com.tpdf.shoot.service.member.MemberService;
import com.tpdf.shoot.vo.MemberVo;

@Controller
public class MemberController {
	
	private MemberService memberService;
	
	@Autowired (required = false)
	public void setMemberService(@Qualifier("m_service") MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/join.do")
	public String join() {
		return "member/join";
	}
	
	@RequestMapping("/join_process.do")
	public String join_process(MemberVo memberVo, HttpServletRequest request, Model model) {
		
		// 폼에 들어있는 값 가져와서 출력
		/*
		String member_id = request.getParameter("member_id");
		String member_pw = request.getParameter("member_pw");
		String member_name = request.getParameter("member_name");
		String member_email = request.getParameter("member_email");
		String member_tel = request.getParameter("member_tel");
		String member_gender = request.getParameter("member_gender");
		String member_birth = request.getParameter("member_birth");
		String addr1 = request.getParameter("member_addr1");
		String addr2 = request.getParameter("member_addr2");
		String member_addr = addr1 + " " + addr2;
		System.out.println(member_id +"/"+ member_pw +"/"+ member_name +"/"+ member_email +"/" 
		+member_tel +"/"+ member_gender +"/"+ member_birth +"/"+ member_addr);
		*/
		
		memberService.join_process(memberVo);
		return "member/join_process";
	}	
	
	@GetMapping("/login.do")
	public String login() {
		return "member/login";
	}
	
	@ResponseBody
	@RequestMapping("/login_process.do")
	public String login_process(MemberVo memberVo, HttpSession session, Model model) {
		
		MemberVo member_check = memberService.login_check(memberVo); // 회원 여부 확인
		
		String request_mapping = "<script>alert('로그인 실패');"+ "location.href='/login.do'</script>";
		
		if (member_check != null) {
			request_mapping = "<script>alert('로그인 성공');"+ "location.href='index.do'</script>";
			
			session.setAttribute("member_idx", member_check.getMember_idx());
			session.setAttribute("member_name", member_check.getMember_name());
			session.setAttribute("member_point", member_check.getMember_point());
			session.setAttribute("member_grade", member_check.getMember_grade());
			session.setAttribute("member_ban", member_check.getDel_yn());
		}
		
		return request_mapping;
	} 
	
	@ResponseBody
	@RequestMapping("/log_out.do")
	public String log_out(HttpSession session) {
		session.invalidate();
		String request_mapping = "<script>alert('로그아웃 되었습니다.');"+ "location.href='index.do'</script>";
	
	return request_mapping;
	}
	
	@ResponseBody
	@RequestMapping("/banned.do")
	public String banned(HttpSession session) {
		session.invalidate();
		String request_mapping = "<script>alert('강제탈퇴된 계정입니다.');"+ "location.href='index.do'</script>";
	
	return request_mapping;
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
