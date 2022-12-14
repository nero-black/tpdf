<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "com.tpdf.shoot.vo.MemberVo" %>  
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->

<% int member_idx = (Integer)session.getAttribute("member_idx"); %>
<% String member_name = (String)session.getAttribute("member_name"); %>
<% int member_point = (Integer)session.getAttribute("member_point"); %>
<% int member_grade = (Integer)session.getAttribute("member_grade"); %>
<% String member_drop = (String)session.getAttribute("member_drop"); %>

<c:if test="${member_ban == 'y'}">
<% response.sendRedirect("dropped.do"); %>
</c:if> <!-- 강제탈퇴된 계정 로그인 방지 -->

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>ShooT :: 비상하는 해외축구 커뮤니티</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
  <script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
</head>
<body>

	<c:choose>
		<c:when test = "${member_grade == 2 && member_drop == 'n'}">
			<nav id="admin">
			  <a><b style="color:red;">관리자</b></a>님
			  <b style="color:black;"><a href="${pageContext.request.contextPath}/admin_index.do" style="color:black;">관리자 페이지</a></b>
			  <a style="color:black;" href="${pageContext.request.contextPath}/log_out.do">로그아웃</a>
			</nav>
		</c:when>
		<c:when test = "${member_grade == 1 && member_drop == 'n'}">
			<nav id="member">
			  <a><b>${member_name}</b></a>님
			  <a style="color:#1DDB16"><b>${member_point}p</b></a>
			  <a style="color:black;" href="${pageContext.request.contextPath}/mypage_check.do">마이 페이지</a>
			  <a style="color:black;" href="${pageContext.request.contextPath}/log_out.do">로그아웃</a>
			</nav>
		</c:when>
		<c:otherwise>
			<nav id="guest">
			  <a href="${pageContext.request.contextPath}/login.do">로그인</a>
			  <a href="${pageContext.request.contextPath}/join.do">회원가입</a>
			</nav>
		</c:otherwise>
	</c:choose>
	<hr class="clear_line">
	
	<header id="header">
	<div id="header_div">
	 <a href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="로고" id="logo"></a>
	
	 <nav id="menu">
	   <a href="${pageContext.request.contextPath}/notice/notice_list">뉴스</a> |
	   <a href="${pageContext.request.contextPath}/board/board_list">게시판</a> |
	   <a href="${pageContext.request.contextPath}/event_list.do">이벤트</a> |
	   <a href="${pageContext.request.contextPath}/video_list.do">영상</a> |
	   <a href="${pageContext.request.contextPath}/rank.do">순위/일정</a>
	 </nav>  
	</div>
	
	<hr class="clear_line">
	
	<a href="https://www.sungsimdangmall.co.kr/" target="_blank"><img src="${pageContext.request.contextPath}/resources/img/banner02.png" alt="광고 배너" id="banner_l1"></a>
	<a href="https://map.naver.com/v5/entry/place/37033591?c=14149386.6292817,4244279.9830111,13,0,0,0,dh&placePath=%2Fhome&entry=plt" target="_blank"><img src="${pageContext.request.contextPath}/resources/img/banner01.png" alt="광고 배너" id="banner_l2"></a>
	<a href="https://www.shinsegae.com/store/main.do?storeCd=SC00060" target="_blank"><img src="${pageContext.request.contextPath}/resources/img/banner03.png" alt="광고 배너" id="banner_r"></a>
	<a href="#"><div id="top_button">▲</div></a>
	</header>
	
	<br>

</body>

</html>