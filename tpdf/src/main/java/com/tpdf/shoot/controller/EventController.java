package com.tpdf.shoot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tpdf.shoot.service.event.EventService;
import com.tpdf.shoot.vo.EventVo;
import com.tpdf.shoot.vo.VideoVo;

@Controller
public class EventController {
	
	private EventService eventService;
	
	@Autowired(required = false)
	public void setEventService(@Qualifier("e_service") EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping("/event_list.do")
	public String event(Model model) {
		List<EventVo> eventList = eventService.event_list();
		EventVo eventNow = eventService.event_now();
		model.addAttribute("eventList", eventList);
		model.addAttribute("eventNow", eventNow);
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
	
	@RequestMapping("/event_betting_process.do") // 추후 이벤트 종료할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String event_betting_process(EventVo eventVo, HttpServletRequest request, Model model) {
		
		String member_idx_s = request.getParameter("member_idx");
		int member_idx = Integer.parseInt(member_idx_s); // String으로 가져온 파라미터값을 int로 형변환
		String betting_team = request.getParameter("betting_team");
		String b_point_s = request.getParameter("betting_point");
		int b_point = Integer.parseInt(b_point_s); // String으로 가져온 파라미터값을 int로 형변환
		
		int member_point = eventService.member_point(member_idx);
		
		if (member_point >= b_point) {
			int result_i = eventService.event_betting_i(eventVo);
			// EventVo result_u = eventService.event_betting_u(member_idx, betting_team, b_point);
		}
		
		System.out.println("회원 번호: "+member_idx);
		System.out.println("베팅한 팀: "+betting_team);
		System.out.println("베팅 포인트: "+b_point);
		System.out.println("보유 포인트: "+member_point);
		
		return "event/event_betting_process";
	}
	
	@PostMapping("/event_set_process.do") // 추후 이벤트 종료할 때 매개변수 넘어가는 과정 처리해주어야 함
	public String event_set_process() {
		return "event/event_set_process";
	}
	
	
	
	
	
}
