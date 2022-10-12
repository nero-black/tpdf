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

import com.tpdf.shoot.service.event.EventService;
import com.tpdf.shoot.vo.EventVo;
import com.tpdf.shoot.vo.MemberVo;

@Controller
public class EventController {
	
	private EventService eventService;
	
	@Autowired(required = false)
	public void setEventService(@Qualifier("e_service") EventService eventService) {
		this.eventService = eventService;
	}
	
	@RequestMapping("/event_list.do")
	public String event(Model model, HttpSession session, MemberVo memberVo, HttpServletRequest request) {
		List<EventVo> eventList = eventService.event_list();
		EventVo eventNow = eventService.event_now();
		model.addAttribute("eventList", eventList);
		model.addAttribute("eventNow", eventNow);
		
		
		Object member_idx_s = session.getAttribute("member_idx"); // 회원번호 세션에서 가져오기
		
		if (member_idx_s != null) {
			int member_idx = (Integer)member_idx_s;
			int after_point = eventService.member_point(member_idx); // 현재 포인트 조회
			session.setAttribute("member_point",after_point); // 세션에 대입
		}
		
		int process = eventService.event_betting_stop_c(); // 이벤트 중단 여부 확인
		// System.out.println("진행 상태: "+process);
		
		
		if (process == 0) { // 진행중 여부(process_stop) 판단
			session.setAttribute("process", "n");
			// System.out.println("stop여부가 n입니다.");
		} else {
			session.setAttribute("process", "y");
			// System.out.println("stop여부가 y입니다.");
		}
		
		return "event/event";
	}
	
	@GetMapping("/event_add.do")
	public String event_add() {
		return "event/event_add";
	}
	
	@PostMapping("/event_add_process.do") // 추후 이벤트 추가할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String event_add_process(EventVo eventVo, HttpServletRequest request, Model model) {
		
		int result = eventService.event_add(eventVo);
		
		String event_add_after = "event/event_add";
		
		if (result == 1) { // 이벤트 추가 성공
			
			event_add_after = "event/event_add_process";
			
			List<EventVo> eventList = eventService.event_list();
			model.addAttribute("eventList", eventList);
		}
		
