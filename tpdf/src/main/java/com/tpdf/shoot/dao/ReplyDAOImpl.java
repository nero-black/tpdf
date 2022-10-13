package com.tpdf.shoot.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.tpdf.shoot.vo.ReplyVo;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject SqlSession sql;
	
	//댓글조회
	@Override
	public List<ReplyVo> readReply(int board_idx) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("replyMapper.readReply", board_idx);
	}
	//댓글작성
	@Override
	public void writeReply(ReplyVo vo) throws Exception {
		// TODO Auto-generated method stub
		sql.insert("replyMapper.writeReply", vo);
	}
	//댓글수정
	@Override
	public void updateReply(ReplyVo vo) throws Exception {
		// TODO Auto-generated method stub
		sql.update("replyMapper.updateReply", vo);
	//댓글삭제	
	}
	@Override
	public void deleteReply(ReplyVo vo) throws Exception {
		// TODO Auto-generated method stub
		sql.delete("replyMapper.deleteReply", vo);
	//선택 댓글 조회	
	}
	@Override
	public ReplyVo selectReply(int board_reply_idx) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("replyMapper.selectReply", board_reply_idx);
	}

}
