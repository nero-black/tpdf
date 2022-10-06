package com.tpdf.shoot.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tpdf.shoot.vo.MemberVo;

@Repository
public class MemberDao {
	
	SqlSession sqlSession;
		
	private final String MAPPER = "com.tpdf.shoot.service.member";
		
	@Autowired(required=false)
	public MemberDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		}
	
	// -------------------------
		
	public MemberVo login_check(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".login_check", memberVo);
		}
	
	
	
	public int join_process(MemberVo memberVo) {
		return sqlSession.insert(MAPPER+".join_process", memberVo);
		}
	
	

	

}
