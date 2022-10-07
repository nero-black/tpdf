package com.tpdf.shoot.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tpdf.shoot.service.notice.NoticeService;
import com.tpdf.shoot.vo.NoticeVo;
import com.tpdf.shoot.vo.Page;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Inject
	NoticeService service;
	//게시물목록
	@RequestMapping(value="/notice_list", method=RequestMethod.GET)
	public void getList(Model model) throws Exception{
		List<NoticeVo> list = null;
		list = service.list();
		
		model.addAttribute("list",list);
	}
	//게시물작성
	
	@RequestMapping(value="/notice_write", method=RequestMethod.GET)
	public void getWrite() throws Exception{
		
		
		
	}
	
	// 게시물 작성
	@RequestMapping(value="/notice_write", method=RequestMethod.POST)
	public String postWrite(NoticeVo vo) throws Exception {
	  service.write(vo);
	  
	  return "redirect:/notice/notice_listPageSearch?num=1";
	}
	
	//게시물 조회
	@RequestMapping(value="/notice_view", method=RequestMethod.GET)
	public void getView(@RequestParam("notice_idx") int notice_idx, Model model) throws Exception{
		NoticeVo vo = service.view(notice_idx);
		model.addAttribute("view",vo);
	}
	
	//게시물 수정
	@RequestMapping(value="/notice_modify", method=RequestMethod.GET)
	public void getModify(@RequestParam("notice_idx") int notice_idx, Model model) throws Exception{
		NoticeVo vo = service.view(notice_idx);
		model.addAttribute("view",vo);
	}
	//게시물 수정
	@RequestMapping(value="/notice_modify", method=RequestMethod.POST)
	public String postModify(NoticeVo vo) throws Exception {
	  service.modify(vo);
	  
	  return "redirect:/notice/notice_view?notice_idx=" +vo.getNotice_idx();
	}
	
	// 게시물 삭제
	@RequestMapping(value = "/notice_delete", method = RequestMethod.GET)
	public String getDelete(@RequestParam("notice_idx") int notice_idx) throws Exception {
	  
	 service.delete(notice_idx);  

	 return "redirect:/notice/notice_listPageSearch?num=1";
	}
	
	// 게시물 목록 + 페이징 추가 + 검색
	@RequestMapping(value = "/notice_listPageSearch", method = RequestMethod.GET)
	public void getListPageSearch(Model model, @RequestParam("num") int num, 
		@RequestParam(value = "searchType",required = false, defaultValue = "title") String searchType,
		@RequestParam(value = "keyword",required = false, defaultValue = "") String keyword
	  ) throws Exception {

	 
	 Page page = new Page();
	 
	 page.setNum(num);
		/* page.setCount(service.count()); */  
	 page.setCount(service.searchCount(searchType, keyword));
	 
	// 검색 타입과 검색어
	/* page.setSearchTypeKeyword(searchType, keyword); */
	 page.setSearchType(searchType);
	 page.setKeyword(keyword);
	 
	 
	 List<NoticeVo> list = null; 
	 //list = service.listPage(page.getDisplayPost(), page.getPostNum());
	 list = service.listPageSearch(page.getDisplayPost(), page.getPostNum(), searchType, keyword);
	 
	 model.addAttribute("list", list);
	 model.addAttribute("page", page);
	 model.addAttribute("select", num);
	 
		/*
		 * model.addAttribute("searchType", searchType); 
		 * model.addAttribute("keyword",
		 * keyword);
		 */
	}
	
	
			
}
