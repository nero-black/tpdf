package com.tpdf.shoot.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tpdf.shoot.vo.NoticeVo;


@Component("fileUtil2")
public class FileUtil2 {
//	private static final String filePath = "C:\\Users\\71100\\git\\tpdf\\tpdf\\src\\main\\webapp\\resources\\img\\"; // �뙆�씪�씠 ���옣�맆 �쐞移�

	private static final String filePath = "C:\\Users\\71100\\Desktop\\workspace\\tpdf\\src\\main\\webapp\\resources\\img\\notice\\";
	
	public List<Map<String, Object>> parseInsertFileInfo2(NoticeVo noticeVo, 
			MultipartHttpServletRequest mpRequest) throws Exception{
		System.out.println("test");
		/*
			Iterator�� �뜲�씠�꽣�뱾�쓽 吏묓빀泥�? �뿉�꽌 而щ젆�뀡�쑝濡쒕��꽣 �젙蹂대�� �뼸�뼱�삱 �닔 �엳�뒗 �씤�꽣�럹�씠�뒪�엯�땲�떎.
			List�굹 諛곗뿴�� �닚李⑥쟻�쑝濡� �뜲�씠�꽣�쓽 �젒洹쇱씠 媛��뒫�븯吏�留�, Map�벑�쓽 �겢�옒�뒪�뱾�� �닚李⑥쟻�쑝濡� �젒洹쇳븷 �닔媛� �뾾�뒿�땲�떎.
			Iterator�쓣 �씠�슜�븯�뿬 Map�뿉 �엳�뒗 �뜲�씠�꽣�뱾�쓣 while臾몄쓣 �씠�슜�븯�뿬 �닚李⑥쟻�쑝濡� �젒洹쇳빀�땲�떎.
		*/
		
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension = null;
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		int notice_idx = noticeVo.getNotice_idx();
		
		File file2 = new File(filePath);
		if(file2.exists() == false) {
			file2.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				storedFileName = originalFileName;
				
				
				
				file2 = new File(filePath + storedFileName);
				multipartFile.transferTo(file2);
				
				
				listMap = new HashMap<String, Object>();
				listMap.put("notice_idx", notice_idx);
				
				listMap.put("origin_file_name", originalFileName);
				
			
				listMap.put("stored_file_name", storedFileName);
				listMap.put("file_size", multipartFile.getSize());
				list.add(listMap);
			}
		}
		return list;
	}
	
	/*
	 * public static String getRandomString() { return
	 * UUID.randomUUID().toString().replaceAll("-", "");
	 * 
	 * }
	 */
}