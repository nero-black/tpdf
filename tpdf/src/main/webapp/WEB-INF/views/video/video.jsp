<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->
<%@ page import = "com.tpdf.shoot.vo.VideoVo" %>  
<%@ page import="java.util.*" %>

<% List<VideoVo> videoList = (List)request.getAttribute("videoList"); %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/video.css">
<body>
<main>

	<c:if test="${ member_grade == 2 }">
	<button id="video_insert" onclick="location.href='${pageContext.request.contextPath}/video_insert.do'">업로드</button>
	</c:if>
	
	<div id="search">
		<p>제목: </p>
		<form name="search_form" action="${pageContext.request.contextPath}/video_search.do">
		<input type="text" id="search_value" name="search_value" placeholder="검색할 내용 입력" />
		<button id="search_submit">검색</button>
		</form>
	</div>
	<hr class="clear_line">
	<hr>
	<br>

<c:if test="${empty videoList}">
<table id="empty_list">
	<tr><td>업로드된 영상이 없습니다.</td></tr>
</table>
</c:if>
<div id="video">

<% for (VideoVo videoVo : videoList ) {	%>
<a href="<%=request.getContextPath() %>/video_view.do?video_idx=<%=videoVo.getVideo_idx()%>">
<table>
	<tr> <td colspan="3"><img src="https://img.youtube.com/vi/<%=videoVo.getFile()%>/hqdefault.jpg" alt="${pageContext.request.contextPath}/resources/img/video.png" /></td> </tr>
	
	
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
	<tr> <th colspan="3"><%= title %></th> </tr> <tr> <td class="video_hit">조회수 : <%= videoVo.getHit() %></td> <td class="video_edge"> </td>
	<td class="video_date"> <%= videoVo.getWdate_d() %> </td> </tr>
</table> </a>
<% } %>
</div>

</main>
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->