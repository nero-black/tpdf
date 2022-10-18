package com.tpdf.shoot.dao;

import java.util.List;
import java.util.Map;

import com.tpdf.shoot.vo.NoticeVo;
import com.tpdf.shoot.vo.SearchCriteria;

public interface NoticeDAO {
	// 인덱스 게시물
	public List<NoticeVo> list2(SearchCriteria scri) throws Exception;
	//게시글 작성
	public void write(NoticeVo noticeVo) throws Exception;
	//게시물 목록 조회
	public List<NoticeVo> list(SearchCriteria scri) throws Exception;
	//게시물 총 갯수
	public int listCount(SearchCriteria scri) throws Exception;
	//게시물 조회
	public NoticeVo read(int notice_idx) throws Exception;
	// 게시물 수정
	public void update(NoticeVo noticeVo) throws Exception;
	// 게시물 삭제
	public void delete(int notice_idx) throws Exception;
	// 첨부파일 업로드
	public void insertFile(Map<String, Object> map) throws Exception;
    // 첨부파일 조회
	public List<Map<String, Object>> selectFileList(int notice_idx) throws Exception;
	// 게시판 조회수
	public void noticeHit(int notice_idx) throws Exception;
	/*
	 * // 첨부파일 다운 public Map<String, Object> selectFileInfo(Map<String, Object> map)
	 * throws Exception;
	 */
	/*
	 * // 첨부파일 수정 public void updateFile(Map<String, Object> map) throws Exception;
	 */
}
