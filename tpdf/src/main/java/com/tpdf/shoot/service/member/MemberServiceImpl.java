package com.tpdf.shoot.service.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpdf.shoot.dao.MemberDao;
import com.tpdf.shoot.vo.MemberVo;

@Service("m_service")
public class MemberServiceImpl implements MemberService {
	
	private MemberDao memberDao;
	
	@Autowired(required = false)
	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	// -------------------------
	
	@Override
	public int id_check(MemberVo memberVo) {
		return memberDao.id_check(memberVo);
	}
	
	@Override
	public int name_check(MemberVo memberVo) {
		return memberDao.name_check(memberVo);
	}
	
	@Override
	public int join_process(MemberVo memberVo) {
		return memberDao.join_process(memberVo);
	}
	
	@Override
	public int find_id1(MemberVo memberVo) {
		return memberDao.find_id1(memberVo);
	}
	
	@Override
	public String find_id2(MemberVo memberVo) {
		return memberDao.find_id2(memberVo);
	}
	
	@Override
	public int find_pw1(MemberVo memberVo) {
		return memberDao.find_pw1(memberVo);
	}
	
	@Override
	public String find_pw2(MemberVo memberVo) {
		return memberDao.find_pw2(memberVo);
	}
	
	@Override
	public String find_pw3(MemberVo memberVo) {
		return memberDao.find_pw3(memberVo);
	}
	
	@Override
	public int find_pw4(MemberVo memberVo) {
		return memberDao.find_pw4(memberVo);
	}
	
	@Override
	public String find_pw5(MemberVo memberVo) {
		return memberDao.find_pw5(memberVo);
	}
	
	@Override
	public int member_point(MemberVo memberVo) {
		return memberDao.member_point(memberVo);
	}
	
	@Override
	public MemberVo login_check(MemberVo memberVo) {
		return memberDao.login_check(memberVo);
	}
	
	@Override
	public int drop_check(MemberVo memberVo) {
		return memberDao.drop_check(memberVo);
	}
	
	@Override
	public int member_check(MemberVo memberVo) {
		return memberDao.member_check(memberVo);
	}
	
	@Override
	public MemberVo member_info(int member_idx) {
		return memberDao.member_info(member_idx);
	}
	
	@Override
	public MemberVo member_modify(MemberVo memberVo) {
		return memberDao.member_modify(memberVo);
	}
	
	@Override
	public MemberVo member_drop(MemberVo memberVo) {
		return memberDao.member_drop(memberVo);
	}

}
