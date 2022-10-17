package com.tpdf.shoot.controller;



import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tpdf.shoot.service.notice.NoticeService;
import com.tpdf.shoot.vo.NoticeVo;
import com.tpdf.shoot.vo.Paging;
import com.tpdf.shoot.vo.SearchCriteria;

@Controller
@RequestMapping("/notice/*")	
public class NoticeController {
		@Inject
		NoticeService service;
	

		
		
		// 野껊슣�뻻占쎈솇 疫뀐옙 占쎌삂占쎄쉐 占쎌넅筌롳옙
		@RequestMapping("/notice_writeView")
		public String writeView(Model model) throws Exception{
			
			String request_mapping = "notice/notice_writeView";
			
			return request_mapping;
			
		}
		
		// 새로 추가한 부분 (new code)
		@ResponseBody
		@RequestMapping("/need_login.do")
		public String need_login(HttpSession session) {
			session.invalidate();
			String request_mapping = "<script>alert('로그인 해야 합니다.');"+ "location.href='notice_list.do'</script>";
		
		return request_mapping;
		}
		
		// 새로 추가한 부분 (new code)
		@ResponseBody
		@RequestMapping("/invaid_update.do")
		public String invaid_update(HttpSession session) {
			String request_mapping = "<script>alert('비정상적인 접근입니다.');"+ "location.href='notice_list.do'</script>";
		
		return request_mapping;
		}
		
		// 野껊슣�뻻占쎈솇 疫뀐옙 占쎌삂占쎄쉐
		@RequestMapping(value = "/notice_write", method = RequestMethod.POST)
		public String write(NoticeVo noticeVo, MultipartHttpServletRequest mpRequest) throws Exception{
			
			
			service.write(noticeVo, mpRequest);
			
			return "redirect:notice_list";
		}
		// 野껊슣�뻻占쎈솇 筌뤴뫖以� 鈺곌퀬�돳
		@RequestMapping(value = "/notice_list", method = RequestMethod.GET)
		public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		
			
			model.addAttribute("list",service.list(scri));
			
			Paging Paging = new Paging();
			Paging.setCri(scri);
			Paging.setTotalCount(service.listCount(scri));
			
			model.addAttribute("Paging", Paging);
			return "notice/notice_list";
			
		}
		
		// 野껊슣�뻻占쎈솇 鈺곌퀬�돳
		@RequestMapping(value = "/notice_readView", method = RequestMethod.GET)
		public String read(NoticeVo noticeVo, Model model, @ModelAttribute("scri") SearchCriteria scri, HttpSession session) throws Exception{
			
			// 새로 추가한 부분 (new code)
			Object grade = session.getAttribute("member_grade");

			if (grade == null) {
				session.setAttribute("member_grade", 0);
				session.setAttribute("member_name", "-");
			}
			
			
			model.addAttribute("read", service.read(noticeVo.getNotice_idx()));
			model.addAttribute("scri", scri);
			
	
			
			List<Map<String, Object>> fileList = service.selectFileList(noticeVo.getNotice_idx());
			model.addAttribute("file", fileList);
			
			return "notice/notice_readView";
		
		}
		
		
		// 野껊슣�뻻占쎈솇 占쎈땾占쎌젟�뀎占�
		@RequestMapping(value = "/notice_updateView", method = RequestMethod.GET)
		public String updateView(NoticeVo noticeVo,@ModelAttribute("scri") SearchCriteria scri, Model model, HttpSession session) throws Exception{
		
			
			// 새로 추가한 부분
			Object grade = session.getAttribute("member_grade");

			if (grade == null) {
				session.setAttribute("member_grade", 0);
				session.setAttribute("member_name", "-");
			}
			
			model.addAttribute("update", service.read(noticeVo.getNotice_idx()));
			model.addAttribute("scri", scri);
			
			List<Map<String, Object>> fileList = service.selectFileList(noticeVo.getNotice_idx());
			model.addAttribute("file", fileList);
			return "notice/notice_updateView";
		}
		
		// 野껊슣�뻻占쎈솇 占쎈땾占쎌젟
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

		// 野껊슣�뻻占쎈솇 占쎄텣占쎌젫
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
		 * //占쎈솊疫뀐옙占쎌삂占쎄쉐
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
		//占쎈솊疫뀐옙 占쎈땾占쎌젟 GET
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
		 * //占쎈솊疫뀐옙 占쎈땾占쎌젟 POST
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
		 * //占쎈솊疫뀐옙 占쎄텣占쎌젫 GET
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
		 * //占쎈솊疫뀐옙 占쎄텣占쎌젫
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
		 * //占쎈솁占쎌뵬占쎈뼄占쎌뒲
		 * 
		 * @RequestMapping(value="/notice_fileDown") public void fileDown(@RequestParam
		 * Map<String, Object> map, HttpServletResponse response) throws Exception{
		 * Map<String, Object> resultMap = service.selectFileInfo(map); String
		 * storedFileName = (String) resultMap.get("stored_file_name"); String
		 * originalFileName = (String) resultMap.get("origin_file_name");
		 * 
		 * // 占쎈솁占쎌뵬占쎌뱽 占쏙옙占쎌삢占쎈뻥占쎈쐲 占쎌맄燁살꼷肉됵옙苑� 筌ｂ뫀占쏙옙�솁占쎌뵬占쎌뱽 占쎌뵭占쎈선 byte[]占쎌굨占쎈뻼占쎌몵嚥∽옙 癰귨옙占쎌넎占쎈립占쎈뼄. byte fileByte[] =
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
