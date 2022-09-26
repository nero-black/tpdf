package com.tpdf.shoot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tpdf.shoot.service.video.VideoService;
import com.tpdf.shoot.vo.VideoVo;

@Controller
public class MainController {
	
	private VideoService videoService;

	@Autowired(required = false)
	public void setVideoService(@Qualifier("v_service") VideoService videoService) { // void setVideoServie <<impl을 쓰는한 이름 딱히 상관x?
		this.videoService = videoService;
	}
	
	@GetMapping("/")
	public String index(Model model) {
		List<VideoVo> videoList = videoService.video_list_index();
		model.addAttribute("videoList", videoList);
		return "index";
	}
	
	@GetMapping("/index.do")
	public String index2(Model model) {
		List<VideoVo> videoList = videoService.video_list_index();
		model.addAttribute("videoList", videoList);
		return "index";
	}
	
}
