<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/live_video.css">
<body>
  <main>
  	<div id="sub_menu">
  		<a href="${pageContext.request.contextPath}/rank.do">순위표</a> |
  		<a href="${pageContext.request.contextPath}/schedule.do">경기 일정</a> |
		<a href="${pageContext.request.contextPath}/live_video.do">실시간 방송</a>
  	</div>
	<div id="file">
 	<iframe  title="YouTube video player" class="youtube-player" type="text/html"  width="704" height="396" src="//www.youtube.com/embed/CjRNdPMRGpE?autoplay=1&fs=1" frameborder="0" allowfullscreen></iframe>
	<img src="${pageContext.request.contextPath}/resources/img/hot_video.png" alt="영상 썸네일" />
	<div id="title">2022.08.23 I팀 vs J팀 경기 생중계</div>
	<div id="hit">조회수: 1,024</div>|| <div id="wdate">2022.08.23 00:00</div>
	<button id="live_controller" onclick="location.href='${pageContext.request.contextPath}/live_controller.do' ">갱신</button>
	<hr class="mid_line">
	<div id="content">
	I팀과 J팀의 팽팽한 결전!<br>
	<br>
	- 광고 및 스팸, 욕설 등은 처벌받을 수 있습니다.<br>
	 </div>
	</pre>
	</div>
	<div id="point_comment_view"> 	
		<table id="comment_list">
		<tr> <td colspan="3" style="text-align:center; color:green; ">※최근 10개의 항목만 표시됩니다.</td>
		<tr> <th>도레미파솔라시도</div></th> <td>도레미파솔도레미파솔도레미파솔도레미파솔도레미파솔도레미파솔 <div class="comment_remove"><a href="#">Ｘ</a></div> </td> <td class="comment_date">00:00</td> </tr>
		<tr> <th>요약좌</div></th> <td>누가 이길지 너무 기대됨 <div class="comment_remove"><a href="#">Ｘ</a></div> </td> <td class="comment_date">00:02</td> </tr>
		<tr> <th>탁상시계</div></th> <td>뭐야 포인트 내야 되네 이게 맞나..? <div class="comment_remove"><a href="#">Ｘ</a></div> </td> <td class="comment_date">00:02</td> </tr>
		<tr> <th>매일야식물어봄</div></th> <td>야식 추천 좀 <div class="comment_remove"><a href="#">Ｘ</a></div> </td> <td class="comment_date">00:03</td> </tr>
		<tr> <th>소신발언</div></th> <td>솔직히 이게 더 나을수도 있음 물흐리는 사람이 그나마 걸러지니 <div class="comment_remove"><a href="#">Ｘ</a></div> </td> <td class="comment_date">00:04</td> </tr>
		<tr> <th>도배맨</div></th> <td>모르겠고 A선수가 짱 임 <div class="comment_remove"><a href="#">Ｘ</a></div> </td> <td class="comment_date">00:07</td> </tr>
		<tr> <th>도레미파솔라시도</div></th> <td>도레미파솔라시도도레미파솔라시도도레미파솔라시도도레미파솔라<div class="comment_remove"><a href="#">Ｘ</a></div> </td> <td class="comment_date">00:07</td> </tr>
		<tr> <th>소신발언</div></th> <td>좀전에 했던말 취소합니다.. <div class="comment_remove"><a href="#">Ｘ</a></div> </td> <td class="comment_date">00:08</td> </tr>
		 </table>
		
		<div id="point_comment_insert">
		<form action="${pageContext.request.contextPath}/point_comment_insert_process.do" method="post">
		<div id="point_comment_name" name="point_comment_name">이름은최대여덟자</div>
		<textarea id="point_comment_content" name="point_comment_content" rows="10" cols="3" maxlength="30" placeholder="내용 (최대 30자, 띄어쓰기 포함)" required></textarea>
		</form>
		<button id="point_comment_submit" onclick="confirm('100포인트가 소모됩니다.\n정말로 등록하시겠습니까?'); ">등록</button>
		</div>
	</div>
    <br><br><br>
<hr class="clear_line">
  </main>

</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->