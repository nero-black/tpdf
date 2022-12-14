package com.tpdf.shoot.service.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpdf.shoot.dao.VideoDao;
import com.tpdf.shoot.vo.VideoVo;

@Service("v_service") // 해당 클래스를 루트 컨테이너에 빈(Bean)객체로 생성해주는 어노테이션
// @jnject (미사용) 자동 의존성 주입

public class VideoServiceImpl implements VideoService {
	// videoListService -> videoServiceImpl권장
	private VideoDao videoDao;

	@Autowired(required = false)
	public VideoServiceImpl(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
	@Override
	public List<VideoVo> video_list_index() {

		return videoDao.video_list_index();
	}

	@Override
	public List<VideoVo> video_list() {

		return videoDao.video_list();
	}
	
	@Override
	public List<VideoVo> video_search(String search_value) {

		return videoDao.video_search(search_value);
	}

	@Override
	public int video_insert(VideoVo videoVo) {
		return videoDao.video_insert(videoVo);
	}

	@Override
	public VideoVo video_view(int video_idx) {

		return videoDao.video_view(video_idx);
	}
	
	@Override
	public VideoVo video_view_hit(int video_idx) {

		return videoDao.video_view_hit(video_idx);
	}
	
	@Override
	public VideoVo video_modify(int video_idx) {

		return videoDao.video_modify(video_idx);
	}
	
	@Override
	public VideoVo video_modify_process(VideoVo videoVo) {

		return videoDao.video_modify_process(videoVo);
	}
	
	@Override
	public VideoVo video_delete(int video_idx) {

		return videoDao.video_delete(video_idx);
	}
	
	

}
