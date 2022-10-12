package com.tpdf.shoot.dao;

import java.util.List;

import com.tpdf.shoot.vo.BoardVo;

public interface BoardDAO {
	//게시글 작성
	public void write(BoardVo boardVo) throws Exception;
	// 게시물 목록 조회
	public List<BoardVo> list() throws Exception;
	//게시물 조회
	public BoardVo read(int board_idx) throws Exception;
	// 게시물 수정
	public void update(BoardVo boardVo) throws Exception;
		
	// 게시물 삭제
	public void delete(int board_idx) throws Exception;
}
