package com.tpdf.shoot.vo;

import java.util.Date;

public class EventVo {
	private int event_idx;
	private String team_a;
	private String team_b;
	private int betting_sum;
	private int b_person; // 베팅 인원
	private float b_percent_a;
	private float b_percent_b;
	private String victory_team;
	private int v_person; // 베팅 승자 count 값
	private int v_person_point;
	private Date start_date;
	private Date end_date; 
	private String process;
	private String member_idx; // 회원 번호
	private int member_point; // 회원 보유 포인트
	private String betting_team;
	private int b_point;
	private Date b_date;
	
	
	
	public int getEvent_idx() {
		return event_idx;
	}
	public void setEvent_idx(int event_idx) {
		this.event_idx = event_idx;
	}
	public String getTeam_a() {
		return team_a;
	}
	public void setTeam_a(String team_a) {
		this.team_a = team_a;
	}
	public String getTeam_b() {
		return team_b;
	}
	public void setTeam_b(String team_b) {
		this.team_b = team_b;
	}
	public int getBetting_sum() {
		return betting_sum;
	}
	public void setBetting_sum(int betting_sum) {
		this.betting_sum = betting_sum;
	}
	public int getB_person() {
		return b_person;
	}
	public void setB_person(int b_person) {
		this.b_person = b_person;
	}
	public float getB_percent_a() {
		return b_percent_a;
	}
	public void setB_percent_a(float b_percent_a) {
		this.b_percent_a = b_percent_a;
	}
	public float getB_percent_b() {
		return b_percent_b;
	}
	public void setB_percent_b(float b_percent_b) {
		this.b_percent_b = b_percent_b;
	}
	public String getVictory_team() {
		return victory_team;
	}
	public void setVictory_team(String victory_team) {
		this.victory_team = victory_team;
	}
	public int getV_person() {
		return v_person;
	}
	public void setV_person(int v_person) {
		this.v_person = v_person;
	}
	public int getV_person_point() {
		return v_person_point;
	}
	public void setV_person_point(int v_person_point) {
		this.v_person_point = v_person_point;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getMember_idx() {
		return member_idx;
	}
	public void setMember_idx(String member_idx) {
		this.member_idx = member_idx;
	}
	public int getMember_point() {
		return member_point;
	}
	public void setMember_point(int member_point) {
		this.member_point = member_point;
	}
	public String getBetting_team() {
		return betting_team;
	}
	public void setBetting_team(String betting_team) {
		this.betting_team = betting_team;
	}
	public int getB_point() {
		return b_point;
	}
	public void setB_point(int b_point) {
		this.b_point = b_point;
	}
	public Date getB_date() {
		return b_date;
	}
	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}
	
	
	
}
