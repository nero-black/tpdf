package com.tpdf.shoot.dao;

import java.util.List;
import java.util.Map;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tpdf.shoot.vo.BoardVo;
import com.tpdf.shoot.vo.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	//인덱스 보
	@Override
		public List<BoardVo> blist(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
			return sqlSession.selectList("mainMapper.blist", scri);
	}
	//게시물작성
	@Override
	public void write(BoardVo boardVo) throws Exception {
		sqlSession.insert("boardMapper.insert", boardVo);
	}
	//게시물 목록
	@Override
	public List<BoardVo> list(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.listPage", scri);
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
	//게시물 총 갯수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.listCount", scri);
	}
	//게시물 조회
	@Override
	public BoardVo read(int board_idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.read", board_idx);
		
		
	}
	
	// 첨부파일 업로드
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
			// TODO Auto-generated method stub
			sqlSession.insert("boardMapper.insertFile", map);
	}
	
  
   	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int board_idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("boardMapper.selectFileList", board_idx);
	}
	//게시물 조회수
	@Override
	public void boardHit(int board_idx) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("boardMapper.boardHit", board_idx);
	}
	
	/*
	 * // 첨부파일 다운로드
	 * 
	 * @Override public Map<String, Object> selectFileInfo(Map<String, Object> map)
	 * throws Exception { // TODO Auto-generated method stub return
	 * sqlSession.selectOne("boardMapper.selectFileInfo", map); }
	 */
	/*
	 * //첨부파일 수정
	 * 
	 * @Override public void updateFile(Map<String, Object> map) throws Exception {
	 * // TODO Auto-generated method stub
	 * 
	 * sqlSession.update("boardMapper.updateFile", map); }
	 */
}
