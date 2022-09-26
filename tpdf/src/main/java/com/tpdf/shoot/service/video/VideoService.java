package com.tpdf.shoot.service.video;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.tpdf.shoot.vo.VideoVo;

public interface VideoService {
	
	default List<VideoVo> video_list_index() {
		return null;
	};
	
	default List<VideoVo> video_list() {
		return null;
	}
	
	default List<VideoVo> video_search(String search_value) {
		return null;
	}
	
	default int video_insert(VideoVo videoVo) {
		return 0;
	}
	
	default VideoVo video_view(int video_idx) {
		return null;
	}
	
	default VideoVo video_view_hit(int video_idx) {
		return null;
	}
	
	default VideoVo video_modify(int video_idx) {
		return null;
	}
	
	default VideoVo video_modify_process(VideoVo videoVo) {
		return null;
	}

	default VideoVo video_delete(int video_idx) {
		return null;
	}
	
}
