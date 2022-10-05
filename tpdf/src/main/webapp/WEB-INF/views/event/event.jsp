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
	<c:if test="${loginVO_member_grade == 2}"> <!-- 임시조치. 대소문자 주의! -->
	<button id="event_add" onclick="location.href='${pageContext.request.contextPath}/event_add.do' ">이벤트 추가</button>
	</c:if>
	</c:if>
	</div>


	<c:if test="${!empty eventNow}">
	<div id="yes_event">
	<h1>${eventNow.team_a} vs  ${eventNow.team_b}</h1> 
	<h2>결과를 예측하고 포인트를 획득해보세요!</h2>

		<c:if test="${loginVO_member_grade == 0 && process == 'n'}"> <!-- 임시조치. 대소문자 주의! -->
		<h3>(로그인 후 이용하실 수 있습니다.)</h3>
		</c:if>
		<c:if test="${loginVO_member_grade == 1 && process == 'n'}"> <!-- 임시조치. 대소문자 주의! -->
		<div id="event_user">
		<!-- name값은 controller에서, id값은 자바스크립트쪽에서 사용 -->
			<form name="event_user_set" id="event_user_set" action="${pageContext.request.contextPath}/event_betting_process.do" method="post">
			<div class="betting"><label><input type="radio" class="betting_team" name="betting_team" value="${eventNow.team_a}"  required /> ${eventNow.team_a}</label></div>
			<div class="betting"><label><input type="radio" class="betting_team" name="betting_team" value="${eventNow.team_b}" required /> ${eventNow.team_b}</label></div>
			<div class="betting">
			<input type="hidden" name="member_idx" id="member_idx" value="${loginVO_member_idx}"  required /> <!-- 히든으로 감춰줌 -->
			<input type="number" name="b_point" id="b_point" value="10" min="10" required />
			<button onclick="event_betting(); return false;">베팅하기</button> <!-- return을 통해 기본값이 false로 되게 해줘야 confirm취소시 전송이 안됨 -->
			</div>
		</form>
		</div>
		</c:if>
		<c:if test="${loginVO_member_grade <= 1 && process == 'y'}"> <!-- 임시조치. 대소문자 주의! -->
		<h3>베팅이 종료되었습니다.</h3>
		</c:if>
		<c:if test="${loginVO_member_grade == 2 && process == 'n'}"> <!-- 임시조치. 대소문자 주의! -->
			<button id="event_admin_stop" onclick="event_stop()">베팅 종료</button>
		</c:if>
		
		<c:if test="${loginVO_member_grade == 2 && process == 'y'}"> <!-- 임시조치. 대소문자 주의! -->
			<div id="event_set">
			<form name="event_admin_set" id="event_admin_set" action="${pageContext.request.contextPath}/event_set_process.do" method="post">
			<label><input type="radio" class="betting_team" name="victory_team" id="victory_team" value="${eventNow.team_a}"  required /> ${eventNow.team_a}</label><br>
			<label><input type="radio" class="betting_team" name="victory_team" id="victory_team" value="${eventNow.team_b}" required /> ${eventNow.team_b}</label><br>
			<label><input type="radio" class="betting_team" name="victory_team" id="victory_team" value="무승부" required /> 무승부</label><br>
			<button onclick="event_end_set(); return false;">지급하기</button>
			</form>
			</div>
		</c:if>
	</div>
	</c:if>
	
	<div id="event">
	<table>
		<caption>지난 이벤트 결과 (최근 10개)</caption> 
	        <tr>
	        	<th colspan="3">대결팀</th> <th>참가 인원</th> <th>포인트 총액</th> <th>비율</th> <th>승리팀</th>
	        	<th>당첨자</th>
	        </tr>
		<% for (EventVo eventVo : eventList ) {	%>
	        <tr>
	        	<td><%= eventVo.getTeam_a() %></td> <td>Vs</td> <td><%= eventVo.getTeam_b() %></td>
	        	<td><%= eventVo.getB_person() %>명</td> <td><%= eventVo.getBetting_sum() %></td> <td><%= eventVo.getB_percent_a() %>% : <%= eventVo.getB_percent_b() %>%</td>
	        	<td><%= eventVo.getVictory_team() %></td> <td><%= eventVo.getV_person() %>명</td>
	        </tr>
        <% } %>
        </table>
	</div>
</main>
</body>
</html>

<%@ include file = "../include/footer.jsp" %> <!-- 풋터 삽입 -->