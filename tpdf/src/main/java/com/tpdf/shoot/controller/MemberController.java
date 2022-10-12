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

import com.tpdf.shoot.service.member.MemberService;
import com.tpdf.shoot.vo.EventVo;
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
	
	@RequestMapping("/id_check.do")
	public String id_check(MemberVo memberVo, HttpSession session) {
		int id_check = memberService.id_check(memberVo); // 아이디 중복 여부 확인
		
		if (id_check == 1) {
			session.setAttribute("result", id_check);
		} else {
			session.setAttribute("result", id_check);
		}
		
		return "member/id_check";
	}
	
	@RequestMapping("/name_check.do")
	public String name_check(MemberVo memberVo, HttpSession session) {
		int name_check = memberService.name_check(memberVo); // 닉네임 중복 여부 확인
		
		session.setAttribute("result", name_check);
		
		return "member/name_check";
	}
	
	@ResponseBody
	@RequestMapping("/join_process.do")
	public String join_process(MemberVo memberVo, HttpServletRequest request) {
		
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
		
		String request_mapping = "<script>alert('회원가입이 완료되었습니다.');"+ "location.href='/login.do'</script>";
			memberService.join_process(memberVo); // 회원가입 처리
			return request_mapping;
	}
	
	@GetMapping("/login.do")
	public String login() {
		return "member/login";
	}
	
	@ResponseBody
	@RequestMapping("/login_process.do")
	public String login_process(MemberVo memberVo, HttpSession session) {
		
		MemberVo member_check = memberService.login_check(memberVo); // 회원 여부 확인

		String request_mapping = "<script>alert('아이디 또는 비밀번호를 확인해주세요.');"+ "location.href='/login.do'</script>";
		
		int drop_check = memberService.drop_check(memberVo);
		if (drop_check == 1) { request_mapping = "<script>location.href='/dropped.do'</script>"; }
		
		if (member_check != null) {
			
			request_mapping = "<script>location.href='index.do'</script>";
			
			session.setAttribute("member_idx", member_check.getMember_idx());
			session.setAttribute("member_id", member_check.getMember_id());
			session.setAttribute("member_name", member_check.getMember_name());
			session.setAttribute("member_point", member_check.getMember_point());
			session.setAttribute("member_grade", member_check.getMember_grade());
			session.setAttribute("member_drop", member_check.getDel_yn());
		}
		
		return request_mapping;
	} 
	
	@ResponseBody
	@RequestMapping("/log_out.do")
	public String log_out(HttpSession session) {
		session.invalidate();
		String request_mapping = "<script>location.href='index.do'</script>";
	
	return request_mapping;
	}
	
	@ResponseBody
	@RequestMapping("/dropped.do")
	public String dropped(HttpSession session) {
		session.invalidate();
		String request_mapping = "<script>alert('탈퇴된 회원입니다.');"+ "location.href='index.do'</script>";
	
	return request_mapping;
	}
	
	@GetMapping("/find_idpw.do")
	public String find_idpw() {
		return "member/find_idpw";
	}
	
	@GetMapping("/find_id.do")
	public String find_id(MemberVo memberVo, HttpSession session) {
		
		int find_id1 = memberService.find_id1(memberVo); // 아이디 존재 여부 확인
		
		if (find_id1 == 1) {
		String find_id2 = memberService.find_id2(memberVo); // 아이디 값 확인
		session.setAttribute("member_id", find_id2);
		}
		
		session.setAttribute("result", find_id1);
			
		return "member/find_id";
	}
	
	@GetMapping("/find_pw.do")
	public String find_pw(MemberVo memberVo, HttpSession session) {
		
		int find_pw1 = memberService.find_pw1(memberVo); // 아이디 일치 여부 확인
		String find_pw2;
		String find_pw3;
		
		session.setAttribute("result", find_pw1);
		
		if (find_pw1 == 1) {
			find_pw2 = memberService.find_pw2(memberVo); // 찾으려는 아이디 확인
			find_pw3 = memberService.find_pw3(memberVo); // 비밀번호 찾기 질문 가져오기
			session.setAttribute("member_id", find_pw2); // 아이디 찾기 이후 다른값이 나오지 않도록 세션 덮어쓰기
			session.setAttribute("quest", find_pw3);
			}
			
		return "member/find_pw";
	}
	
	@GetMapping("/find_pw_quest.do") // 추후 아이디/비밀번호 찾을 때 이곳에 매개변수 넘어가는 과정 처리해주어야 함
	public String find_pw_quest(MemberVo memberVo, HttpSession session) {
		
		int result = memberService.find_pw4(memberVo); // 비밀번호 찾기 결과 존재 여부
		session.setAttribute("result", result);
		
		if (result == 1) {
		String member_pw = memberService.find_pw5(memberVo); // 비밀번호 찾기 결과 가져오기
		session.setAttribute("member_pw", member_pw); // 아이디 찾기 이후 다른값이 나오지 않도록 세션 덮어쓰기
		}
		
		return "member/find_pw_quest";
	}
	
	@GetMapping("/mypage_check.do")
	public String mypage_check(MemberVo memberVo) {
		
		return "member/mypage_check";
	}
	
	@ResponseBody
	@PostMapping("/mypage_check_process.do")
	public String mypage_check_process(MemberVo memberVo, HttpServletRequest request) {

		String request_mapping = "<script>alert('비밀번호가 틀렸습니다.');"+ "location.href='mypage_check.do'</script>";
		int result = memberService.member_check(memberVo); // 일치 여부 확인

		if (result == 1) {
			request_mapping = "<script>location.href='mypage.do'</script>";
		}

		return request_mapping;
		
	}
	
	@GetMapping("/mypage.do")
	public String mypage(MemberVo memberVo, HttpServletRequest request, HttpSession session, Model model) {
		
		Object member_idx_o = session.getAttribute("member_idx"); // 로그인한 인덱스 번호 추출
		int member_idx = (Integer)member_idx_o;  // 로그인한 인덱스 번호 int형으로 변경
		memberVo.setMember_idx(member_idx); // memberVo의 현재 idx값 설정
		MemberVo member_info_o = memberService.member_info(member_idx); // 현재 member_idx기반으로 정보 조회
		model.addAttribute("member_info", member_info_o); // 조회 데이터 담아오기
		
		int now_point = memberService.member_point(memberVo); // 현재 내 포인트
		session.setAttribute("member_point", now_point); // 세션에 대입
		
		
		return "member/mypage";
	}

	@GetMapping("/point_check.do")
	public String point_check() {
		return "member/point_check";
	}
	
	@GetMapping("/modify.do")
	public String modify(MemberVo memberVo, HttpServletRequest request, HttpSession session, Model model) {
		
		Object member_idx_o = session.getAttribute("member_idx"); // 로그인한 인덱스 번호 추출
		int member_idx = (Integer)member_idx_o;  // 로그인한 인덱스 번호 int형으로 변경
		memberVo.setMember_idx(member_idx); // memberVo의 현재 idx값 설정
		MemberVo member_info_o = memberService.member_info(member_idx); // 현재 member_idx기반으로 정보 조회
		model.addAttribute("member_info", member_info_o); // 조회 데이터 담아오기
		
		return "member/modify";
	}
	
	@ResponseBody
	@PostMapping("/modify_process.do")
	public String modify_process(MemberVo memberVo, HttpServletRequest request) {
		
		memberService.member_modify(memberVo);
		
		String request_mapping = "<script>alert('회원 정보가 수정되었습니다.');"+ "location.href='mypage.do'</script>";

		return request_mapping;
		
	}
	
	@GetMapping("/point_pass.do")
	public String point_pass() {
		return "member/point_pass";
	}
	
	@PostMapping("/point_pass_process.do") // 추후 포인트를 전달할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String point_pass_process() {
		return "member/point_pass_process";
	}
	
	@ResponseBody
	@GetMapping("/mypage_drop_process.do")
	public String mypage_drop_process(MemberVo memberVo, HttpSession session) {
		
		Object member_idx_o = session.getAttribute("member_idx"); // 로그인한 인덱스 번호 추출
		int member_idx = (Integer)member_idx_o;  // 로그인한 인덱스 번호 int형으로 변경
		memberVo.setMember_idx(member_idx); // memberVo의 현재 idx값 설정
		
		memberService.member_drop(memberVo); // 회원 탈퇴처리
		
		session.invalidate();
		String request_mapping = "<script>alert('정상적으로 회원 탈퇴 처리되었습니다.');"+ "location.href='index.do'</script>";

		return request_mapping;
	}
	
	
	
		
	
	
	
	
	
	
	
	
}
