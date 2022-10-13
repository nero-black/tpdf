package com.tpdf.shoot.service.admin;

import java.util.List;

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
	
	@Override
	public List<AdminVo> member_list() {
		return adminDao.member_list();
	}
	
	@Override
	public List<AdminVo> member_search_id(String search_value) {
		return adminDao.member_search_id(search_value);
	}
	
	@Override
	public List<AdminVo> member_search_name(String search_value) {
		return adminDao.member_search_name(search_value);
	}
	
	@Override
	public int admin_ban_check(int member_idx) {
		return adminDao.admin_ban_check(member_idx);
	}
	
	@Override
	public int admin_ban_process(int member_idx) {
		return adminDao.admin_ban_process(member_idx);
	}
	
	

}
