package com.tpdf.shoot.service.event;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpdf.shoot.dao.EventDao;
import com.tpdf.shoot.vo.EventVo;

@Service("e_service")
public class EventServiceImpl implements EventService {
	
	private EventDao eventDao;
	
	@Autowired(required = false)
	public EventServiceImpl(EventDao eventDao) {
		this.eventDao = eventDao;
	}
	
	@Override
	public List<EventVo> event_list() {
		return eventDao.event_list();
	}
	
	@Override
	public EventVo event_now() {
		return eventDao.event_now();
	}
	
	@Override
	public int event_add(EventVo eventVo) {
		return eventDao.event_add(eventVo);
	}
	
	@Override
	public int member_point(int member_idx) {
		return eventDao.member_point(member_idx);
	}
	
	/*
	 * @Override public int event_betting_i(EventVo eventVo) { return
	 * eventDao.event_betting_i(eventVo); }
	 */
	
	/*
	 * @Override public EventVo event_betting_u(int member_idx, String betting_team,
	 * int b_point) { return eventDao.event_betting_u(member_idx, betting_team,
	 * b_point); }
	 */
	
	/*
	 * @Override public int member_point(int member_point) { return
	 * eventDao.member_point(member_point); }
	 */
	
	
}
