package com.tpdf.shoot.service.notice;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tpdf.shoot.dao.NoticeDAO;
import com.tpdf.shoot.util.FileUtil;
import com.tpdf.shoot.util.FileUtil2;
import com.tpdf.shoot.vo.NoticeVo;
import com.tpdf.shoot.vo.SearchCriteria;
@Service
public class NoticeServiceImpl implements NoticeService {

	@Resource(name="fileUtil")
	private FileUtil fileUtil;
	@Resource(name="fileUtil2")
	private FileUtil2 fileUtil2;
	
	@Inject
	private NoticeDAO dao;
	
	// 게시글 작성
	@Override
	public void write(NoticeVo noticeVo, MultipartHttpServletRequest mpRequest) throws Exception {
		dao.write(noticeVo);
		
		List<Map<String,Object>> list = fileUtil2.parseInsertFileInfo2(noticeVo, mpRequest); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			dao.insertFile(list.get(i)); 
		}
	}
	// 게시물 목록 조회
	@Override
	public List<NoticeVo> list(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(scri);
	}
	
	//게시물 수정
	@Override
	public void update(NoticeVo noticeVo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(noticeVo);
	}
	//게시물 삭제
	@Override
	public void delete(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(notice_idx);
	}
	// 게시물 조회
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public NoticeVo read(int notice_idx) throws Exception {
				dao.noticeHit(notice_idx);
			return dao.read(notice_idx);
	}
	//게시물 총 개수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount(scri);
	}
	
	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int notice_idx) throws Exception {
			// TODO Auto-generated method stub
			return dao.selectFileList(notice_idx);
	}
	/*
	 * // 첨부파일 다운로드
	 * 
	 * @Override public Map<String, Object> selectFileInfo(Map<String, Object> map)
	 * throws Exception { // TODO Auto-generated method stub return
	 * dao.selectFileInfo(map); }
	 */



}
