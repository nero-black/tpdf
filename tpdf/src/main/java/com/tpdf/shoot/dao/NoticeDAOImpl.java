package com.tpdf.shoot.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tpdf.shoot.vo.NoticeVo;
@Repository
public class NoticeDAOImpl implements NoticeDAO {
	
	 @Inject
	 private SqlSession sql;
	 
	 private static String namespace = "com.tpdf.shoot.vo.NoticeVo";
	
	
	
	//게시물목록
	@Override
	public List<NoticeVo> list() throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList(namespace+".list");
	}


	//게시물 작성
	
	@Override
	public void write(NoticeVo vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert(namespace + ".write", vo);
	}


	@Override
	public NoticeVo view(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne(namespace + ".view", notice_idx);
	}


	@Override
	public void modify(NoticeVo vo) throws Exception {
		// TODO Auto-generated method stub
		sql.update(namespace+ ".modify", vo);
		
	}


	@Override
	public void delete(int notice_idx) throws Exception {
		// TODO Auto-generated method stub
		sql.delete(namespace + ".delete", notice_idx);
	}


	// 게시물 총 갯수
	@Override
	public int count() throws Exception {
	 return sql.selectOne(namespace + ".count"); 
	}

	// 게시물 목록 + 페이징
	@Override
	public List<NoticeVo> listPage(int displayPost, int postNum) throws Exception {

	 HashMap<String, Integer> data = new HashMap<String, Integer>();
	  
	 data.put("displayPost", displayPost);
	 data.put("postNum", postNum);
	  
	 return sql.selectList(namespace + ".listPage", data);
	}
	
	// 게시물 목록 + 페이징 + 검색
	 @Override
	 public List<NoticeVo> listPageSearch(
	   int displayPost, int postNum, String searchType, String keyword) throws Exception {

	  HashMap<String, Object> data = new HashMap<String, Object>();
	  
	  data.put("displayPost", displayPost);
	  data.put("postNum", postNum);
	  
	  data.put("searchType", searchType);
	  data.put("keyword", keyword);
	  
	  return sql.selectList(namespace + ".listPageSearch", data);
	 }
	 
	// 게시물 총 갯수 + 검색 적용
	 @Override
	 public int searchCount(String searchType, String keyword) throws Exception {
	  
	  HashMap<String, Object> data = new HashMap<String, Object>();
	  
	  data.put("searchType", searchType);
	  data.put("keyword", keyword);
	  
	  return sql.selectOne(namespace + ".searchCount", data); 
	 }
}
