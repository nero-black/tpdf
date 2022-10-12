package com.tpdf.shoot.service.board;

import java.util.List;

import com.tpdf.shoot.vo.BoardVo;

public interface BoardService {
	//게시글작성
	public void write(BoardVo boardVo) throws Exception;
	
	// 게시물 목록 조회
	public List<BoardVo> list() throws Exception;
	// 게시물 조회
	public BoardVo read(int board_idx) throws Exception;
	// 게시물 수정
	public void update(BoardVo boardVo) throws Exception;
		
	// 게시물 삭제
	public void delete(int board_idx) throws Exception;


	


}
