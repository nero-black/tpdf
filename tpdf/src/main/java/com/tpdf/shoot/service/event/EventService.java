package com.tpdf.shoot.service.event;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tpdf.shoot.vo.EventVo;

public interface EventService {
	
	default List<EventVo> event_list() {
		return null;
	}
	
	default EventVo event_now() {
		return null;
	}
	
	default int event_add(EventVo eventVo) {
		return 0;
	}
	
	default int member_point(int member_idx) {
		return 0;
	}
	
	default int event_betting_i(EventVo eventVo) {
		return 0;
	}
	
	/*
	 * default EventVo event_betting_u(int member_idx, String betting_team, int
	 * b_point) { return null; }
	 */
	
	
	
	
}
