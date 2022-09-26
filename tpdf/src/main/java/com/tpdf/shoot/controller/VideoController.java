package com.tpdf.shoot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tpdf.shoot.service.video.VideoService;
import com.tpdf.shoot.vo.VideoVo;

@Controller
public class VideoController {

	private VideoService videoService;

	@Autowired(required = false)
	public void setVideoService(@Qualifier("v_service") VideoService videoService) { // void setVideoServie <<impl을 쓰는한 이름 딱히 상관x?
		this.videoService = videoService;
	}
	
	@GetMapping("/video_list.do")
	public String video(Model model) {
		List<VideoVo> videoList = videoService.video_list();
		model.addAttribute("videoList", videoList);
		return "video/video";
	}
	
	@GetMapping("/video_search.do")
	public String video_search(String search_value, Model model) {
		
		List<VideoVo> videoList = videoService.video_search(search_value);
		model.addAttribute("videoList", videoList);
		
		return "video/video";
	}

	@GetMapping("/video_insert.do")
	public String video_insert() {
		return "video/video_insert";
	}
	
	@PostMapping("/video_insert_process.do")
	public String video_insert_process(VideoVo videoVo, HttpServletRequest request, Model model) {
		
		int result = videoService.video_insert(videoVo);
		
		String video_insert_after = "video/video_insert";
		
		// System.out.println("result: "+result);
		
		if (result == 1) { // 글 작성 성공
			List<VideoVo> videoList = videoService.video_list();
			model.addAttribute("videoList", videoList);
			
			 video_insert_after = "video/video";
		}
		
		return video_insert_after;
	}
	
	@RequestMapping("/video_view.do")
	public String video_view(int video_idx, Model model) {
		videoService.video_view_hit(video_idx); // 조회수 (따로 담지 않고 바로 실행)
		VideoVo videoVo = videoService.video_view(video_idx);
		// System.out.println("videoVo video_idx: "+videoVo.getVideo_idx());
		model.addAttribute("videoVo", videoVo);
		
		return "video/video_view";
	}

	@GetMapping("/video_modify.do")
	public String video_modify(int video_idx, Model model) {
		VideoVo videoVo = videoService.video_modify(video_idx);
		model.addAttribute("videoVo", videoVo);
		return "video/video_modify";
	}

	@PostMapping("/video_modify_process.do")
	public String video_modify_process(VideoVo videoVo, HttpServletRequest request, Model model) {
		videoService.video_modify_process(videoVo); // 글수정
		
		return "video/video_modify_process";
	}

	@GetMapping("/video_delete_process.do")
	public String video_delete_process(int video_idx, Model model) {
		videoService.video_delete(video_idx); // (따로 담지 않고 바로 실행)

		return "video/video_delete_process";
	}

}
