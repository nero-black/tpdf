package com.tpdf.shoot.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartRequest;
import com.tpdf.shoot.vo.VideoVo;

@Repository
public class VideoDao {
	
	SqlSession sqlSession;
		
	private final String MAPPER = "com.tpdf.shoot.service.video";
		
	@Autowired(required=false)
	public VideoDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		}
	
	public List<VideoVo> video_list_index() {
		return sqlSession.selectList(MAPPER+".video_list_index");
	}
		
	public List<VideoVo> video_list() {
		// System.out.println("videoList: "+sqlSession.selectList(MAPPER+".video_list"));
		return sqlSession.selectList(MAPPER+".video_list");
		}
	
	public List<VideoVo> video_search(String search_value) {
		search_value = "%"+search_value+"%";
		// System.out.println("최종값: "+search_value);
		return sqlSession.selectList(MAPPER+".video_search", search_value);
	}
	
	public VideoVo video_view(int video_idx) {
		return sqlSession.selectOne(MAPPER+".video_one", video_idx);
		}
	
	public VideoVo video_view_hit(int video_idx) {
		return sqlSession.selectOne(MAPPER+".video_view_hit", video_idx);
		}

	public int video_insert(VideoVo videoVo) {
		return sqlSession.insert(MAPPER+".video_insert", videoVo);
		}
	
	public VideoVo video_modify(int video_idx) {
		return sqlSession.selectOne(MAPPER+".video_modify", video_idx);
		}

	public VideoVo video_modify_process(VideoVo videoVo) {
		return sqlSession.selectOne(MAPPER+".video_modify_process", videoVo);
		}
	
	public VideoVo video_delete(int video_idx) {
		return sqlSession.selectOne(MAPPER+".video_delete", video_idx);
		}


}