		return event_add_after;
	}
	
	@ResponseBody // alert & request를 위함
	@RequestMapping("/event_betting_process.do") // 추후 이벤트 종료할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String event_betting_process(EventVo eventVo, MemberVo memberVo, HttpServletRequest request, HttpSession session, Model model) {
		
		String member_idx_s = request.getParameter("member_idx");
		int member_idx = Integer.parseInt(member_idx_s); // String으로 가져온 파라미터값을 int로 형변환
		String betting_team = request.getParameter("betting_team");
		String b_point_s = request.getParameter("b_point");
		int b_point = Integer.parseInt(b_point_s); // String으로 가져온 파라미터값을 int로 형변환
		
		int event_check = 0;
		event_check = eventService.event_betting_c(member_idx); // 이벤트 참여이력 확인
		
		if (event_check == 0) { // 참여한적 없음
			
			// System.out.println("event_check: "+event_check);
		
			int member_point = eventService.member_point(member_idx);
			eventVo.setMember_point(member_point);
					
			if (member_point >= b_point) {
				int result_i = eventService.event_betting_i(eventVo); // 베팅 목록에 삽입
				eventService.event_betting_u(eventVo); // 개인 포인트 감소
				int after_point = memberVo.getMember_point(); // 처리후 남은 포인트
				session.setAttribute("member_point",after_point); // 세션에 대입
				String result_mapping = "<script>alert('베팅이 완료되었습니다.');"
						+ "location.href='/event_list.do'</script>";
				return result_mapping;
			} else {
				String result_mapping = "<script>alert('베팅에 사용할 포인트가 부족합니다.');"
										+ "location.href='/event_list.do'</script>";
				return result_mapping;
			}
		}
		
		else { // 참여한적 있음
			
			// System.out.println("event_check: "+event_check);
		
		String result_mapping = "<script>alert('이미 이벤트에 참여하셨습니다.');"
				+ "location.href='/event_list.do'</script>";
		return result_mapping;
		}
		
		// System.out.println("회원 번호: "+member_idx);
		// System.out.println("베팅한 팀: "+betting_team);
		// System.out.println("베팅 포인트: "+b_point);
		// System.out.println("보유 포인트: "+member_point);
		
	}
	
	@ResponseBody // alert & request를 위함
	@GetMapping("/event_stop.do")
	public String event_stop(EventVo eventVo) {
		eventService.event_stop(eventVo); // 이벤트 종료
		// eventService.event_calc_sum(eventVo); // 베팅 총액 삽입
		// eventService.event_calc_percent_a(eventVo); // a항목 배당률 삽입
		// eventService.event_calc_percent_b(eventVo); // b항목 배당률 삽입
		String result_mapping = "<script>alert('이벤트 베팅이 종료되었습니다.');"
				+ "location.href='/event_list.do'</script>";
		return result_mapping;
	}
	
	@ResponseBody // alert & request를 위함
	@RequestMapping("/event_set_process.do")
	public String event_set_process(EventVo eventVo, HttpServletRequest request, Model model) {
		
		// 이벤트 종료 시간 기록
		
		int sql = eventService.event_set_datetime_a(); // 이벤트 종료 datetime 값 생성 (리턴한 int값은 쓰이지 않음)
		// System.out.println("insert완료");
		String target_date = eventService.event_set_datetime_b(); // 이벤트 종료 datetime 값 추출
		eventVo.setTarget_date(target_date);
		eventService.event_set_datetime_c(eventVo);
		// System.out.println("update완료");
		eventService.event_set_datetime_d();
		// System.out.println("delete완료");
		
		// ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
		
		// 팀 명 기록
		
		String team_a = eventService.event_set_b_person_team_a(eventVo); // a항목의 이름 추출
		String team_b = eventService.event_set_b_person_team_b(eventVo);
		// System.out.println("String team_a항목명: "+ team_a);
		// System.out.println("String team_b항목명: "+ team_b);
		eventVo.setTeam_a(team_a); // a항목의 이름 적용
		eventVo.setTeam_b(team_b);
		// System.out.println("eventVo a항목명: "+ eventVo.getTeam_a());
		// System.out.println("eventVo b항목명: "+ eventVo.getTeam_b());
		eventService.event_end_b1(eventVo); // event_user_tbl null 방지
		eventService.event_end_b2(eventVo); // event_user_tbl null 방지
		
		// 베팅 포인트 총 합 구하고 업데이트
		
		int betting_sum = eventService.event_set_betting_sum(eventVo);
		eventVo.setBetting_sum(betting_sum);
		// System.out.println("betting_sum 값: "+eventVo.getBetting_sum());
		eventService.event_set_betting_sum_u(eventVo);
		// System.out.println("betting_sum update완료");
		
		// 베팅한 사람 총 인원 구하고 업데이트
		
		int b_person = eventService.event_set_b_person(eventVo);
		eventVo.setB_person(b_person);
		// System.out.println("b_person 값: "+eventVo.getB_person());
		eventService.event_set_b_person_u(eventVo);
		// System.out.println("b_pserson update완료");
		
		// 선택 비율 업데이트
		
		float b_person_a = eventService.event_set_b_person_a(eventVo) -1; // a항목을 선택한 사람의 수. -1은 null방지 가상값 제외
		float b_person_b = eventService.event_set_b_person_b(eventVo) -1;
		// System.out.println("b_person: " + b_person);
		// System.out.println("int b_person_a: " + b_person_a);
		// System.out.println("int b_person_b: " + b_person_b);
		float b_percent_a_calc = b_person_a / b_person * 100; // round함수를 이용하기 위해 100을 곱해준다.
		float b_percent_b_calc = b_person_b / b_person * 100;
		float b_percent_a = Math.round(b_percent_a_calc); // round함수를 이용해 정수로 반옹림한다.
		float b_percent_b = Math.round(b_percent_b_calc);
		// b_percent_a /= 100; // 100을 다시 나누어 소수점으로 만들어준다. (이로써 소수점 3번째 자리에서 반올림(2번째 자리까지 남김)한 결과가 된다.)
		// b_percent_b /= 100;
		
		// System.out.println(eventVo.getTeam_a()+ ":: " + b_percent_a);
		// System.out.println(eventVo.getTeam_b()+ ":: " + b_percent_b);
		eventVo.setB_percent_a(b_percent_a); // a의 배당률을 적용
		eventVo.setB_percent_b(b_percent_b);
		eventService.event_set_b_percent_a(eventVo);
		eventService.event_set_b_percent_b(eventVo);
		// System.out.println("b_percent_a,b update완료");
		
		// ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
		
		// 승리팀 및 승리 인원 적용
		
		eventService.event_set_victory_team(eventVo);
		// System.out.println("victory_team 추가완료");
		
		String victory_team = eventVo.getVictory_team();
		// System.out.println("int betting_sum값: "+betting_sum);
		// System.out.println("String victory값: "+victory_team);
		
		int v_person = eventService.event_set_v_person(eventVo) -1; // -1은 null방지 가상값 제외
		if (v_person == -1) { v_person = 0;} // 무승부시 -1명 되는 상황을 방지
		
		// System.out.println("victory_team을 선택한 사람의 수: "+v_person);
		eventVo.setV_person(v_person); // 베팅 승리한 사람의 수 적용
		eventService.event_set_v_person_c(eventVo);
		// System.out.println("v_person 적용완료");
		
		
		// ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
		
		// 포인트 지급, 참여기록 삭제, 이벤트 종료
		
		int betting_sum_a = eventService.event_set_betting_sum_a(eventVo);
		int betting_sum_b = eventService.event_set_betting_sum_b(eventVo);
		eventVo.setBetting_sum_a(betting_sum_a);
		eventVo.setBetting_sum_b(betting_sum_b);
		eventService.event_set_point_a(eventVo);
		eventService.event_set_point_b(eventVo);
		eventService.event_set_point(eventVo);
		// System.out.println("int betting_sum_a: "+ betting_sum_a);
		// System.out.println("int betting_sum_b: "+ betting_sum_b);
		// System.out.println("String team_a: "+ team_a);
		// System.out.println("String team_b: "+ team_b);
		
		// '왜 b_percent가 1.66으로 나오는가?' 디버깅
		/* List<EventVo> temp1 = eventService.temp(eventVo);
		
		for(EventVo temp2 : temp1) {
			System.out.println("member_idx: "+temp2.getMember_idx());
			System.out.println("betting_team: "+temp2.getBetting_team());
			System.out.println("b_point "+temp2.getB_point());
			System.out.println("betting_sum_a "+temp2.getBetting_sum_a());
			System.out.println("b_percent: "+temp2.getB_percent());
			
			System.out.println("-------------------------");
			
			int ab = temp2.getB_point();
			int abc = temp2.getBetting_sum_a();
			int abcd = ab / abc;
			System.out.println("결과: " +abcd);
			
		} */
		
		eventService.event_end_a();
		eventService.event_end_c();
		
		String result_mapping = "<script>alert('포인트 지급이 완료되었습니다.');"
				+ "location.href='/event_list.do'</script>";
		return result_mapping;
		// return "redirect:/event_list.do"; // redirect를 써주어야 오류없이 .do로 이동할 수 있다.
	}
	
	
	
	
	
}
