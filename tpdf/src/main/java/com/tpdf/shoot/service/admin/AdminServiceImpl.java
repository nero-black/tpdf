package com.tpdf.shoot.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpdf.shoot.dao.AdminDao;
import com.tpdf.shoot.vo.AdminVo;

@Service("a_service")
public class AdminServiceImpl implements AdminService {
	
	private AdminDao adminDao;
	
	@Autowired(required = false)
	public AdminServiceImpl(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	
	// ----- ----- ----- ----- -----
	
	@Override
	public int admin_point_check(AdminVo adminVo) {
		return adminDao.admin_point_check(adminVo);
	}
	
	@Override
	public AdminVo admin_point(AdminVo adminVo) {
		return adminDao.admin_point(adminVo);
	}

}
