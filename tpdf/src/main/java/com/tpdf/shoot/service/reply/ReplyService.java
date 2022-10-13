package com.tpdf.shoot.service.reply;

import java.util.List;

import com.tpdf.shoot.vo.ReplyVo;

public interface ReplyService {
	
	//댓글조회
	public List<ReplyVo> readReply(int board_idx) throws Exception;
	//댓글작성
	public void writeReply(ReplyVo vo) throws Exception;
	//댓글수정
	public void updateReply(ReplyVo vo) throws Exception;
	//댓글작성
	public void deleteReply(ReplyVo vo) throws Exception;
	//선택 댓글 조회
	public ReplyVo selectReply(int board_reply_idx) throws Exception;
}
