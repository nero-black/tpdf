package com.tpdf.shoot.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tpdf.shoot.dao.BoardDAO;
import com.tpdf.shoot.vo.BoardVo;
@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;
	
	// 게시글 작성
	@Override
	public void write(BoardVo boardVo) throws Exception {
		dao.write(boardVo);
	}
	// 게시물 목록 조회
	@Override
	public List<BoardVo> list() throws Exception {
		// TODO Auto-generated method stub
		return dao.list();
	}
	//게시물 수정
	@Override
	public void update(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(boardVo);
	}
	//게시물 삭제
	@Override
	public void delete(int board_idx) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(board_idx);
	}
	//게시물 조회
	@Override
	public BoardVo read(int board_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(board_idx);
	}



}
