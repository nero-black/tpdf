package com.tpdf.shoot.controller;



import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tpdf.shoot.service.notice.NoticeService;
import com.tpdf.shoot.service.reply.ReplyService;
import com.tpdf.shoot.vo.NoticeVo;
import com.tpdf.shoot.vo.Paging;
import com.tpdf.shoot.vo.ReplyVo;
import com.tpdf.shoot.vo.SearchCriteria;

@Controller
@RequestMapping("/notice/*")	
public class NoticeController {
		@Inject
		NoticeService service;
	
		@Inject
		ReplyService replyService;
		
		
		
		// 寃뚯떆�뙋 湲� �옉�꽦 �솕硫�
		@RequestMapping(value = "/notice_writeView", method = RequestMethod.GET)
		public void writeView() throws Exception{
		
			
		}
		
		// 寃뚯떆�뙋 湲� �옉�꽦
		@RequestMapping(value = "/notice_write", method = RequestMethod.POST)
		public String write(NoticeVo noticeVo, MultipartHttpServletRequest mpRequest) throws Exception{
			
			
			service.write(noticeVo, mpRequest);
			
			return "redirect:notice_list";
		}
		// 寃뚯떆�뙋 紐⑸줉 議고쉶
		@RequestMapping(value = "/notice_list", method = RequestMethod.GET)
		public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		
			
			model.addAttribute("list",service.list(scri));
			
			Paging Paging = new Paging();
			Paging.setCri(scri);
			Paging.setTotalCount(service.listCount(scri));
			
