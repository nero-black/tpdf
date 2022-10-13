package com.tpdf.shoot.service.board;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tpdf.shoot.vo.BoardVo;
import com.tpdf.shoot.vo.SearchCriteria;

public interface BoardService {
	//게시글작성
	public void write(BoardVo boardVo, MultipartHttpServletRequest mpRequest) throws Exception;
	// 게시물 목록 조회
	public List<BoardVo> list(SearchCriteria scri) throws Exception;
	// 게시물 조회
	public BoardVo read(int board_idx) throws Exception;
	// 게시물 수정
	public void update(BoardVo boardVo) throws Exception;
	// 게시물 총갯수
	public int listCount(SearchCriteria scri) throws Exception;
	// 게시물 삭제
	public void delete(int board_idx) throws Exception;

	// 첨부파일 조회
	public List<Map<String, Object>> selectFileList(int bno) throws Exception;
	/*
	 * // 첨부파일 다운' public Map<String, Object> selectFileInfo(Map<String, Object>
	 * map) throws Exception;
	 */


}
