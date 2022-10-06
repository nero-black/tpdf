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
	public MemberVo login_check(MemberVo memberVo) {
		return memberDao.login_check(memberVo);
	}
	
	
	
	@Override
	public int join_process(MemberVo memberVo) {
		return memberDao.join_process(memberVo);
	}

}
