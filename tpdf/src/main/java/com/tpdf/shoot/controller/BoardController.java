package com.tpdf.shoot.controller;



import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tpdf.shoot.service.board.BoardService;
import com.tpdf.shoot.vo.BoardVo;

@Controller
@RequestMapping("/board/*")	
public class BoardController {
	
	
		
		@Inject
		BoardService service;
		
		// 게시판 글 작성 화면
		@RequestMapping(value = "/board_writeView", method = RequestMethod.GET)
		public void writeView() throws Exception{
		
			
		}
		
		// 게시판 글 작성
		@RequestMapping(value = "/board_write", method = RequestMethod.POST)
		public String write(BoardVo BoardVo) throws Exception{
			
			
			service.write(BoardVo);
			
			return "redirect:board_list";
		}
		// 게시판 목록 조회
		@RequestMapping(value = "/board_list", method = RequestMethod.GET)
		public String list(Model model) throws Exception{
		
			
			model.addAttribute("list",service.list());
			
			
			return "board/board_list";
			
		}
		
		// 게시판 조회
		@RequestMapping(value = "/board_readView", method = RequestMethod.GET)
		public String read(BoardVo boardVo, Model model) throws Exception{
			
			
			model.addAttribute("read", service.read(boardVo.getBoard_idx()));
			
			return "board/board_readView";
		}
		
		
		// 게시판 수정뷰
		@RequestMapping(value = "/board_updateView", method = RequestMethod.GET)
		public String updateView(BoardVo boardVo, Model model) throws Exception{
		
			
			model.addAttribute("update", service.read(boardVo.getBoard_idx()));
			
			return "board/board_updateView";
		}
		
		// 게시판 수정
		@RequestMapping(value = "/board_update", method = RequestMethod.POST)
		public String update(BoardVo boardVo) throws Exception{
	
			service.update(boardVo);
			
			return "redirect:/board/board_list";
		}

		// 게시판 삭제
		@RequestMapping(value = "/board_delete", method = RequestMethod.POST)
		public String delete(BoardVo boardVo) throws Exception{
		
			
			service.delete(boardVo.getBoard_idx());
			
			return "redirect:/board/board_list";
		}
	
	
	
}