			model.addAttribute("Paging", Paging);
			return "notice/notice_list";
			
		}
		
		// 寃뚯떆�뙋 議고쉶
		@RequestMapping(value = "/notice_readView", method = RequestMethod.GET)
		public String read(NoticeVo noticeVo, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
			
			System.out.println("1");
			model.addAttribute("read", service.read(noticeVo.getNotice_idx()));
			model.addAttribute("scri", scri);
			
			List<ReplyVo> replyList = replyService.readReply(noticeVo.getNotice_idx());
			model.addAttribute("replyList", replyList);
			System.out.println("2");
			List<Map<String, Object>> fileList = service.selectFileList(noticeVo.getNotice_idx());
			model.addAttribute("file", fileList);
			System.out.println("3");
			return "notice/notice_readView";
		
		}
		
		
		// 寃뚯떆�뙋 �닔�젙酉�
		@RequestMapping(value = "/notice_updateView", method = RequestMethod.GET)
		public String updateView(NoticeVo noticeVo,@ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception{
		
			
			model.addAttribute("update", service.read(noticeVo.getNotice_idx()));
			model.addAttribute("scri", scri);
			
			List<Map<String, Object>> fileList = service.selectFileList(noticeVo.getNotice_idx());
			model.addAttribute("file", fileList);
			return "notice/notice_updateView";
		}
		
		// 寃뚯떆�뙋 �닔�젙
		@RequestMapping(value = "/notice_update", method = RequestMethod.POST)
		public String update(NoticeVo noticeVo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr
											) throws Exception{
	
			service.update(noticeVo);
			
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/notice/notice_list";
		}

		// 寃뚯떆�뙋 �궘�젣
		@RequestMapping(value = "/notice_delete", method = RequestMethod.POST)
		public String delete(NoticeVo noticeVo, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		
			
			service.delete(noticeVo.getNotice_idx());
			
			rttr.addAttribute("page", scri.getPage());
			rttr.addAttribute("perPageNum", scri.getPerPageNum());
			rttr.addAttribute("searchType", scri.getSearchType());
			rttr.addAttribute("keyword", scri.getKeyword());
			
			return "redirect:/notice/notice_list";
		}

		/*
		 * //�뙎湲��옉�꽦
		 * 
		 * @RequestMapping(value="/notice_replyWrite", method = RequestMethod.POST)
		 * public String replyWrite(ReplyVo vo, SearchCriteria scri, RedirectAttributes
		 * rttr) throws Exception {
		 * 
		 * 
		 * replyService.writeReply(vo);
		 * 
		 * rttr.addAttribute("notice_idx", vo.getNotice_idx());
		 * rttr.addAttribute("page", scri.getPage()); rttr.addAttribute("perPageNum",
		 * scri.getPerPageNum()); rttr.addAttribute("searchType", scri.getSearchType());
		 * rttr.addAttribute("keyword", scri.getKeyword());
		 * 
		 * return "redirect:/notice/notice_readView"; }
		 */
		//�뙎湲� �닔�젙 GET
		/*
		 * @RequestMapping(value="/notice_replyUpdateView", method = RequestMethod.GET)
		 * public String replyUpdateView(ReplyVo vo, SearchCriteria scri, Model model)
		 * throws Exception {
		 * 
		 * 
		 * model.addAttribute("replyUpdate",
		 * replyService.selectReply(vo.getNotice_reply_idx()));
		 * model.addAttribute("scri", scri);
		 * 
		 * return "notice/notice_replyUpdateView"; }
		 * 
		 * //�뙎湲� �닔�젙 POST
		 * 
		 * @RequestMapping(value="/notice_replyUpdate", method = RequestMethod.POST)
		 * public String replyUpdate(ReplyVo vo, SearchCriteria scri, RedirectAttributes
		 * rttr) throws Exception {
		 * 
		 * 
		 * replyService.updateReply(vo);
		 * 
		 * rttr.addAttribute("notice_idx", vo.getNotice_idx());
		 * rttr.addAttribute("page", scri.getPage()); rttr.addAttribute("perPageNum",
		 * scri.getPerPageNum()); rttr.addAttribute("searchType", scri.getSearchType());
		 * rttr.addAttribute("keyword", scri.getKeyword());
		 * 
		 * return "redirect:/notice/notice_readView"; }
		 * 
		 * 
		 * //�뙎湲� �궘�젣 GET
		 * 
		 * @RequestMapping(value="/notice_replyDeleteView", method = RequestMethod.GET)
		 * public String replyDeleteView(ReplyVo vo, SearchCriteria scri, Model model)
		 * throws Exception {
		 * 
		 * 
		 * model.addAttribute("replyDelete",
		 * replyService.selectReply(vo.getNotice_reply_idx()));
		 * model.addAttribute("scri", scri);
		 * 
		 * 
		 * return "notice/notice_replyDeleteView"; }
		 * 
		 * //�뙎湲� �궘�젣
		 * 
		 * @RequestMapping(value="/notice_replyDelete", method = RequestMethod.POST)
		 * public String replyDelete(ReplyVo vo, SearchCriteria scri, RedirectAttributes
		 * rttr) throws Exception {
		 * 
		 * 
		 * replyService.deleteReply(vo);
		 * 
		 * rttr.addAttribute("notice_idx", vo.getNotice_idx());
		 * rttr.addAttribute("page", scri.getPage()); rttr.addAttribute("perPageNum",
		 * scri.getPerPageNum()); rttr.addAttribute("searchType", scri.getSearchType());
		 * rttr.addAttribute("keyword", scri.getKeyword());
		 * 
		 * return "redirect:/notice/notice_readView"; }
		 */
		/*
		 * //�뙆�씪�떎�슫
		 * 
		 * @RequestMapping(value="/notice_fileDown") public void fileDown(@RequestParam
		 * Map<String, Object> map, HttpServletResponse response) throws Exception{
		 * Map<String, Object> resultMap = service.selectFileInfo(map); String
		 * storedFileName = (String) resultMap.get("stored_file_name"); String
		 * originalFileName = (String) resultMap.get("origin_file_name");
		 * 
		 * // �뙆�씪�쓣 ���옣�뻽�뜕 �쐞移섏뿉�꽌 泥⑤��뙆�씪�쓣 �씫�뼱 byte[]�삎�떇�쑝濡� 蹂��솚�븳�떎. byte fileByte[] =
		 * org.apache.commons.io.FileUtils.readFileToByteArray(new
		 * File("C:\\mp\\file\\"+storedFileName));
		 * 
		 * response.setContentType("application/octet-stream");
		 * response.setContentLength(fileByte.length);
		 * response.setHeader("Content-Disposition",
		 * "attachment; fileName=\""+URLEncoder.encode(originalFileName,
		 * "UTF-8")+"\";"); response.getOutputStream().write(fileByte);
		 * response.getOutputStream().flush(); response.getOutputStream().close();
		 * 
		 * }
		 */
	
}
