package com.tpdf.shoot.service.reply;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.tpdf.shoot.dao.ReplyDAO;
import com.tpdf.shoot.vo.ReplyVo;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Inject ReplyDAO dao;
	//댓글조회
	@Override
	public List<ReplyVo> readReply(int board_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.readReply(board_idx);
	}
	//댓글작성
	@Override
	public void writeReply(ReplyVo vo) throws Exception {
		// TODO Auto-generated method stub
		dao.writeReply(vo);
		
	}
	//댓글수정
	@Override
	public void updateReply(ReplyVo vo) throws Exception {
		// TODO Auto-generated method stub
		dao.updateReply(vo);
	}
	//댓글삭제
	@Override
	public void deleteReply(ReplyVo vo) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteReply(vo);
	}
	//선택 댓글조회
	@Override
	public ReplyVo selectReply(int board_reply_idx) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectReply(board_reply_idx);
	}

}
