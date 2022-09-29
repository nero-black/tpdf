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

@Controller
public class EventController {
	
	private EventService eventService;
	
	@Autowired(required = false)
	public void setEventService(@Qualifier("e_service") EventService eventService) {
		this.eventService = eventService;
	}
	
	@RequestMapping("/event_list.do")
	public String event(Model model, HttpServletRequest request) {
		List<EventVo> eventList = eventService.event_list();
		EventVo eventNow = eventService.event_now();
		model.addAttribute("eventList", eventList);
		model.addAttribute("eventNow", eventNow);
		
		HttpSession session = request.getSession();
		int member_idx = 2; // 임시로 삽입
		int member_grade = 2; // 임시로 삽입
		session.setAttribute("loginVO_member_idx", member_idx); // 추후 LoginVO.loginVO 구성으로 변경 (하나로 통일)
		session.setAttribute("loginVO_member_grade", member_grade); // 추후 LoginVO.loginVO 구성으로 변경
		
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
	public String event_betting_process(EventVo eventVo, HttpServletRequest request, Model model) {
		
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
	
	@RequestMapping("/event_set_process.do") // 추후 이벤트 종료할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String event_set_process(EventVo eventVo, HttpServletRequest request, Model model) {
		
		int sql = eventService.event_set_datetime_a(); // 이벤트 종료 datetime 값 생성 (리턴한 int값은 쓰이지 않음)
		// System.out.println("insert완료");
		String target_date = eventService.event_set_datetime_b(); // 이벤트 종료 datetime 값 추출
		eventVo.setTarget_date(target_date);
		eventService.event_set_datetime_c(eventVo);
		// System.out.println("update완료");
		eventService.event_set_datetime_d();
		// System.out.println("delete완료");
		
		// ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
		
		eventService.event_set_victory_team(eventVo);
		// System.out.println("victory_team 추가완료");
		int betting_sum = eventService.event_set_betting_sum(eventVo);
		eventVo.setBetting_sum(betting_sum);
		// System.out.println("betting_sum 값: "+eventVo.getBetting_sum());
		eventService.event_set_betting_sum_u(eventVo);
		// System.out.println("betting_sum update완료");
		
		int b_person = eventService.event_set_b_person(eventVo);
		eventVo.setB_person(b_person);
		// System.out.println("b_person 값: "+eventVo.getB_person());
		eventService.event_set_b_person_u(eventVo);
		// System.out.println("b_pserson update완료");
		
		String team_a = eventService.event_set_b_person_team_a(eventVo); // a항목의 이름 추출
		String team_b = eventService.event_set_b_person_team_b(eventVo);
		// System.out.println("String team_a항목명: "+ team_a);
		// System.out.println("String team_b항목명: "+ team_b);
		eventVo.setTeam_a(team_a); // a항목의 이름 적용
		eventVo.setTeam_b(team_b);
		// System.out.println("eventVo a항목명: "+ eventVo.getTeam_a());
		// System.out.println("eventVo b항목명: "+ eventVo.getTeam_b());
		
		float b_person_a = eventService.event_set_b_person_a(eventVo); // a항목을 선택한 사람의 수
		float b_person_b = eventService.event_set_b_person_b(eventVo);
		// System.out.println("b_person: " + b_person);
		// System.out.println("float b_person_a: " + b_person_a);
		// System.out.println("float b_person_b: " + b_person_b);
		float b_percent_a_calc = b_person_a / b_person * 100; // round함수를 이용하기 위해 100을 곱해준다.
		float b_percent_b_calc = b_person_b / b_person * 100;
		float b_percent_a = Math.round(b_percent_a_calc); // round함수를 이용해 정수로 반옹림한다.
		float b_percent_b = Math.round(b_percent_b_calc);
		b_percent_a /= 100; // 100을 다시 나누어 소수점으로 만들어준다. (이로써 소수점 3번째 자리에서 반올림(2번째 자리까지 남김)한 결과가 된다.)
		b_percent_b /= 100;
		// System.out.println(eventVo.getTeam_a()+ ":: " + b_percent_a);
		// System.out.println(eventVo.getTeam_b()+ ":: " + b_percent_b);
		eventVo.setB_percent_a(b_percent_a); // a의 배당률을 적용
		eventVo.setB_percent_b(b_percent_b);
		eventService.event_set_b_percent_a(eventVo);
		eventService.event_set_b_percent_b(eventVo);
		// System.out.println("b_percent_a,b update완료");
		
		// ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
		
		String victory_team = eventVo.getVictory_team();
		// System.out.println("int betting_sum값: "+betting_sum);
		// System.out.println("String victory값: "+victory_team);
		
		int v_person = eventService.event_set_v_person(eventVo);
		// System.out.println("victory_team을 선택한 사람의 수: "+v_person);
		eventVo.setV_person(v_person); // 베팅 승리한 사람의 수 적용
		
		float v_person_point_calc = 0;
		if (v_person >=1) {
			v_person_point_calc = betting_sum / v_person;
		}else { // 무승부(무효) 처리되었을 경우 0으로 나눗셈 처리를 막음
			v_person_point_calc = 0;
		}
		int v_person_point = Math.round(v_person_point_calc);
		// System.out.println("int v_person_point 값: " + v_person_point);
		eventVo.setV_person_point(v_person_point); // 승자 1인당 포인트 적용
		// System.out.println("eventVo.v_person_point 값: " + eventVo.getV_person_point());
		eventService.event_set_v_person_point(eventVo);
		// System.out.println("v_person_point 적용완료");
		
		// ----- ----- ----- ----- ----- ----- ----- ----- ----- -----
		
		
		
		// 그것을 기반으로 포인트 지급, 이벤트 참여기록(보존 (새 칼럼으로 old로 만들기)이 안되면 bak_tbl insert에 저장후 삭제. 이후 이벤트 종료(process = n)처리)
		
		return "event/event_set_process";
		// return "redirect:/event_list.do"; // redirect를 써주어야 오류없이 .do로 이동할 수 있다.
	}
	
	
	
	
	
}
