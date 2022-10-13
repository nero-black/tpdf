package com.tpdf.shoot.vo;


import java.util.Date;
public class ReplyVo {

		private int board_idx;
		private int board_reply_idx;
		private String content;
		private String writer;
		private Date regDate;
		public int getBoard_idx() {
			
			return board_idx;
		}
		public void setBoard_idx(int board_idx) {
			this.board_idx = board_idx;
		}
		public int getBoard_reply_idx() {
			return board_reply_idx;
		}
		public void setBoard_reply_idx(int board_reply_idx) {
			this.board_reply_idx = board_reply_idx;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public Date getregDate() {
			return regDate;
		}
		public void setregDate(Date regDate) {
			this.regDate = regDate;
		}
		
		@Override
		public String toString() {
			return "ReplyVo [board_idx=" + board_idx + ", board_reply_idx=" + board_reply_idx + ", content=" + content + ", writer=" + writer + ", regDate="
					+ regDate + "]";
		}
		
		
		
}
