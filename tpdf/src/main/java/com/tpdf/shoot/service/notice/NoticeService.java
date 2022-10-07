package com.tpdf.shoot.service.notice;

import java.util.List;
import com.tpdf.shoot.vo.NoticeVo;
public interface NoticeService {
	//게시물 목록
	public List<NoticeVo> list() throws Exception;
	
	//게시물 작성
	public void write(NoticeVo vo) throws Exception;
	//게시물 조회
	public NoticeVo view(int notice_idx) throws Exception;
	//게시물 수정 
	public void modify(NoticeVo vo) throws Exception;
	//게시물 삭제
	public void delete(int notice_idx) throws Exception;
	// 게시물 총 갯수
	public int count() throws Exception;
	// 게시물 목록 + 페이징
	public List<NoticeVo> listPage(int displayPost, int postNum) throws Exception;
	// 게시물 목록 + 페이징 + 검색
	public List<NoticeVo> listPageSearch(
	  int displayPost, int postNum, String searchType, String keyword) throws Exception;
	// 게시물 총 갯수 + 검색 적용
	public int searchCount(String searchType, String keyword) throws Exception;
}
