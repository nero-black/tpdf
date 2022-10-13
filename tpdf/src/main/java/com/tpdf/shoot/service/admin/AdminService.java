package com.tpdf.shoot.service.admin;

import java.util.List;

import com.tpdf.shoot.vo.AdminVo;

public interface AdminService {
	
	default int admin_point_check(AdminVo adminVo) {
		return 0;
	}
	
	default AdminVo admin_point(AdminVo adminVo) {
		return null;
	}
	
	default List<AdminVo> member_list() {
		return null;
	}
	
	default List<AdminVo> member_search_id(String search_value) {
		return null;
	}
	
	default List<AdminVo> member_search_name(String search_value) {
		return null;
	}
	
	default int admin_ban_check(int member_idx) {
		return 0;
	}
	
	default int admin_ban_process(int member_idx) {
		return 0;
	}

}
