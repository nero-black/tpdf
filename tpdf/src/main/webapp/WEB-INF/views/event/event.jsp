<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../include/header.jsp" %> <!-- 헤더 삽입 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL라이브러리 -->
<%@ page import = "com.tpdf.shoot.vo.EventVo" %>  
<%@ page import="java.util.*" %>

<% List<EventVo> eventList = (List)request.getAttribute("eventList"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ShooT :: 비상하는 해외축구 커뮤니티</title>
</head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/event.css">
<script src="${pageContext.request.contextPath}/resources/js/event.js"></script>
<body>
<main>
	<c:if test="${empty eventNow}">
	<div id="no_event">
	<h3>진행중인 이벤트가 없습니다.</h3>
	<button id="event_add" onclick="location.href='${pageContext.request.contextPath}/event_add.do' ">이벤트 추가</button>
	</div>
	<script>
	window.addEventListener('load', function() {  // 관리자 전용 버튼 감추기1
		document.getElementById("event_add").style.display= "none"; // 관리자가 아닐 경우 감추기 (현재 주석처리)
	});
	</script>
	</c:if>

	<c:if test="${!empty eventNow}">
	<div id="yes_event">
	<h1>${eventNow.team_a} vs  ${eventNow.team_b}</h1> 
	<h2>우승팀을 예측하고 포인트를 획득해보세요!</h2>

		<div id="event_user">
		<!-- name값은 controller에서, id값은 자바스크립트쪽에서 사용 -->
			<form name="event_user_set" id="event_user_set" action="${pageContext.request.contextPath}/event_betting_process.do" method="post">
			<div class="betting"><label><input type="radio" class="betting_team" name="betting_team" value="${eventNow.team_a}"  required /> ${eventNow.team_a}</label></div>
			<div class="betting"><label><input type="radio" class="betting_team" name="betting_team" value="${eventNow.team_b}" required /> ${eventNow.team_b}</label></div>
			<div class="betting">
			<input type="text" name="member_idx" id="member_idx" value="1"  required />
			<input type="number" name="betting_point" id="betting_point" value="10" min="10" required />
			<button onclick="event_betting(); return false;">베팅하기</button> <!-- return을 통해 기본값이 false로 되게 해줘야 confirm취소시 전송이 안됨 -->
			</div>
			
		</form>
		</div>
	
		<div id="event_set">
		<form name="event_admin_set" id="event_admin_set" action="${pageContext.request.contextPath}/event_set_process.do" method="post">
		<label><input type="radio" class="betting_team" name="betting_team" value="a"  required /> I팀</label>
		<label><input type="radio" class="betting_team" name="betting_team" value="b" required /> J팀</label>
		<label><input type="radio" class="betting_team" name="betting_team" value="draw" required /> 무승부</label>
		<button onclick="confirm('정말로 이벤트를 종료하고\n포인트를 지급하시겠습니까?');">지급하기</button>
		</form>
		</div>
	
	</div>
	<script>
	window.addEventListener('load', function() {  // 관리자 전용 버튼 감추기2
		// document.getElementById("event_add").style.display= "none"; // 진행중인 이벤트가 존재하는 경우 감추기
	});
	</script>
	</c:if>
	
	<div id="event">
	<table>
		<caption>지난 이벤트 결과 (최근 10개)</caption> 
	        <tr>
	        	<th colspan="3">대결팀</th> <th>참가 인원</th> <th>포인트 총액</th> <th>배당률</th> <th>승리팀</th>
	        	<th>당첨자</th> <th>인당 포인트</th>
	        </tr>
		<% for (EventVo eventVo : eventList ) {	%>
	        <tr>
	        	<td><%= eventVo.getTeam_a() %></td> <td>Vs</td> <td><%= eventVo.getTeam_b() %></td>
	        	<td>999999명</td> <td><%= eventVo.getBetting_sum() %>100000</td> <td><%= eventVo.getB_percent_a() %>00 : <%= eventVo.getB_percent_b() %>00</td>
	        	<td><%= eventVo.getVictory_team() %>첫 번째팀의 이름을 공개</td> <td><%= eventVo.getV_person_point() %>50000명</td> <td>1000? P</td>
	        </tr>
        <% } %>
        </table>
	</div>
</main>
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->