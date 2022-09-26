package com.tpdf.shoot.dao;

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
		
	private final String MAPPER = "com.tpdf.shoot.event";
		
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
	
		/*
		 * public int event_betting_i(EventVo eventVo) { int b_point_i =
		 * Integer.parseInt(EventVo.b_point); // String으로 가져온 파라미터값을 int로 형변환 return
		 * sqlSession.insert(MAPPER+".member_point", eventVo); }
		 */

		/*
		 * public EventVo event_betting_u() { return
		 * sqlSession.u(MAPPER+".member_point"); }
		 */

	
	

}
