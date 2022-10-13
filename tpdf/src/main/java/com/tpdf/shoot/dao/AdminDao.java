package com.tpdf.shoot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tpdf.shoot.vo.AdminVo;

@Repository
public class AdminDao {
	
	SqlSession sqlSession;
	
	private final String MAPPER = "com.tpdf.shoot.service.admin";
		
	@Autowired(required=false)
	public AdminDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		}
	
	// ----- ----- ----- ----- -----
	
	public int admin_point_check(AdminVo adminVo) {
		return sqlSession.selectOne(MAPPER+".admin_point_check", adminVo);
	}
	
	public AdminVo admin_point(AdminVo adminVo) {
		return sqlSession.selectOne(MAPPER+".admin_point", adminVo);
	}
	
	public List<AdminVo> member_list() {
		return sqlSession.selectList(MAPPER+".member_list");
	}
	
	public List<AdminVo> member_search_id(String search_value) {
		return sqlSession.selectList(MAPPER+".member_search_id", search_value);
	}
	
	public List<AdminVo> member_search_name(String search_value) {
		return sqlSession.selectList(MAPPER+".member_search_name", search_value);
	}
	
	public int admin_ban_check(int member_idx) {
		return sqlSession.selectOne(MAPPER+".admin_ban_check", member_idx);
	}
	
	public int admin_ban_process(int member_idx) {
		return sqlSession.update(MAPPER+".admin_ban_process", member_idx);
	}

	

}
