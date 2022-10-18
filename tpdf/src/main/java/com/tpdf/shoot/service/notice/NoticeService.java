package com.tpdf.shoot.service.notice;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tpdf.shoot.vo.NoticeVo;
import com.tpdf.shoot.vo.SearchCriteria;

public interface NoticeService {
	// 인덱스 게시물 목록 조회
	public List<NoticeVo> list2(SearchCriteria scri) throws Exception;
	//게시글작성
	public void write(NoticeVo noticeVo, MultipartHttpServletRequest mpRequest) throws Exception;
	// 게시물 목록 조회
	public List<NoticeVo> list(SearchCriteria scri) throws Exception;
	// 게시물 조회
	public NoticeVo read(int notice_idx) throws Exception;
	// 게시물 수정
	public void update(NoticeVo noticeVo) throws Exception;
	// 게시물 총갯수
	public int listCount(SearchCriteria scri) throws Exception;
	// 게시물 삭제
	public void delete(int notice_idx) throws Exception;

	// 첨부파일 조회
	public List<Map<String, Object>> selectFileList(int notice_idx) throws Exception;
	/*
	 * // 첨부파일 다운' public Map<String, Object> selectFileInfo(Map<String, Object>
	 * map) throws Exception;
	 */


}
