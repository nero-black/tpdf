package com.tpdf.shoot.service.member;

import java.util.List;

import com.tpdf.shoot.vo.MemberVo;

public interface MemberService {
	
	default int id_check(MemberVo memberVo) {
		return 0;
	}
	
	default int name_check(MemberVo memberVo) {
		return 0;
	}
	
	default int join_process(MemberVo memberVo) {
		return 0;
	}
	
	default int find_id1(MemberVo memberVo) {
		return 0;
	}
	
	default String find_id2(MemberVo memberVo) {
		return null;
	}
	
	default int find_pw1(MemberVo memberVo) {
		return 0;
	}
	
	default String find_pw2(MemberVo memberVo) {
		return null;
	}
	
	default String find_pw3(MemberVo memberVo) {
		return null;
	}
	
	default int find_pw4(MemberVo memberVo) {
		return 0;
	}
	
	default String find_pw5(MemberVo memberVo) {
		return null;
	}
	
	default MemberVo login_check(MemberVo memberVo) {
		return null;
	}
	
	default int drop_check(MemberVo memberVo) {
		return 0;
	}
	
	default int member_check(MemberVo memberVo) {
		return 0;
	}
	
	default MemberVo member_info(int member_idx) {
		return null;
	}
	
	default MemberVo member_modify(MemberVo memberVo) {
		return null;
	}
	
	default MemberVo member_drop(MemberVo memberVo) {
		return null;
	}

}
