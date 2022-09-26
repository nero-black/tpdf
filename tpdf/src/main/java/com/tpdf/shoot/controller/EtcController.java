package com.tpdf.shoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EtcController {
	
	@GetMapping("/rank.do")
	public String rank() {
		return "etc/rank";
	}
	
	@GetMapping("/schedule.do")
	public String schedule() {
		return "etc/schedule";
	}
	
	@GetMapping("/live_video.do")
	public String live_video() {
		return "etc/live_video";
	}
	
	@GetMapping("/live_controller.do")
	public String live_controller() {
		return "etc/live_controller";
	}
	
	@PostMapping("/live_controller_process.do") // 추후 이곳에 라이브 갱신하는 과정 처리해주어야 함
	public String live_controller_process() {
		return "etc/live_controller_process";
	}
	
	@PostMapping("/point_comment_insert_process.do") // 추후 이곳에 라이브 댓글 작성하는 과정 처리해주어야 함
	public String point_comment_insert_process() {
		return "etc/point_comment_insert_process";
	}
	
	@PostMapping("/point_comment_delete_process.do") // 추후 이곳에 라이브 댓글 삭제하는 과정 처리해주어야 함
	public String point_comment_delete_process() {
		return "etc/point_comment_delete_process";
	}
	
	
	
	
	
	
	
	
	
	
}
