package com.tpdf.shoot.service.event;

import java.util.Date;
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
	
	@Override
	public int event_betting_c(int member_idx) {
		return eventDao.event_betting_c(member_idx);
	}
	
	@Override
	public int event_betting_i(EventVo eventVo) {
		return eventDao.event_betting_i(eventVo);
	}
	
	@Override
	public EventVo event_betting_u(EventVo eventVo) {
		return eventDao.event_betting_u(eventVo);
	}
	
	@Override
	public int event_betting_stop_c() {
		return eventDao.event_betting_stop_c();
	}
	
	@Override
	public EventVo event_stop(EventVo eventVo) {
		return eventDao.event_stop(eventVo);
	}
	/*
	@Override
	public EventVo event_calc_sum() {
		return eventDao.event_calc_sum();
	}
	
	@Override
	public EventVo event_calc_percent_a() {
		return eventDao.event_calc_percent_a();
	}
	
	@Override
	public EventVo event_calc_percent_b() {
		return eventDao.event_calc_percent_b();
	} */
	
	@Override
	public int event_set_datetime_a() {
		return eventDao.event_set_datetime_a();
	}
	
	@Override
	public String event_set_datetime_b() {
		return eventDao.event_set_datetime_b();
	}
	
	@Override
	public EventVo event_set_datetime_c(EventVo eventVo) {
		return eventDao.event_set_datetime_c(eventVo);
	}
	
	@Override
	public String event_set_datetime_d() {
		return eventDao.event_set_datetime_d();
	}
	
	@Override
	public EventVo event_set_victory_team(EventVo eventVo) {
		return eventDao.event_set_victory_team(eventVo);
	}
	
	@Override
	public int event_set_betting_sum(EventVo eventVo) {
		return eventDao.event_set_betting_sum(eventVo);
	}
	
	@Override
	public EventVo event_set_betting_sum_u(EventVo eventVo) {
		return eventDao.event_set_betting_sum_u(eventVo);
	}
	
	@Override
	public int event_set_b_person(EventVo eventVo) {
		return eventDao.event_set_b_person(eventVo);
	}
	
	@Override
	public EventVo event_set_b_person_u(EventVo eventVo) { // b_person??? ??????
		return eventDao.event_set_b_person_u(eventVo);
	}
	
	@Override
	public String event_set_b_person_team_a(EventVo eventVo) { // a?????? ??????
		return eventDao.event_set_b_person_team_a(eventVo);
	}
	
	@Override
	public String event_set_b_person_team_b(EventVo eventVo) { // b?????? ??????
		return eventDao.event_set_b_person_team_b(eventVo);
	}
	
	@Override
	public int event_set_b_person_a(EventVo eventVo) { // a ????????? ?????? ???
		return eventDao.event_set_b_person_a(eventVo);
	}
	
	@Override
	public int event_set_b_person_b(EventVo eventVo) { // b ????????? ?????? ???
		return eventDao.event_set_b_person_b(eventVo);
	}
	
	@Override
	public EventVo event_set_b_percent_a(EventVo eventVo) { // a?????? ?????????
		return eventDao.event_set_b_percent_a(eventVo);
	}
	
	@Override
	public EventVo event_set_b_percent_b(EventVo eventVo) { // b?????? ?????????
		return eventDao.event_set_b_percent_b(eventVo);
	}
	
	@Override
	public int event_set_v_person(EventVo eventVo) { // ???????????? ????????? ?????? ???
		return eventDao.event_set_v_person(eventVo);
	}
	
	@Override
	public EventVo event_set_v_person_c(EventVo eventVo) { // ???????????? ????????? ?????? ??? ??????
		return eventDao.event_set_v_person_c(eventVo);
	}
	
	@Override
	public int event_set_betting_sum_a(EventVo eventVo) { // a?????? ?????? ????????? ???
		return eventDao.event_set_betting_sum_a(eventVo);
	}
	
	@Override
	public int event_set_betting_sum_b(EventVo eventVo) { // b?????? ?????? ????????? ???
		return eventDao.event_set_betting_sum_b(eventVo);
	}
	
	@Override
	public EventVo event_set_point_a(EventVo eventVo) { // ?????? ????????? ?????? a
		return eventDao.event_set_point_a(eventVo);
	}
	
	@Override
	public EventVo event_set_point_b(EventVo eventVo) { // ?????? ????????? ?????? b
		return eventDao.event_set_point_b(eventVo);
	}
	
	@Override
	public EventVo event_set_point(EventVo eventVo) { // ????????? ??????
		return eventDao.event_set_point(eventVo);
	}
	
	@Override
	public String event_end_a() { // ????????? ?????? ?????? ????????? ?????? ??????
		return eventDao.event_end_a();
	}
	
	@Override
	public int event_end_b1(EventVo eventVo) { // ????????? ?????? ?????? ????????? null ??????
		return eventDao.event_end_b1(eventVo);
	}
	
	@Override
	public int event_end_b2(EventVo eventVo) { // ????????? ?????? ?????? ????????? null ??????
		return eventDao.event_end_b2(eventVo);
	}

	@Override
	public String event_end_c() { // ????????? ??????
		return eventDao.event_end_c();
	}
	
	/* @Override
	public List<EventVo> temp(EventVo eventVo) { // ??????
		return eventDao.temp(eventVo);
	}*/
	
	
}
