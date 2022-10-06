package com.tpdf.shoot.service.member;

import java.util.List;

import com.tpdf.shoot.vo.MemberVo;

public interface MemberService {
	
	default MemberVo login_check(MemberVo memberVo) {
		return null;
	}

}
