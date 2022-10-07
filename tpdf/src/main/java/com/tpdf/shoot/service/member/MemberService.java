package com.tpdf.shoot.service.member;

import java.util.List;

import com.tpdf.shoot.vo.MemberVo;

public interface MemberService {
	
	default MemberVo login_check(MemberVo memberVo) {
		return null;
	}
	
	
	
	default int id_check(MemberVo memberVo) {
		return 0;
	}
	
	default int join_process(MemberVo memberVo) {
		return 0;
	}

}
