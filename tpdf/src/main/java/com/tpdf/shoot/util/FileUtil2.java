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
	//깃허브용
    private static final String filePath = "${pageContext.request.ContextPath}\\resources\\img\\notice\\"; 
	//서버용
	//private static final String filePath = "C:\\Users\\71100\\Desktop\\workspace\\tpdf\\src\\main\\webapp\\resources\\img\\notice\\";
	
	public List<Map<String, Object>> parseInsertFileInfo2(NoticeVo noticeVo, 
			MultipartHttpServletRequest mpRequest) throws Exception{
	
		
		
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		int notice_idx = noticeVo.getNotice_idx();
		
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdirs();
		}
		
		while(iterator.hasNext()) {
			multipartFile = mpRequest.getFile(iterator.next());
			if(multipartFile.isEmpty() == false) {
				originalFileName = multipartFile.getOriginalFilename();
				storedFileName = originalFileName;
				
				
				
				file = new File(filePath + storedFileName);
				multipartFile.transferTo(file);
				
				;
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