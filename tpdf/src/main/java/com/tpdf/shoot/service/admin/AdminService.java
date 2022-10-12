package com.tpdf.shoot.service.admin;

import com.tpdf.shoot.vo.AdminVo;

public interface AdminService {
	
	default int admin_point_check(AdminVo adminVo) {
		return 0;
	}
	
	default AdminVo admin_point(AdminVo adminVo) {
		return null;
	}

}
