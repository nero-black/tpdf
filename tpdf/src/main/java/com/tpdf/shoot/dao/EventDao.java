package com.tpdf.shoot.dao;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartRequest;
import com.tpdf.shoot.vo.EventVo;

@Repository
public class EventDao {
	
	SqlSession sqlSession;
		
	private final String MAPPER = "com.tpdf.shoot.service.event";
		
	@Autowired(required=false)
	public EventDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		}
		
	public List<EventVo> event_list() {
		return sqlSession.selectList(MAPPER+".event_list");
		}
	
	public EventVo event_now() {
		return sqlSession.selectOne(MAPPER+".event_now"); // 값이 하나일 때(리스트가 아닐 때)는 selectOne을 해주어야 한다.
		}

	public int event_add(EventVo eventVo) {
		return sqlSession.insert(MAPPER+".event_add", eventVo);
		}
	
	public int member_point(int member_idx) {
		// System.out.println("DAO: "+member_idx);
		return sqlSession.selectOne(MAPPER+".member_point", member_idx);
		}
	
	public int event_betting_c(int member_idx) {
		return sqlSession.selectOne(MAPPER+".event_betting_c", member_idx);
		}
	
	public String event_betting_i(int member_idx) {
		return sqlSession.selectOne(MAPPER+".event_betting_i", member_idx);
		}
		
	public int event_betting_i(EventVo eventVo) {
		return sqlSession.insert(MAPPER+".event_betting_i", eventVo);
		}
	
	public EventVo event_betting_u(EventVo eventVo) {
		// System.out.println("member_idx: "+eventVo.getMember_idx());
		// System.out.println("betting_team: "+eventVo.getBetting_team());
		// System.out.println("b_Point: "+eventVo.getB_point());
		// System.out.println("member_point: "+eventVo.getMember_point());
		
		return sqlSession.selectOne(MAPPER+".event_betting_u", eventVo); // update와 delete에도 selectOne이 사용됨
		}
	
	public int event_betting_stop_c() {
		return sqlSession.selectOne(MAPPER+".event_betting_stop_c");
		}
	
	public EventVo event_stop(EventVo eventVo) {
		return sqlSession.selectOne(MAPPER+".event_stop", eventVo);
		}
	
	public int event_calc_sum() {
		return sqlSession.selectOne(MAPPER+".event_calc_sum");
		}
	
	public float event_calc_percent_a() {
		return sqlSession.selectOne(MAPPER+".event_calc_percent_a");
		}
	
	public float event_calc_percent_b() {
		return sqlSession.selectOne(MAPPER+".event_calc_percent_b");
		}
	
	public int event_set_datetime_a() {
		return sqlSession.insert(MAPPER+".event_set_datetime_a");
		}

	public String event_set_datetime_b() {
		return sqlSession.selectOne(MAPPER+".event_set_datetime_b");
		}
	
	public EventVo event_set_datetime_c(EventVo eventVo) {
		return sqlSession.selectOne(MAPPER+".event_set_datetime_c", eventVo);
		}
	
	public String event_set_datetime_d() {
		return sqlSession.selectOne(MAPPER+".event_set_datetime_d");
		}
	
	public EventVo event_set_victory_team(EventVo eventVo) {
		return sqlSession.selectOne(MAPPER+".event_set_victory_team", eventVo);
		}
	
	public int event_set_betting_sum(EventVo eventVo) {
		return sqlSession.selectOne(MAPPER+".event_set_betting_sum", eventVo);
		}
	
	public EventVo event_set_betting_sum_u(EventVo eventVo) {
		return sqlSession.selectOne(MAPPER+".event_set_betting_sum_u", eventVo);
		}
	
	public int event_set_b_person(EventVo eventVo) {
		return sqlSession.selectOne(MAPPER+".event_set_b_person", eventVo);
		}
	
	public EventVo event_set_b_person_u(EventVo eventVo) { // b_person값 갱신
		return sqlSession.selectOne(MAPPER+".event_set_b_person_u", eventVo);
		}
	
	public String event_set_b_person_team_a(EventVo eventVo) { // a종목 이름
		return sqlSession.selectOne(MAPPER+".event_set_b_person_team_a", eventVo);
		}
	
	public String event_set_b_person_team_b(EventVo eventVo) { // b종목 이름
		return sqlSession.selectOne(MAPPER+".event_set_b_person_team_b", eventVo);
		}
	
	public int event_set_b_person_a(EventVo eventVo) { // a 선택한 사람 수
		return sqlSession.selectOne(MAPPER+".event_set_b_person_a", eventVo);
		}
	
	public int event_set_b_person_b(EventVo eventVo) { // b 선택한 사람 수
		return sqlSession.selectOne(MAPPER+".event_set_b_person_b", eventVo);
		}
	
	public EventVo event_set_b_percent_a(EventVo eventVo) { // a종목 배당률 적용
		return sqlSession.selectOne(MAPPER+".event_set_b_percent_a", eventVo);
		}
	
	public EventVo event_set_b_percent_b(EventVo eventVo) { // b종목 배당률 적용
		return sqlSession.selectOne(MAPPER+".event_set_b_percent_b", eventVo);
		}
	
	public int event_set_v_person(EventVo eventVo) { // 승리팀을 선택한 사람 수
		return sqlSession.selectOne(MAPPER+".event_set_v_person", eventVo);
		}
	
	public EventVo event_set_v_person_c(EventVo eventVo) { // 승리팀을 선택한 사람 수 적용
		return sqlSession.selectOne(MAPPER+".event_set_v_person_c", eventVo);
		}
	
	public int event_set_betting_sum_a(EventVo eventVo) {
		return sqlSession.selectOne(MAPPER+".event_set_betting_sum_a", eventVo);
		}
	
	public int event_set_betting_sum_b(EventVo eventVo) {
		return sqlSession.selectOne(MAPPER+".event_set_betting_sum_b", eventVo);
		}
	
	public EventVo event_set_point_a(EventVo eventVo) { // 개인 배당률 적용 a
		return sqlSession.selectOne(MAPPER+".event_set_point_a", eventVo);
		}
	
	public EventVo event_set_point_b(EventVo eventVo) { // 개인 배당률 적용 b
		return sqlSession.selectOne(MAPPER+".event_set_point_b", eventVo);
		}
	
	public EventVo event_set_point(EventVo eventVo) { // 포인트 지급
		return sqlSession.selectOne(MAPPER+".event_set_point", eventVo);
		}
	
	public String event_end_a() { // 이벤트 참가 회원 테이블 내용 삭제
		return sqlSession.selectOne(MAPPER+".event_end_a");
		}
	
	public int event_end_b1(EventVo eventVo) { // 이벤트 참가 회원 테이블 null 방지1
		return sqlSession.insert(MAPPER+".event_end_b1", eventVo);
		}
	
	public int event_end_b2(EventVo eventVo) { // 이벤트 참가 회원 테이블 null 방지2
		return sqlSession.insert(MAPPER+".event_end_b2", eventVo);
		}
	
	public String event_end_c() { // 이벤트 종료
		return sqlSession.selectOne(MAPPER+".event_end_c");
		}
	
	/* public List<EventVo> temp(EventVo eventVo) { // 임시
		return sqlSession.selectList(MAPPER+".temp", eventVo);
		} */
	

	

}
