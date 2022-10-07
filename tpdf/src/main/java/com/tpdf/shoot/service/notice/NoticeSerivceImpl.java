package com.tpdf.shoot.service.notice;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.tpdf.shoot.vo.NoticeVo;
import com.tpdf.shoot.dao.NoticeDAO;

@Service
public class NoticeSerivceImpl implements NoticeService {
	
	@Inject	
	private NoticeDAO dao;
	
	@Override
	public List<NoticeVo> list() throws Exception{
		return dao.list();
	}

	@Override
	public void write(NoticeVo vo) throws Exception {
		// TODO Auto-generated method stub
		dao.write(vo);
	}

	@Override
	public NoticeVo view(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.view(notice_idx);
	}

	@Override
	public void modify(NoticeVo vo) throws Exception {
		// TODO Auto-generated method stub
		dao.modify(vo);
		
	}

	@Override
	public void delete(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(notice_idx);
		
	}
	// 게시물 총 갯수
	@Override
	public int count() throws Exception {
	 return dao.count();
	}
	
	// 게시물 목록 + 페이징
	@Override
	public List<NoticeVo> listPage(int displayPost, int postNum) throws Exception {
	 return dao.listPage(displayPost, postNum);
	}
	// 게시물 목록 + 페이징 + 검색
	@Override
	public List<NoticeVo> listPageSearch(
	  int displayPost, int postNum, String searchType, String keyword) throws Exception {
	 return  dao.listPageSearch(displayPost, postNum, searchType, keyword);
	}
	// 게시물 총 갯수
	@Override
	public int searchCount(String searchType, String keyword) throws Exception {
	 return dao.searchCount(searchType, keyword);
	}
}
