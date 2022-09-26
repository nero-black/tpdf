<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>ShooT :: 비상하는 해외축구 커뮤니티</title></title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css">
  <script src="${pageContext.request.contextPath}/resources/js/header.js"></script>
</head>
<body>

  <nav id="guest">
    <a href="${pageContext.request.contextPath}/login.do">로그인</a> |
    <a href="${pageContext.request.contextPath}/join.do">회원가입</a>
  </nav>
  <nav id="member">
    <a><b>이름</b></a>님 |
    <a style="color:yellowgreen">포인트p</a> |
    <a style="color:black;" href="#">마이 페이지</a> |
    <a style="color:black;" href="#">로그아웃</a>
  </nav>
  <nav id="admin">
    <a><b style="color:red;">관리자</b></a>님 |
    <b style="color:black;"><a href="${pageContext.request.contextPath}/mypage_check.do">마이 페이지</a></b> |
    <a style="color:black;" href="#">로그아웃</a>
  </nav>
  <hr class="clear_line">
  
  <header id="header">
  <div id="header_div">
	  <a href="${pageContext.request.contextPath}/index.do"><img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="로고" id="logo"></a>
	
	  <nav id="menu">
	    <a href="${pageContext.request.contextPath}/notice_list.do">뉴스</a> |
	    <a href="${pageContext.request.contextPath}/board_list.do">게시판</a> |
	    <a href="${pageContext.request.contextPath}/event_list.do">이벤트</a> |
	    <a href="${pageContext.request.contextPath}/video_list.do">영상</a> |
	    <a href="${pageContext.request.contextPath}/rank.do">순위/일정</a>
	  </nav>  
  </div>

  <hr class="clear_line">

  <a href="#"><img src="${pageContext.request.contextPath}/resources/img/banner02.png" alt="광고 배너" id="banner_l1"></a>
  <a href="#"><img src="${pageContext.request.contextPath}/resources/img/banner01.png" alt="광고 배너" id="banner_l2"></a>
  <a href="#"><img src="${pageContext.request.contextPath}/resources/img/banner03.png" alt="광고 배너" id="banner_r"></a>
  <a href="#"><div id="top_button">▲</div></a>
  </header>

  <br>
  
</body>

</html>