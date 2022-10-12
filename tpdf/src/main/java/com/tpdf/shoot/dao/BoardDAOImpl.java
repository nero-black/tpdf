package com.tpdf.shoot.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tpdf.shoot.vo.BoardVo;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	//게시물 작성
	@Override
	public void write(BoardVo boardVo) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVo);
		
	}
	//게시물 목록
	@Override
	public List<BoardVo> list() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.list");
	}
	//게시물 조회
	@Override
	public BoardVo read(int board_idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.read", board_idx);
	}
	//게시물 수정
	@Override
	public void update(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("boardMapper.update", boardVo);
		
	}
	//게시물 삭제
	@Override
	public void delete(int board_idx) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("boardMapper.delete", board_idx);
	}
	

}
