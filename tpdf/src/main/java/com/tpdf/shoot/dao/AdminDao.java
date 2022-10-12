package com.tpdf.shoot.dao;

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

	

}
