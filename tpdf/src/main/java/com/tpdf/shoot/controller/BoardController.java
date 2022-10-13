package com.tpdf.shoot.controller;



import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tpdf.shoot.service.board.BoardService;
import com.tpdf.shoot.service.reply.ReplyService;
import com.tpdf.shoot.vo.BoardVo;
import com.tpdf.shoot.vo.Paging;
import com.tpdf.shoot.vo.ReplyVo;
import com.tpdf.shoot.vo.SearchCriteria;

@Controller
@RequestMapping("/board/*")	
public class BoardController {
		@Inject
		BoardService service;
	
		@Inject
		ReplyService replyService;
		
		
		
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
		public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		
			
			model.addAttribute("list",service.list(scri));
			
			Paging Paging = new Paging();
			Paging.setCri(scri);
			Paging.setTotalCount(service.listCount(scri));
			
			model.addAttribute("Paging", Paging);
			return "board/board_list";
			
		}
		
		// 게시판 조회
		@RequestMapping(value = "/board_readView", method = RequestMethod.GET)
		public String read(BoardVo boardVo, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
			
			
			model.addAttribute("read", service.read(boardVo.getBoard_idx()));
			model.addAttribute("scri", scri);
			List<ReplyVo> replyList = replyService.readReply(boardVo.getBoard_idx());
			model.addAttribute("replyList", replyList);
			return "board/board_readView";
		}
		
		
		// 게시판 수정뷰
		@RequestMapping(value = "/board_updateView", method = RequestMethod.GET)
		public String updateView(BoardVo boardVo,@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception{
		
			
			model.addAttribute("update", service.read(boardVo.getBoard_idx()));
			model.addAttribute("scri", scri);
			return "board/board_updateView";
		}
		
		// 게시판 수정
		@RequestMapping(value = "/board_update", method = RequestMethod.POST)
		public String update(BoardVo boardVo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception{
	
			service.update(boardVo);
			
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/board/board_list";
		}

		// 게시판 삭제
		@RequestMapping(value = "/board_delete", method = RequestMethod.POST)
		public String delete(BoardVo boardVo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		
			
			service.delete(boardVo.getBoard_idx());
			
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/board/board_list";
		}
		//댓글작성
		@RequestMapping(value="/board_replyWrite", method = RequestMethod.POST)
		public String replyWrite(ReplyVo vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			
			
			replyService.writeReply(vo);
			
			rttr.addAttribute("board_idx", vo.getBoard_idx());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/board/board_readView";
		}
		
		//댓글 수정 GET
		@RequestMapping(value="/board_replyUpdateView", method = RequestMethod.GET)
		public String replyUpdateView(ReplyVo vo, SearchCriteria scri, Model model) throws Exception {
			
			
			model.addAttribute("replyUpdate", replyService.selectReply(vo.getBoard_reply_idx()));
			model.addAttribute("scri", scri);
			
			return "board/board_replyUpdateView";
		}
		
		//댓글 수정 POST
		@RequestMapping(value="/board_replyUpdate", method = RequestMethod.POST)
		public String replyUpdate(ReplyVo vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		
			
			replyService.updateReply(vo);
			
			rttr.addAttribute("board_idx", vo.getBoard_idx());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/board/board_readView";
		}
		
		
		//댓글 삭제 GET
		@RequestMapping(value="/board_replyDeleteView", method = RequestMethod.GET)
		public String replyDeleteView(ReplyVo vo, SearchCriteria scri, Model model) throws Exception {
			
			
			model.addAttribute("replyDelete", replyService.selectReply(vo.getBoard_reply_idx()));
			model.addAttribute("scri", scri);
			

			return "board/board_replyDeleteView";
		}
		
		//댓글 삭제
		@RequestMapping(value="/board_replyDelete", method = RequestMethod.POST)
		public String replyDelete(ReplyVo vo, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
			
			
			replyService.deleteReply(vo);
			
			rttr.addAttribute("board_idx", vo.getBoard_idx());
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/board/board_readView";
		}
	
	
}
