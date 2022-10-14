package com.tpdf.shoot.dao;

import java.util.List;
import java.util.Map;


import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tpdf.shoot.vo.NoticeVo;
import com.tpdf.shoot.vo.SearchCriteria;

@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	@Inject
	private SqlSession sqlSession;
	//게시물작성
	@Override
	public void write(NoticeVo noticeVo) throws Exception {
		sqlSession.insert("noticeMapper.insert", noticeVo);
	}
	//게시물 목록
	@Override
	public List<NoticeVo> list(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("noticeMapper.listPage", scri);
	}
	

	//게시물 수정
	@Override
	public void update(NoticeVo noticeVo) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("noticeMapper.update", noticeVo);
		
	}
	//게시물 삭제
	@Override
	public void delete(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("noticeMapper.delete", notice_idx);
	}
	//게시물 총 갯수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("noticeMapper.listCount", scri);
	}
	//게시물 조회
	@Override
	public NoticeVo read(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("noticeMapper.read", notice_idx);
		
		
	}
	
	// 첨부파일 업로드
	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
			// TODO Auto-generated method stub
			sqlSession.insert("noticeMapper.insertFile", map);
	}
	
  
   	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("noticeMapper.selectFileList", notice_idx);
	}
	//게시물 조회수
	@Override
	public void noticeHit(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("noticeMapper.noticeHit", notice_idx);
	}
	
	/*
	 * // 첨부파일 다운로드
	 * 
	 * @Override public Map<String, Object> selectFileInfo(Map<String, Object> map)
	 * throws Exception { // TODO Auto-generated method stub return
	 * sqlSession.selectOne("boticeMapper.selectFileInfo", map); }
	 */
	/*
	 * //첨부파일 수정
	 * 
	 * @Override public void updateFile(Map<String, Object> map) throws Exception {
	 * // TODO Auto-generated method stub
	 * 
	 * sqlSession.update("boticeMapper.updateFile", map); }
	 */
}
