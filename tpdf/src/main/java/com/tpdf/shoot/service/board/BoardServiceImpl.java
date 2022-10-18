package com.tpdf.shoot.service.board;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tpdf.shoot.dao.BoardDAO;
import com.tpdf.shoot.util.FileUtil;
import com.tpdf.shoot.vo.BoardVo;
import com.tpdf.shoot.vo.SearchCriteria;
@Service
public class BoardServiceImpl implements BoardService {

	@Resource(name="fileUtil")
	private FileUtil fileUtil;
	
	@Inject
	private BoardDAO dao;
	
	
	// 인덱스보드
	@Override
	public List<BoardVo> blist(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return dao.blist(scri);
	}
	
	// 게시글 작성
	@Override
	public void write(BoardVo boardVo, MultipartHttpServletRequest mpRequest) throws Exception {
		dao.write(boardVo);
		
		List<Map<String,Object>> list = fileUtil.parseInsertFileInfo(boardVo, mpRequest); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			dao.insertFile(list.get(i)); 
		}
	}
	// 게시물 목록 조회
	@Override
	public List<BoardVo> list(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return dao.list(scri);
	}
	
	//게시물 수정
	@Override
	public void update(BoardVo boardVo) throws Exception {
		// TODO Auto-generated method stub
		dao.update(boardVo);
	}
	//게시물 삭제
	@Override
	public void delete(int board_idx) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(board_idx);
	}
	// 게시물 조회
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public BoardVo read(int board_idx) throws Exception {
				dao.boardHit(board_idx);
			return dao.read(board_idx);
	}
	//게시물 총 개수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCount(scri);
	}
	
	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int board_idx) throws Exception {
			// TODO Auto-generated method stub
			return dao.selectFileList(board_idx);
	}
	/*
	 * // 첨부파일 다운로드
	 * 
	 * @Override public Map<String, Object> selectFileInfo(Map<String, Object> map)
	 * throws Exception { // TODO Auto-generated method stub return
	 * dao.selectFileInfo(map); }
	 */



}
