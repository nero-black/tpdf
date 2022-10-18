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

import com.tpdf.shoot.vo.BoardVo;


@Component("fileUtil")
public class FileUtil {
//private static final String filePath = "${pageContext.request.ContextPath}\\resources\\img\\notice\\"; // 깃허브용
		//서버용

// private static final String filePath = "C:\\Users\\71100\\git\\tpdf\\tpdf\\src\\main\\webapp\\resources\\img\\board\\"; // 깃허브용

/*
	 * private static final String filePath =
	 * "C:\\Users\\71100\\Desktop\\workspace\\tpdf\\src\\main\\webapp\\resources\\img\\board\\";
	 */
	
	public List<Map<String, Object>> parseInsertFileInfo(BoardVo boardVo, 
			MultipartHttpServletRequest mpRequest) throws Exception{
		String filePath = mpRequest.getSession().getServletContext().getRealPath("/resources/img/notice/");
		
		System.out.println(filePath);
		/*
			Iterator占쏙옙 占쎈쑓占쎌뵠占쎄숲占쎈굶占쎌벥 筌욌쵑鍮�筌ｏ옙? 占쎈퓠占쎄퐣 �뚎됱젂占쎈�∽옙�몵嚥≪뮆占쏙옙苑� 占쎌젟癰귣�占쏙옙 占쎈섯占쎈선占쎌궞 占쎈땾 占쎌뿳占쎈뮉 占쎌뵥占쎄숲占쎈읂占쎌뵠占쎈뮞占쎌뿯占쎈빍占쎈뼄.
			List占쎄돌 獄쏄퀣肉댐옙占� 占쎈떄筌△뫁�읅占쎌몵嚥∽옙 占쎈쑓占쎌뵠占쎄숲占쎌벥 占쎌젔域뱀눘�뵠 揶쏉옙占쎈뮟占쎈릭筌욑옙筌랃옙, Map占쎈쾻占쎌벥 占쎄깻占쎌삋占쎈뮞占쎈굶占쏙옙 占쎈떄筌△뫁�읅占쎌몵嚥∽옙 占쎌젔域뱀눛釉� 占쎈땾揶쏉옙 占쎈씨占쎈뮸占쎈빍占쎈뼄.
			Iterator占쎌뱽 占쎌뵠占쎌뒠占쎈릭占쎈연 Map占쎈퓠 占쎌뿳占쎈뮉 占쎈쑓占쎌뵠占쎄숲占쎈굶占쎌뱽 while�눧紐꾩뱽 占쎌뵠占쎌뒠占쎈릭占쎈연 占쎈떄筌△뫁�읅占쎌몵嚥∽옙 占쎌젔域뱀눛鍮�占쎈빍占쎈뼄.
		*/
		
		Iterator<String> iterator = mpRequest.getFileNames();
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		
		String storedFileName = null;
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		Map<String, Object> listMap = null;
		
		int board_idx = boardVo.getBoard_idx();
		
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
				
				
				listMap = new HashMap<String, Object>();
				listMap.put("board_idx", board_idx);
				
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