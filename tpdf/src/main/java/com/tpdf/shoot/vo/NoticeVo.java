package com.tpdf.shoot.vo;

import java.util.Date;

public class NoticeVo {
      //db 쿼리 주석
	/*
	 * create table Notice_tbl( notice_idx int not null auto_increment, title
	 * varchar(50) not null, content text not null, writer varchar(30) not null,
	 * regDate timestamp not null default now(), viewCnt int default 0, primary
	 * key(notice_idx) );
	 */
	
	
	private int notice_idx;
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	private int viewCnt;
	private String gdsThumbImg;
	
	
	public String getGdsThumbImg() {
		return gdsThumbImg;
	}
	public void setGdsThumbImg(String gdsThumbImg) {
		this.gdsThumbImg = gdsThumbImg;
	}
	public int getNotice_idx() {
		return notice_idx;
	}
	public void setNotice_idx(int notice_idx) {
		this.notice_idx = notice_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
}
