<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "include/header.jsp" %> <!-- 헤더 삽입 -->
<%@ page import = "com.tpdf.shoot.vo.VideoVo" %>  
<%@ page import="java.util.*" %>

<% List<VideoVo> videoList = (List)request.getAttribute("videoList"); %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/index.css">
<style>
* {text-decoration:none;}
</style>
<body>
  <main>
      <a id="hot_video" href="#">
        <span>핫비디오 제목입니다</span>
        <img src="${pageContext.request.contextPath}/resources/img/hot_video.png" alt="하이라이트 영상"  class="main_video">
      </a>
      <a class="issue_video" href="#">
        <img src="${pageContext.request.contextPath}/resources/img/video.png" alt="영상" class="sub_video">
        <span>영상 제목입니다. </span>
        <p>출처</p>
      </a>
      <a class="issue_video" href="#">
        <img src="${pageContext.request.contextPath}/resources/img/video.png" alt="영상" class="sub_video">
        <span>영상 제목입니다.</span>
        <p>출처</p>
      </a>
      <a class="issue_video" href="#">
        <img src="${pageContext.request.contextPath}/resources/img/video.png" alt="영상" class="sub_video">
        <span>영상 제목입니다.</span>
        <p>출처</p>
      </a>
            
    <hr class="clear_line">
    <hr class="mid_line">
    
    <div id="notice">
      <a href="${pageContext.request.contextPath}/notice_list.do"><span>새로운 소식</span></a>
      <table>
        <tr>
          <td><a href="#">뉴스 제목1</a></td>
        </tr>
        <tr>
          <td><a href="#">뉴스 제목2</a></td>
        </tr>
        <tr>
          <td><a href="#">뉴스 제목3</a></td>
        </tr>
        <tr>
          <td><a href="#">뉴스 제목4</a></td>
        </tr>
        <tr>
          <td><a href="#">뉴스 제목5</a></td>
        </tr>
        <tr>
          <td><a href="#">뉴스 제목6</a></td>
        </tr>
        <tr>
          <td><a href="#">뉴스 제목7</a></td>
        </tr>
        <tr>
          <td><a href="#">뉴스 제목8</a></td>
        </tr>
        <tr>
          <td><a href="#">뉴스 제목9</a></td>
        </tr>
        <tr>
          <td><a href="#">뉴스 제목10</a></td>
        </tr>
      </table>
    </div>
    <div id="board">
      <a href="${pageContext.request.contextPath}/board_list.do""><span>자유 게시판</span></a>
      <table>
        <tr>
          <td><a href="#">자유 게시글 제목1</a></td>
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목2</a></td>
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목3</a></td>
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목4</a></td>
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목5</a></td>
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목6</a></td> 
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목7</a></td> 
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목8</a></td> 
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목9</a></td> 
        </tr>
        <tr>
          <td><a href="#">자유 게시글 제목10</a></td> 
        </tr>
      </table>
    </div> 
       
    <hr class="clear_line">
    
    <div id="mid_banner">
    <a href="#"><img src="${pageContext.request.contextPath}/resources/img/banner00.png" alt="배너" id="banner00" /></a>
    </div>
    
    <hr class="clear_line">
	<div id="video">
    <a href="${pageContext.request.contextPath}/video_list.do""><span>영상 게시판</span></a>
    <hr>
    <div id="video_list">
		<div class="video">
			<% for (VideoVo videoVo : videoList ) {	%>
			<a href="<%=request.getContextPath() %>/video_view.do?video_idx=<%=videoVo.getVideo_idx()%>">
			<table>
				<tr> <td><img src="https://img.youtube.com/vi/<%=videoVo.getFile()%>/hqdefault.jpg" alt="${pageContext.request.contextPath}/resources/img/video.png" /></td> </tr>
				
				<% 
				String title = videoVo.getTitle();
				int title_l = title.length();
				if (title_l >= 16) {
					title = title.substring(0,15);
					title = title + "...";
					// System.out.println("제목 (잘림): "+title);		
				}else {
				// System.out.println("제목: "+title);		
				}
				%>
				<tr> <th><%= title %></th> </tr>
			</table> </a>
			<% } %>
			</div>
		</div>
	</div>
    <hr class="clear_line">

    <div id="rank">
      <p>순위/득점</p>
      <table border="1"> 
        <tr>
          <th>경기날짜</th>
          <th>경기시간</th>
          <th>팀이름1</th>
          <th>아이콘1</th>
          <th>점수</th>
          <th>:</th>
          <th>점수</th>
          <th>아이콘2</th>
          <th>팀이름2</th>
        </tr>
        <tr>
          <td>날짜</td>
          <td>시간</td>
          <td>팀</td>
          <td>아이콘1</td>
          <td>점수</td>
          <td>:</td>
          <td>점수</td>
          <td>아이콘2</td>
          <td>팀</td>
        </tr>
        <tr>
          <td>날짜</td>
          <td>시간</td>
          <td>팀</td>
          <td>아이콘1</td>
          <td>점수</td>
          <td>:</td>
          <td>점수</td>
          <td>아이콘2</td>
          <td>팀</td>
        </tr>
        <tr>
          <td>날짜</td>
          <td>시간</td>
          <td>팀</td>
          <td>아이콘1</td>
          <td>점수</td>
          <td>:</td>
          <td>점수</td>
          <td>아이콘2</td>
          <td>팀</td>
        </tr>
      </table>
    </div>

    <div id="schedule">
      <p>일정/결과</p>
      <table border="1">
        <tr>
          <th>경기날짜</th>
          <th>경기시간</th>
          <th>팀이름1</th>
          <th>아이콘1</th>
          <th>아이콘2</th>
          <th>팀이름2</th>
        </tr>
        <tr>
          <td>날짜</td>
          <td>시간</td>
          <td>팀</td>
          <td>아이콘1</td>
          <td>아이콘2</td>
          <td>팀</td>
        </tr>
        <tr>
          <td>날짜</td>
          <td>시간</td>
          <td>팀</td>
          <td>아이콘1</td>
          <td>아이콘2</td>
          <td>팀</td>
        </tr>
        <tr>
          <td>날짜</td>
          <td>시간</td>
          <td>팀</td>
          <td>아이콘1</td>
          <td>아이콘2</td>
          <td>팀</td>
        </tr>
      </table>
    </div>
    <br><br><br>
<hr class="clear_line">
  </main>

</body>
</html>

<%@ include file = "include/footer.jsp" %> <!-- 풋터 삽입 -->