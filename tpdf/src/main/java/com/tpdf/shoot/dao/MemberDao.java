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
	
	public int id_check(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".id_check", memberVo);
		}
	
	public int name_check(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".name_check", memberVo);
		}
	
	public int join_process(MemberVo memberVo) {
		return sqlSession.insert(MAPPER+".join_process", memberVo);
		}
	
	public int find_id1(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".find_id1", memberVo);
		}
	
	public String find_id2(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".find_id2", memberVo);
		}
	
	public int find_pw1(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".find_pw1", memberVo);
		}
	
	public String find_pw2(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".find_pw2", memberVo);
		}
	
	public String find_pw3(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".find_pw3", memberVo);
		}
	
	public int find_pw4(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".find_pw4", memberVo);
		}
	
	public String find_pw5(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".find_pw5", memberVo);
		}
	
	public MemberVo login_check(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".login_check", memberVo);
		}
	
	public int drop_check(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".drop_check", memberVo);
		}
	
	public int member_check(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".member_check", memberVo);
		}
	
	public MemberVo member_info(int member_idx) {
		return sqlSession.selectOne(MAPPER+".member_info", member_idx);
		}
	
	public MemberVo member_modify(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".member_modify", memberVo);
		}
	
	public MemberVo member_drop(MemberVo memberVo) {
		return sqlSession.selectOne(MAPPER+".member_drop", memberVo);
		}
	
	

	

}
