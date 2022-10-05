package com.tpdf.shoot.service.event;

import java.util.Date;
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
	
	default int event_betting_c(int member_idx) {
		return 0;
	}
	
	default int event_betting_i(EventVo eventVo) {
		return 0;
	}
	
	default EventVo event_betting_u(EventVo eventVo) {
		return null;
	}
	
	default int event_betting_stop_c() {
		return 0;
	}
	
	default EventVo event_stop(EventVo eventVo) {
		return null;
	}
	
	default EventVo event_calc_sum() {
		return null;
	}
	
	default EventVo event_calc_percent_a() {
		return null;
	}
	
	default EventVo event_calc_percent_b() {
		return null;
	}
	
	default int event_set_datetime_a() {
		return 0;
	}
	
	default String event_set_datetime_b() { // String을 사용해야 null값을 리턴해 널포인트 익셉션이 나오지 않는다.
		return null;
	}

	default EventVo event_set_datetime_c(EventVo eventVo) {
		return null;
	}
	
	default String event_set_datetime_d() {
		return null;
	}
	
	default EventVo event_set_victory_team(EventVo eventVo) {
		return null;
	}
	
	default int event_set_betting_sum(EventVo eventVo) {
		return 0;
	}
	
	default EventVo event_set_betting_sum_u(EventVo eventVo) {
		return null;
	}
	
	default int event_set_b_person(EventVo eventVo) {
		return 0;
	}
	
	default EventVo event_set_b_person_u(EventVo eventVo) { // b_person값 갱신
		return null;
	}
	
	default String event_set_b_person_team_a(EventVo eventVo) { // a종목 이름
		return null;
	}
	
	default String event_set_b_person_team_b(EventVo eventVo) { // b종목 이름
		return null;
	}
	
	default int event_set_b_person_a(EventVo eventVo) { // a 선택한 사람 수
		return 0;
	}
	
	default int event_set_b_person_b(EventVo eventVo) { // b 선택한 사람 수
		return 0;
	}
	
	default EventVo event_set_b_percent_a(EventVo eventVo) { // a종목 배당률
		return null;
	}
	
	default EventVo event_set_b_percent_b(EventVo eventVo) { // b종목 배당률
		return null;
	}
	
	default int event_set_v_person(EventVo eventVo) { // 승리팀을 선택한 사람 수
		return 0;
	}
	
	default EventVo event_set_v_person_c(EventVo eventVo) { // 승리팀을 선택한 사람 수 적용
		return null;
	}
	
	default int event_set_betting_sum_a(EventVo eventVo) {
		return 0;
	}
	
	default int event_set_betting_sum_b(EventVo eventVo) {
		return 0;
	}
	
	default EventVo event_set_point_a(EventVo eventVo) { // 개인 배당률 적용 a
		return null;
	}
	
	default EventVo event_set_point_b(EventVo eventVo) { // 개인 배당률 적용 b
		return null;
	}
	
	default EventVo event_set_point(EventVo eventVo) { // 포인트 지급
		return null;
	}
	
	default String event_end_a() { // 이벤트 참가 회원 테이블 내용 삭제
		return null;
	}
	
	default int event_end_b1(EventVo eventVo) { // 이벤트 참가 회원 테이블 null 방지
		return 0;
	}

	default int event_end_b2(EventVo eventVo) { // 이벤트 참가 회원 테이블 null 방지
		return 0;
	}
	
	default String event_end_c() { // 이벤트 종료
		return null;
	}
	
	/* default List<EventVo> temp(EventVo eventVo) { //
		return null;
	} */
	
}
