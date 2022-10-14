package com.tpdf.shoot.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonInclude;

@Controller
public class EtcController {
	
	@GetMapping("/rank.do")
	public String rank() {
		return "etc/rank";
	}
	@GetMapping("/rank2.do")
	public String rank2() {
		return "etc/rank2";
	}
	@GetMapping("/rank3.do")
	public String rank3() {
		return "etc/rank3";
	}
	@GetMapping("/rank4.do")
	public String rank4() {
		return "etc/rank4";
	}
	@GetMapping("/rank5.do")
	public String rank5() {
		return "etc/rank5";
	}
	

	
	@GetMapping("/schedule.do")
	public String schedule() {
		return "etc/schedule";
	}
	@GetMapping("/schedule2.do")
	public String schedule2() {
		return "etc/schedule2";
	}
	@GetMapping("/schedule3.do")
	public String schedule3() {
		return "etc/schedule3";
	}
	@GetMapping("/schedule4.do")
	public String schedule4() {
		return "etc/schedule4";
	}
	@GetMapping("/schedule5.do")
	public String schedule5() {
		return "etc/schedule5";
	}
	
	
	
	
	@GetMapping("/schedule_data.do")
	@ResponseBody
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public JSONObject scheduleajax() throws Exception {
		//매개변수 포함하여 api 주소 만들기
		String address="https://api.football-data.org/v4/competitions/PL/matches";

		//객체 생성 및 url 연결
		URL url = new URL(address);
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("X-Auth-token", "d5e1fe0b1f084179af33060ed794581f");
	
		//데이터 받아오기
		InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String line;
		line = br.readLine();
		//파싱 
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(line);
		
		
		
		
		//오브젝트 배열
		JSONObject filtersObject = (JSONObject)jsonObject.get("filters");
		JSONObject resultObject = (JSONObject)jsonObject.get("resultSet");
		JSONObject competitionObject = (JSONObject)jsonObject.get("competition");
		
		

		
		//스탠딩 배열
		JSONArray matchesArray = (JSONArray)jsonObject.get("matches");
		for(int i=0;i<matchesArray.size();i++){
			JSONObject first = (JSONObject)matchesArray.get(i);
			
			JSONObject teamObject1 = (JSONObject)first.get("homeTeam");
			
			
			teamObject1.replace("name", "Arsenal FC", "아스날 FC");
			teamObject1.replace("name", "Manchester City FC", "맨체스터 시티 FC");
			teamObject1.replace("name", "Tottenham Hotspur FC", "토트넘 홋스퍼 FC");
			teamObject1.replace("name", "Brighton & Hove Albion FC", "브라이튼 앤 호브 알비온 FC");
			teamObject1.replace("name", "Manchester United FC", "맨체스터 유나이티드 FC");
			teamObject1.replace("name", "Fulham FC", "풀럼 FC");
			teamObject1.replace("name", "Chelsea FC", "첼시 FC");
			teamObject1.replace("name", "Liverpool FC", "리버풀 FC");
			teamObject1.replace("name", "Brentford FC", "브렌트포드 FC");
			teamObject1.replace("name", "Newcastle United FC", "뉴캐슬 유나이티드 FC");
			teamObject1.replace("name", "Leeds United FC", "리즈 유나이티드 FC");
			teamObject1.replace("name", "AFC Bournemouth", "AFC 본머스");
			teamObject1.replace("name", "Aston Villa FC", "아스톤 빌라 FC");
			teamObject1.replace("name", "Southampton FC", "사우스햄튼 FC");
			teamObject1.replace("name", "Aston Villa FC", "에버튼 FC");
			teamObject1.replace("name", "Crystal Palace FC", "크리스탈 팰리스 FC");
			teamObject1.replace("name", "Wolverhampton Wanderers FC", "울버햄튼 원더러스 FC");
			teamObject1.replace("name", "West Ham United FC", "웨스트햄 유나이티드 FC");
			teamObject1.replace("name", "Nottingham Forest FC", "노팅엄 포레스트 FC");
			teamObject1.replace("name", "Leicester City FC", "레스터 시티 FC");
			teamObject1.replace("name", "Everton FC", "에버튼 FC");
			
			JSONObject teamObject2 = (JSONObject)first.get("awayTeam");
			
			teamObject2.replace("name", "Arsenal FC", "아스날 FC");
			teamObject2.replace("name", "Manchester City FC", "맨체스터 시티 FC");
			teamObject2.replace("name", "Tottenham Hotspur FC", "토트넘 홋스퍼 FC");
			teamObject2.replace("name", "Brighton & Hove Albion FC", "브라이튼 앤 호브 알비온 FC");
			teamObject2.replace("name", "Manchester United FC", "맨체스터 유나이티드 FC");
			teamObject2.replace("name", "Fulham FC", "풀럼 FC");
			teamObject2.replace("name", "Chelsea FC", "첼시 FC");
			teamObject2.replace("name", "Liverpool FC", "리버풀 FC");
			teamObject2.replace("name", "Brentford FC", "브렌트포드 FC");
			teamObject2.replace("name", "Newcastle United FC", "뉴캐슬 유나이티드 FC");
			teamObject2.replace("name", "Leeds United FC", "리즈 유나이티드 FC");
			teamObject2.replace("name", "AFC Bournemouth", "AFC 본머스");
			teamObject2.replace("name", "Aston Villa FC", "아스톤 빌라 FC");
			teamObject2.replace("name", "Southampton FC", "사우스햄튼 FC");
			teamObject2.replace("name", "Aston Villa FC", "에버튼 FC");
			teamObject2.replace("name", "Crystal Palace FC", "크리스탈 팰리스 FC");
			teamObject2.replace("name", "Wolverhampton Wanderers FC", "울버햄튼 원더러스 FC");
			teamObject2.replace("name", "West Ham United FC", "웨스트햄 유나이티드 FC");
			teamObject2.replace("name", "Nottingham Forest FC", "노팅엄 포레스트 FC");
			teamObject2.replace("name", "Leicester City FC", "레스터 시티 FC");
			teamObject2.replace("name", "Everton FC", "에버튼 FC");
			
			String area = first.get("area").toString();
			String competition = first.get("competition").toString();
			String season = first.get("season").toString();
			String id = first.get("id").toString();
			String utcDate = first.get("utcDate").toString();
			String status = first.get("status").toString();
			String stage = first.get("stage").toString();
			//작업예정 09.21
			/* String group = first.get("group").toString(); */  //null값 제외가 안되서 주석처리
			String homeTeam = first.get("homeTeam").toString();
			String awayTeam = first.get("awayTeam").toString();
			String score = first.get("score").toString();
			
			
			
			
			
				 
			
		}
		return jsonObject;
	}
	
	@GetMapping("/schedule_data2.do")
	@ResponseBody
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public JSONObject scheduleajax2() throws Exception {
		//매개변수 포함하여 api 주소 만들기
		String address="https://api.football-data.org/v4/competitions/CL/matches";

		//객체 생성 및 url 연결
		URL url = new URL(address);
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("X-Auth-token", "d5e1fe0b1f084179af33060ed794581f");
	
		//데이터 받아오기
		InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String line;
		line = br.readLine();
		//파싱 
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(line);
		
		
		
		//오브젝트 배열
		JSONObject filtersObject = (JSONObject)jsonObject.get("filters");
		JSONObject resultObject = (JSONObject)jsonObject.get("resultSet");
		JSONObject competitionObject = (JSONObject)jsonObject.get("competition");
		
		

		
		//스탠딩 배열
		JSONArray matchesArray = (JSONArray)jsonObject.get("matches");
		for(int i=0;i<matchesArray.size();i++){
			JSONObject first = (JSONObject)matchesArray.get(i);
			
			JSONObject teamObject1 = (JSONObject)first.get("homeTeam");
			JSONObject teamObject2 = (JSONObject)first.get("awayTeam");
			
			
			teamObject1.replace("name", "SSC Napoli", "SSC 나폴리");
			teamObject1.replace("name", "Liverpool FC", "리버풀 FC");
			teamObject1.replace("name", "AFC Ajax", "AFC 아약스");
			teamObject1.replace("name", "Rangers FC", "레인져스 FC");
			teamObject1.replace("name", "Club Brugge KV", "클럽 브뤼헤 KV");
			teamObject1.replace("name", "Bayer 04 Leverkusen", "바이어 04 레버쿠젠");
			teamObject1.replace("name", "Club Atlético de Madrid", "아틀렌티코 마드리드");
			teamObject1.replace("name", "FC Porto", "FC 포르투");
			teamObject1.replace("name", "FC Bayern München", "FC 바이에른 뮌헨");
			teamObject1.replace("name", "FC Barcelona", "FC 바르셀로나");
			teamObject1.replace("name", "FC Internazionale Milano", "FC 인터밀란");
			teamObject1.replace("name", "FC Viktoria Plzeň", "FC 빅토리아 플첸");
			teamObject1.replace("name", "Sporting Clube de Portugal", "스포르팅");
			teamObject1.replace("name", "Tottenham Hotspur FC", "토트넘 핫스퍼 FC");
			teamObject1.replace("name", "Eintracht Frankfurt", "아인하르트 프랑크푸르트");
			teamObject1.replace("name", "Olympique de Marseille", "올랭피크 드 마르세유");
			teamObject1.replace("name", "AC Milan", "AC 밀란");
			teamObject1.replace("name", "GNK Dinamo Zagreb", "GNK 디나모 자그레브");
			teamObject1.replace("name", "FC Red Bull Salzburg", "FC 레드불 잘츠부르크");
			teamObject1.replace("name", "Chelsea FC", "첼시 FC");
			teamObject1.replace("name", "Real Madrid CF", "레알 마드리드 FC");
			teamObject1.replace("name", "FK Shakhtar Donetsk", "FC 샤흐타르 도네츠크");
			teamObject1.replace("name", "Celtic FC", "셀틱 FC");
			teamObject1.replace("name", "RB Leipzig", "RB 라이프치히");
			teamObject1.replace("name", "Manchester City FC", "맨체스터 시티 FC");
			teamObject1.replace("name", "Borussia Dortmund", "보루시아 도르트문트");
			teamObject1.replace("name", "FC København", "FC 코펜하겐");
			teamObject1.replace("name", "Sevilla FC", "세비야 FC");
			teamObject1.replace("name", "Paris Saint-Germain FC", "파리 생제르망 FC");
			teamObject1.replace("name", "Sport Lisboa e Benfica", "SL 벤피카");
			teamObject1.replace("name", "Juventus FC", "유벤투스 FC");
			teamObject1.replace("name", "Maccabi Haifa FC", "마카비 하이파");
			
			
			
			teamObject2.replace("name", "SSC Napoli", "SSC 나폴리");
			teamObject2.replace("name", "Liverpool FC", "리버풀 FC");
			teamObject2.replace("name", "AFC Ajax", "AFC 아약스");
			teamObject2.replace("name", "Rangers FC", "레인져스 FC");
			teamObject2.replace("name", "Club Brugge KV", "클럽 브뤼헤 KV");
			teamObject2.replace("name", "Bayer 04 Leverkusen", "바이어 04 레버쿠젠");
			teamObject2.replace("name", "Club Atlético de Madrid", "아틀렌티코 마드리드");
			teamObject2.replace("name", "FC Porto", "FC 포르투");
			teamObject2.replace("name", "FC Bayern München", "FC 바이에른 뮌헨");
			teamObject2.replace("name", "FC Barcelona", "FC 바르셀로나");
			teamObject2.replace("name", "FC Internazionale Milano", "FC 인터밀란");
			teamObject2.replace("name", "FC Viktoria Plzeň", "FC 빅토리아 플첸");
			teamObject2.replace("name", "Sporting Clube de Portugal", "스포르팅");
			teamObject2.replace("name", "Tottenham Hotspur FC", "토트넘 핫스퍼 FC");
			teamObject2.replace("name", "Eintracht Frankfurt", "아인하르트 프랑크푸르트");
			teamObject2.replace("name", "Olympique de Marseille", "올랭피크 드 마르세유");
			teamObject2.replace("name", "AC Milan", "AC 밀란");
			teamObject2.replace("name", "GNK Dinamo Zagreb", "GNK 디나모 자그레브");
			teamObject2.replace("name", "FC Red Bull Salzburg", "FC 레드불 잘츠부르크");
			teamObject2.replace("name", "Chelsea FC", "첼시 FC");
			teamObject2.replace("name", "Real Madrid CF", "레알 마드리드 FC");
			teamObject2.replace("name", "FK Shakhtar Donetsk", "FC 샤흐타르 도네츠크");
			teamObject2.replace("name", "Celtic FC", "셀틱 FC");
			teamObject2.replace("name", "RB Leipzig", "RB 라이프치히");
			teamObject2.replace("name", "Manchester City FC", "맨체스터 시티 FC");
			teamObject2.replace("name", "Borussia Dortmund", "보루시아 도르트문트");
			teamObject2.replace("name", "FC København", "FC 코펜하겐");
			teamObject2.replace("name", "Sevilla FC", "세비야 FC");
			teamObject2.replace("name", "Paris Saint-Germain FC", "파리 생제르망 FC");
			teamObject2.replace("name", "Sport Lisboa e Benfica", "SL 벤피카");
			teamObject2.replace("name", "Juventus FC", "유벤투스 FC");
			teamObject2.replace("name", "Maccabi Haifa FC", "마카비 하이파");
			
			String area = first.get("area").toString();
			String competition = first.get("competition").toString();
			String season = first.get("season").toString();
			String id = first.get("id").toString();
			String utcDate = first.get("utcDate").toString();
			String status = first.get("status").toString();
			String stage = first.get("stage").toString();
			//작업예정 09.21
			/* String group = first.get("group").toString(); */  //null값 제외가 안되서 주석처리
			String homeTeam = first.get("homeTeam").toString();
			String awayTeam = first.get("awayTeam").toString();
			String score = first.get("score").toString();
			
			
			
			
			
				 
			
		}
		return jsonObject;
	}
	@GetMapping("/schedule_data3.do")
	@ResponseBody
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public JSONObject scheduleajax3() throws Exception {
		//매개변수 포함하여 api 주소 만들기
		String address="https://api.football-data.org/v4/competitions/PD/matches";

		//객체 생성 및 url 연결
		URL url = new URL(address);
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("X-Auth-token", "d5e1fe0b1f084179af33060ed794581f");
	
		//데이터 받아오기
		InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String line;
		line = br.readLine();
		//파싱 
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(line);
		
		
		
		//오브젝트 배열
		JSONObject filtersObject = (JSONObject)jsonObject.get("filters");
		JSONObject resultObject = (JSONObject)jsonObject.get("resultSet");
		JSONObject competitionObject = (JSONObject)jsonObject.get("competition");
		
		

		
		//스탠딩 배열
		JSONArray matchesArray = (JSONArray)jsonObject.get("matches");
		for(int i=0;i<matchesArray.size();i++){
			JSONObject first = (JSONObject)matchesArray.get(i);
			
			JSONObject teamObject1 = (JSONObject)first.get("homeTeam");
			
			teamObject1.replace("name", "Real Madrid CF", "레알 마드리드 CF");
			teamObject1.replace("name", "FC Barcelona", "FC 바르셀로나");
			teamObject1.replace("name", "Real Betis Balompié", "레알 베티스 발롬피에");
			teamObject1.replace("name", "Athletic Club", "아틀레틱 빌바오");
			teamObject1.replace("name", "CA Osasuna", "CA 오사수나");
			teamObject1.replace("name", "Villarreal CF", "비야 레알 CF");
			teamObject1.replace("name", "Club Atlético de Madrid", "아틀렌티코 마드리드");
			teamObject1.replace("name", "Valencia CF", "발렌시아 CF");
			teamObject1.replace("name", "RCD Mallorca", "RCD 마요르카");
			teamObject1.replace("name", "Girona FC", "지로나 FC");
			teamObject1.replace("name", "Rayo Vallecano de Madrid", "라요 바예카노");
			teamObject1.replace("name", "RC Celta de Vigo", "셀타 비고");
			teamObject1.replace("name", "Getafe CF", "헤타페 CF");
			teamObject1.replace("name", "Sevilla FC", "세이뱌 FC");
			teamObject1.replace("name", "UD Almería", "UD 알메리아");
			teamObject1.replace("name", "RCD Espanyol de Barcelona", "RCD 에스파뇰");
			teamObject1.replace("name", "Real Valladolid CF", "레알 바야돌리드");
			teamObject1.replace("name", "Cádiz CF", "카디스 CF");
			teamObject1.replace("name", "Elche CF", "엘체 CF");
			teamObject1.replace("name", "Real Sociedad de Fútbol", "레알 소시에다드");
			
			JSONObject teamObject2 = (JSONObject)first.get("awayTeam");
			
			teamObject2.replace("name", "Real Madrid CF", "레알 마드리드 CF");
			teamObject2.replace("name", "FC Barcelona", "FC 바르셀로나");
			teamObject2.replace("name", "Real Betis Balompié", "레알 베티스 발롬피에");
			teamObject2.replace("name", "Athletic Club", "아틀레틱 빌바오");
			teamObject2.replace("name", "CA Osasuna", "CA 오사수나");
			teamObject2.replace("name", "Villarreal CF", "비야 레알 CF");
			teamObject2.replace("name", "Club Atlético de Madrid", "아틀렌티코 마드리드");
			teamObject2.replace("name", "Valencia CF", "발렌시아 CF");
			teamObject2.replace("name", "RCD Mallorca", "RCD 마요르카");
			teamObject2.replace("name", "Girona FC", "지로나 FC");
			teamObject2.replace("name", "Rayo Vallecano de Madrid", "라요 바예카노");
			teamObject2.replace("name", "RC Celta de Vigo", "셀타 비고");
			teamObject2.replace("name", "Getafe CF", "헤타페 CF");
			teamObject2.replace("name", "Sevilla FC", "세이뱌 FC");
			teamObject2.replace("name", "UD Almería", "UD 알메리아");
			teamObject2.replace("name", "RCD Espanyol de Barcelona", "RCD 에스파뇰");
			teamObject2.replace("name", "Real Valladolid CF", "레알 바야돌리드");
			teamObject2.replace("name", "Cádiz CF", "카디스 CF");
			teamObject2.replace("name", "Elche CF", "엘체 CF");
			teamObject2.replace("name", "Real Sociedad de Fútbol", "레알 소시에다드");
			
			String area = first.get("area").toString();
			String competition = first.get("competition").toString();
			String season = first.get("season").toString();
			String id = first.get("id").toString();
			String utcDate = first.get("utcDate").toString();
			String status = first.get("status").toString();
			String stage = first.get("stage").toString();
			//작업예정 09.21
			/* String group = first.get("group").toString(); */  //null값 제외가 안되서 주석처리
			String homeTeam = first.get("homeTeam").toString();
			String awayTeam = first.get("awayTeam").toString();
			String score = first.get("score").toString();
			
			
			
			
			
				 
			
		}
		return jsonObject;
	}
	
	@GetMapping("/schedule_data4.do")
	@ResponseBody
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public JSONObject scheduleajax4() throws Exception {
		//매개변수 포함하여 api 주소 만들기
		String address="https://api.football-data.org/v4/competitions/BL1/matches";

		//객체 생성 및 url 연결
		URL url = new URL(address);
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("X-Auth-token", "d5e1fe0b1f084179af33060ed794581f");
	
		//데이터 받아오기
		InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String line;
		line = br.readLine();
		//파싱 
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(line);
		
		
		
		//오브젝트 배열
		JSONObject filtersObject = (JSONObject)jsonObject.get("filters");
		JSONObject resultObject = (JSONObject)jsonObject.get("resultSet");
		JSONObject competitionObject = (JSONObject)jsonObject.get("competition");
		
		

		
		//스탠딩 배열
		JSONArray matchesArray = (JSONArray)jsonObject.get("matches");
		for(int i=0;i<matchesArray.size();i++){
			JSONObject first = (JSONObject)matchesArray.get(i);
			
			JSONObject teamObject1 = (JSONObject)first.get("homeTeam");
			
			teamObject1.replace("name", "1. FC Union Berlin", "유니온 베를린");
			teamObject1.replace("name", "Borussia Dortmund", "보루시아 도르트문트");
			teamObject1.replace("name", "SC Freiburg", "SC 프라이부르크");
			teamObject1.replace("name", "TSG 1899 Hoffenheim", "TSG 1899 호펜하임");
			teamObject1.replace("name", "FC Bayern München", "FC 바이에른 뮌헨");
			teamObject1.replace("name", "Borussia Mönchengladbach", "보루시아 묀헨글라트바흐");
			teamObject1.replace("name", "Eintracht Frankfurt", "아인트하르트 프랑크푸르트");
			teamObject1.replace("name", "1. FSV Mainz 05", "FSV 마인츠 05");
			teamObject1.replace("name", "1. FC Köln", "FC 쾰른");
			teamObject1.replace("name", "SV Werder Bremen", "SV 베르더 브레멘");
			teamObject1.replace("name", "FC Augsburg", "FC 아우크스부르크");
			teamObject1.replace("name", "RB Leipzig", "RB 라이프치히");
			teamObject1.replace("name", "Hertha BSC", "헤르타 BSC");
			teamObject1.replace("name", "FC Schalke 04", "FC 샬케 04");
			teamObject1.replace("name", "Bayer 04 Leverkusen", "바이어 04 레버쿠젠");
			teamObject1.replace("name", "VfB Stuttgart", "VFB 슈투트가르트");
			teamObject1.replace("name", "VfL Wolfsburg", "VFL 볼프스부르그");
			teamObject1.replace("name", "VfL Bochum 1848", "VFL 보훔");
			
			JSONObject teamObject2 = (JSONObject)first.get("awayTeam");
			
			teamObject2.replace("name", "1. FC Union Berlin", "유니온 베를린");
			teamObject2.replace("name", "Borussia Dortmund", "보루시아 도르트문트");
			teamObject2.replace("name", "SC Freiburg", "SC 프라이부르크");
			teamObject2.replace("name", "TSG 1899 Hoffenheim", "TSG 1899 호펜하임");
			teamObject2.replace("name", "FC Bayern München", "FC 바이에른 뮌헨");
			teamObject2.replace("name", "Borussia Mönchengladbach", "보루시아 묀헨글라트바흐");
			teamObject2.replace("name", "Eintracht Frankfurt", "아인트하르트 프랑크푸르트");
			teamObject2.replace("name", "1. FSV Mainz 05", "FSV 마인츠 05");
			teamObject2.replace("name", "1. FC Köln", "FC 쾰른");
			teamObject2.replace("name", "SV Werder Bremen", "SV 베르더 브레멘");
			teamObject2.replace("name", "FC Augsburg", "FC 아우크스부르크");
			teamObject2.replace("name", "RB Leipzig", "RB 라이프치히");
			teamObject2.replace("name", "Hertha BSC", "헤르타 BSC");
			teamObject2.replace("name", "FC Schalke 04", "FC 샬케 04");
			teamObject2.replace("name", "Bayer 04 Leverkusen", "바이어 04 레버쿠젠");
			teamObject2.replace("name", "VfB Stuttgart", "VFB 슈투트가르트");
			teamObject2.replace("name", "VfL Wolfsburg", "VFL 볼프스부르그");
			teamObject2.replace("name", "VfL Bochum 1848", "VFL 보훔");
			
			String area = first.get("area").toString();
			String competition = first.get("competition").toString();
			String season = first.get("season").toString();
			String id = first.get("id").toString();
			String utcDate = first.get("utcDate").toString();
			String status = first.get("status").toString();
			String stage = first.get("stage").toString();
			//작업예정 09.21
			/* String group = first.get("group").toString(); */  //null값 제외가 안되서 주석처리
			String homeTeam = first.get("homeTeam").toString();
			String awayTeam = first.get("awayTeam").toString();
			String score = first.get("score").toString();
			
			
			
			
			
				 
			
		}
		return jsonObject;
	}
	
	@GetMapping("/schedule_data5.do")
	@ResponseBody
	@JsonInclude(JsonInclude.Include.NON_NULL)
	public JSONObject scheduleajax5() throws Exception {
		//매개변수 포함하여 api 주소 만들기
		String address="https://api.football-data.org/v4/competitions/SA/matches";

		//객체 생성 및 url 연결
		URL url = new URL(address);
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("X-Auth-token", "d5e1fe0b1f084179af33060ed794581f");
	
		//데이터 받아오기
		InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String line;
		line = br.readLine();
		//파싱 
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(line);
		
		
		
		//오브젝트 배열
		JSONObject filtersObject = (JSONObject)jsonObject.get("filters");
		JSONObject resultObject = (JSONObject)jsonObject.get("resultSet");
		JSONObject competitionObject = (JSONObject)jsonObject.get("competition");
		
		

		
		//스탠딩 배열
		JSONArray matchesArray = (JSONArray)jsonObject.get("matches");
		for(int i=0;i<matchesArray.size();i++){
			JSONObject first = (JSONObject)matchesArray.get(i);
			
			JSONObject teamObject1 = (JSONObject)first.get("homeTeam");
			
			teamObject1.replace("name", "SSC Napoli", "SSC 나폴리");
			teamObject1.replace("name", "Atalanta BC", "아틀란타 BC");
			teamObject1.replace("name", "Udinese Calcio", "우디네세 칼초");
			teamObject1.replace("name", "SS Lazio", "SS 라치오");
			teamObject1.replace("name", "AC Milan", "AC 밀란");
			teamObject1.replace("name", "AS Roma", "AS 로마");
			teamObject1.replace("name", "FC Internazionale Milano", "FC 인터밀란");
			teamObject1.replace("name", "Juventus FC", "유벤투스 FC");
			teamObject1.replace("name", "Torino FC", "토리노 FC");
			teamObject1.replace("name", "ACF Fiorentina", "FC 피오렌티나");
			teamObject1.replace("name", "US Sassuolo Calcio", "US 사수올로 칼초");
			teamObject1.replace("name", "Spezia Calcio", "스페치아 칼초");
			teamObject1.replace("name", "US Salernitana 1919", "US 살레르리타나");
			teamObject1.replace("name", "Empoli FC", "엠폴리 FC");
			teamObject1.replace("name", "US Lecce", "US 레체");
			teamObject1.replace("name", "Bologna FC 1909", "볼로냐 FC");
			teamObject1.replace("name", "Hellas Verona FC", "엘라스 베로나");
			teamObject1.replace("name", "AC Monza", "AC 몬차");
			teamObject1.replace("name", "US Cremonese", "US 크레모네세");
			teamObject1.replace("name", "UC Sampdoria", "UC 샴프도리아");
			
			JSONObject teamObject2 = (JSONObject)first.get("awayTeam");
			
			teamObject2.replace("name", "SSC Napoli", "SSC 나폴리");
			teamObject2.replace("name", "Atalanta BC", "아틀란타 BC");
			teamObject2.replace("name", "Udinese Calcio", "우디네세 칼초");
			teamObject2.replace("name", "SS Lazio", "SS 라치오");
			teamObject2.replace("name", "AC Milan", "AC 밀란");
			teamObject2.replace("name", "AS Roma", "AS 로마");
			teamObject2.replace("name", "FC Internazionale Milano", "FC 인터밀란");
			teamObject2.replace("name", "Juventus FC", "유벤투스 FC");
			teamObject2.replace("name", "Torino FC", "토리노 FC");
			teamObject2.replace("name", "ACF Fiorentina", "FC 피오렌티나");
			teamObject2.replace("name", "US Sassuolo Calcio", "US 사수올로 칼초");
			teamObject2.replace("name", "Spezia Calcio", "스페치아 칼초");
			teamObject2.replace("name", "US Salernitana 1919", "US 살레르리타나");
			teamObject2.replace("name", "Empoli FC", "엠폴리 FC");
			teamObject2.replace("name", "US Lecce", "US 레체");
			teamObject2.replace("name", "Bologna FC 1909", "볼로냐 FC");
			teamObject2.replace("name", "Hellas Verona FC", "엘라스 베로나");
			teamObject2.replace("name", "AC Monza", "AC 몬차");
			teamObject2.replace("name", "US Cremonese", "US 크레모네세");
			teamObject2.replace("name", "UC Sampdoria", "UC 샴프도리아");
			
			String area = first.get("area").toString();
			String competition = first.get("competition").toString();
			String season = first.get("season").toString();
			String id = first.get("id").toString();
			String utcDate = first.get("utcDate").toString();
			String status = first.get("status").toString();
			String stage = first.get("stage").toString();
			//작업예정 09.21
			/* String group = first.get("group").toString(); */  //null값 제외가 안되서 주석처리
			String homeTeam = first.get("homeTeam").toString();
			String awayTeam = first.get("awayTeam").toString();
			String score = first.get("score").toString();
			
			
			
			
			
				 
			
		}
		return jsonObject;
	}
	
	@GetMapping("/data.do")
	@ResponseBody
	public JSONObject ajax1() throws Exception {
		//return "etc/data";
		//매개변수 포함하여 api 주소 만들기
		String address= "https://api.football-data.org/v4/competitions/PL/standings";

		//객체 생성 및 url 연결
		URL url = new URL(address);
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("X-Auth-token", "d5e1fe0b1f084179af33060ed794581f");
	
		//데이터 받아오기
		InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String line;
		line = br.readLine();
		//파싱 
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(line);
		
		
		
		
		
		
		//오브젝트 배열
		JSONObject filtersObject = (JSONObject)jsonObject.get("filters");
		JSONObject areaObject = (JSONObject)jsonObject.get("area");
		JSONObject competitionObject = (JSONObject)jsonObject.get("competition");
		JSONObject seasonObject = (JSONObject)jsonObject.get("season");
		

		
		//스탠딩 배열
		JSONArray standingsArray = (JSONArray)jsonObject.get("standings");
		for(int i=0;i<standingsArray.size();i++){
			JSONObject first = (JSONObject)standingsArray.get(i);
			String stage = first.get("stage").toString();
			String type = first.get("type").toString();
			
			
			JSONArray tableArray = (JSONArray)first.get("table");
			for(int j=0;j<tableArray.size();j++){
					JSONObject second = (JSONObject)tableArray.get(j);
					String position = second.get("position").toString();
					//내부오브젝트 
					JSONObject teamObject = (JSONObject)second.get("team");
					//번역 
					teamObject.replace("name", "Arsenal FC", "아스날 FC");
					teamObject.replace("name", "Manchester City FC", "맨체스터 시티 FC");
					teamObject.replace("name", "Tottenham Hotspur FC", "토트넘 홋스퍼 FC");
					teamObject.replace("name", "Brighton & Hove Albion FC", "브라이튼 앤 호브 알비온 FC");
					teamObject.replace("name", "Manchester United FC", "맨체스터 유나이티드 FC");
					teamObject.replace("name", "Fulham FC", "풀럼 FC");
					teamObject.replace("name", "Chelsea FC", "첼시 FC");
					teamObject.replace("name", "Liverpool FC", "리버풀 FC");
					teamObject.replace("name", "Brentford FC", "브렌트포드 FC");
					teamObject.replace("name", "Newcastle United FC", "뉴캐슬 유나이티드 FC");
					teamObject.replace("name", "Leeds United FC", "리즈 유나이티드 FC");
					teamObject.replace("name", "AFC Bournemouth", "AFC 본머스");
					teamObject.replace("name", "Aston Villa FC", "아스톤 빌라 FC");
					teamObject.replace("name", "Southampton FC", "사우스햄튼 FC");
					teamObject.replace("name", "Aston Villa FC", "에버튼 FC");
					teamObject.replace("name", "Crystal Palace FC", "크리스탈 팰리스 FC");
					teamObject.replace("name", "Wolverhampton Wanderers FC", "울버햄튼 원더러스 FC");
					teamObject.replace("name", "West Ham United FC", "웨스트햄 유나이티드 FC");
					teamObject.replace("name", "Nottingham Forest FC", "노팅엄 포레스트 FC");
					teamObject.replace("name", "Leicester City FC", "레스터 시티 FC");
					teamObject.replace("name", "Everton FC", "에버튼 FC");
					

					String playedGames = second.get("playedGames").toString();
					String won = second.get("won").toString();
					String form = second.get("form").toString();
					String draw = second.get("draw").toString();
					String lost = second.get("lost").toString();
					String points = second.get("points").toString();
					String goalsFor = second.get("goalsFor").toString();
					String goalsAgainst = second.get("goalsAgainst").toString();
					String goalDifference = second.get("goalDifference").toString();				
		
				 }
				 
			
		}
		return jsonObject;
	}
		
	
	@GetMapping("/data2.do")
	@ResponseBody
	public JSONObject ajax2() throws Exception {
		//return "etc/data";
		//매개변수 포함하여 api 주소 만들기
		String address= "https://api.football-data.org/v4/competitions/CL/standings";

		//객체 생성 및 url 연결
		URL url = new URL(address);
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("X-Auth-token", "d5e1fe0b1f084179af33060ed794581f");
	
		//데이터 받아오기
		InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String line;
		line = br.readLine();
		//파싱 
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(line);
		
		
		
		//오브젝트 배열
		JSONObject filtersObject = (JSONObject)jsonObject.get("filters");
		JSONObject areaObject = (JSONObject)jsonObject.get("area");
		JSONObject competitionObject = (JSONObject)jsonObject.get("competition");
		JSONObject seasonObject = (JSONObject)jsonObject.get("season");
		

		
		//스탠딩 배열
		JSONArray standingsArray = (JSONArray)jsonObject.get("standings");
		for(int i=0;i<standingsArray.size();i++){
			JSONObject first = (JSONObject)standingsArray.get(i);
			String stage = first.get("stage").toString();
			String type = first.get("type").toString();
			
			
			JSONArray tableArray = (JSONArray)first.get("table");
			for(int j=0;j<tableArray.size();j++){
					JSONObject second = (JSONObject)tableArray.get(j);
					String position = second.get("position").toString();
					//내부오브젝트 
					JSONObject teamObject = (JSONObject)second.get("team");
					
					teamObject.replace("name", "SSC Napoli", "SSC 나폴리");
					teamObject.replace("name", "Liverpool FC", "리버풀 FC");
					teamObject.replace("name", "AFC Ajax", "AFC 아약스");
					teamObject.replace("name", "Rangers FC", "레인져스 FC");
					teamObject.replace("name", "Club Brugge KV", "클럽 브뤼헤 KV");
					teamObject.replace("name", "Bayer 04 Leverkusen", "바이어 04 레버쿠젠");
					teamObject.replace("name", "Club Atlético de Madrid", "아틀렌티코 마드리드");
					teamObject.replace("name", "FC Porto", "FC 포르투");
					teamObject.replace("name", "FC Bayern München", "FC 바이에른 뮌헨");
					teamObject.replace("name", "FC Barcelona", "FC 바르셀로나");
					teamObject.replace("name", "FC Internazionale Milano", "FC 인터밀란");
					teamObject.replace("name", "FC Viktoria Plzeň", "FC 빅토리아 플첸");
					teamObject.replace("name", "Sporting Clube de Portugal", "스포르팅");
					teamObject.replace("name", "Tottenham Hotspur FC", "토트넘 핫스퍼 FC");
					teamObject.replace("name", "Eintracht Frankfurt", "아인하르트 프랑크푸르트");
					teamObject.replace("name", "Olympique de Marseille", "올랭피크 드 마르세유");
					teamObject.replace("name", "AC Milan", "AC 밀란");
					teamObject.replace("name", "GNK Dinamo Zagreb", "GNK 디나모 자그레브");
					teamObject.replace("name", "FC Red Bull Salzburg", "FC 레드불 잘츠부르크");
					teamObject.replace("name", "Chelsea FC", "첼시 FC");
					teamObject.replace("name", "Real Madrid CF", "레알 마드리드 FC");
					teamObject.replace("name", "FK Shakhtar Donetsk", "FC 샤흐타르 도네츠크");
					teamObject.replace("name", "Celtic FC", "셀틱 FC");
					teamObject.replace("name", "RB Leipzig", "RB 라이프치히");
					teamObject.replace("name", "Manchester City FC", "맨체스터 시티 FC");
					teamObject.replace("name", "Borussia Dortmund", "보루시아 도르트문트");
					teamObject.replace("name", "FC København", "FC 코펜하겐");
					teamObject.replace("name", "Sevilla FC", "세비야 FC");
					teamObject.replace("name", "Paris Saint-Germain FC", "파리 생제르망 FC");
					teamObject.replace("name", "Sport Lisboa e Benfica", "SL 벤피카");
					teamObject.replace("name", "Juventus FC", "유벤투스 FC");
					teamObject.replace("name", "Maccabi Haifa FC", "마카비 하이파");
					
					
					String playedGames = second.get("playedGames").toString();
					String won = second.get("won").toString();
					String draw = second.get("draw").toString();
					String lost = second.get("lost").toString();
					String points = second.get("points").toString();
					String goalsFor = second.get("goalsFor").toString();
					String goalsAgainst = second.get("goalsAgainst").toString();
					String goalDifference = second.get("goalDifference").toString();				
		
				 }
				 
			
		}
		return jsonObject;
	}
	
	
	@GetMapping("/data3.do")
	@ResponseBody
	public JSONObject ajax3() throws Exception {
		//return "etc/data";
		//매개변수 포함하여 api 주소 만들기
		String address= "https://api.football-data.org/v4/competitions/PD/standings";

		//객체 생성 및 url 연결
		URL url = new URL(address);
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("X-Auth-token", "d5e1fe0b1f084179af33060ed794581f");
	
		//데이터 받아오기
		InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String line;
		line = br.readLine();
		//파싱 
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(line);
		
		
		
		//오브젝트 배열
		JSONObject filtersObject = (JSONObject)jsonObject.get("filters");
		JSONObject areaObject = (JSONObject)jsonObject.get("area");
		JSONObject competitionObject = (JSONObject)jsonObject.get("competition");
		JSONObject seasonObject = (JSONObject)jsonObject.get("season");
		

		
		//스탠딩 배열
		JSONArray standingsArray = (JSONArray)jsonObject.get("standings");
		for(int i=0;i<standingsArray.size();i++){
			JSONObject first = (JSONObject)standingsArray.get(i);
			String stage = first.get("stage").toString();
			String type = first.get("type").toString();
			
			
			JSONArray tableArray = (JSONArray)first.get("table");
			for(int j=0;j<tableArray.size();j++){
					JSONObject second = (JSONObject)tableArray.get(j);
					String position = second.get("position").toString();
					//내부오브젝트 
					JSONObject teamObject = (JSONObject)second.get("team");
					
					teamObject.replace("name", "Real Madrid CF", "레알 마드리드 CF");
					teamObject.replace("name", "FC Barcelona", "FC 바르셀로나");
					teamObject.replace("name", "Real Betis Balompié", "레알 베티스 발롬피에");
					teamObject.replace("name", "Athletic Club", "아틀레틱 빌바오");
					teamObject.replace("name", "CA Osasuna", "CA 오사수나");
					teamObject.replace("name", "Villarreal CF", "비야 레알 CF");
					teamObject.replace("name", "Club Atlético de Madrid", "아틀렌티코 마드리드");
					teamObject.replace("name", "Valencia CF", "발렌시아 CF");
					teamObject.replace("name", "RCD Mallorca", "RCD 마요르카");
					teamObject.replace("name", "Girona FC", "지로나 FC");
					teamObject.replace("name", "Rayo Vallecano de Madrid", "라요 바예카노");
					teamObject.replace("name", "RC Celta de Vigo", "셀타 비고");
					teamObject.replace("name", "Getafe CF", "헤타페 CF");
					teamObject.replace("name", "Sevilla FC", "세이뱌 FC");
					teamObject.replace("name", "UD Almería", "UD 알메리아");
					teamObject.replace("name", "RCD Espanyol de Barcelona", "RCD 에스파뇰");
					teamObject.replace("name", "Real Valladolid CF", "레알 바야돌리드");
					teamObject.replace("name", "Cádiz CF", "카디스 CF");
					teamObject.replace("name", "Elche CF", "엘체 CF");
					teamObject.replace("name", "Real Sociedad de Fútbol", "레알 소시에다드");
					
					
					String playedGames = second.get("playedGames").toString();
					String won = second.get("won").toString();
					String form = second.get("form").toString();
					String draw = second.get("draw").toString();
					String lost = second.get("lost").toString();
					String points = second.get("points").toString();
					String goalsFor = second.get("goalsFor").toString();
					String goalsAgainst = second.get("goalsAgainst").toString();
					String goalDifference = second.get("goalDifference").toString();				
		
				 }
				 
			
		}
		return jsonObject;
	}
	@GetMapping("/data4.do")
	@ResponseBody
	public JSONObject ajax4() throws Exception {
		//return "etc/data";
		//매개변수 포함하여 api 주소 만들기
		String address= "https://api.football-data.org/v4/competitions/BL1/standings";

		//객체 생성 및 url 연결
		URL url = new URL(address);
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("X-Auth-token", "d5e1fe0b1f084179af33060ed794581f");
	
		//데이터 받아오기
		InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String line;
		line = br.readLine();
		//파싱 
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(line);
		
		
		
		//오브젝트 배열
		JSONObject filtersObject = (JSONObject)jsonObject.get("filters");
		JSONObject areaObject = (JSONObject)jsonObject.get("area");
		JSONObject competitionObject = (JSONObject)jsonObject.get("competition");
		JSONObject seasonObject = (JSONObject)jsonObject.get("season");
		

		
		//스탠딩 배열
		JSONArray standingsArray = (JSONArray)jsonObject.get("standings");
		for(int i=0;i<standingsArray.size();i++){
			JSONObject first = (JSONObject)standingsArray.get(i);
			String stage = first.get("stage").toString();
			String type = first.get("type").toString();
			
			
			JSONArray tableArray = (JSONArray)first.get("table");
			for(int j=0;j<tableArray.size();j++){
					JSONObject second = (JSONObject)tableArray.get(j);
					String position = second.get("position").toString();
					//내부오브젝트 
					JSONObject teamObject = (JSONObject)second.get("team");
					
					teamObject.replace("name", "1. FC Union Berlin", "유니온 베를린");
					teamObject.replace("name", "Borussia Dortmund", "보루시아 도르트문트");
					teamObject.replace("name", "SC Freiburg", "SC 프라이부르크");
					teamObject.replace("name", "TSG 1899 Hoffenheim", "TSG 1899 호펜하임");
					teamObject.replace("name", "FC Bayern München", "FC 바이에른 뮌헨");
					teamObject.replace("name", "Borussia Mönchengladbach", "보루시아 묀헨글라트바흐");
					teamObject.replace("name", "Eintracht Frankfurt", "아인트하르트 프랑크푸르트");
					teamObject.replace("name", "1. FSV Mainz 05", "FSV 마인츠 05");
					teamObject.replace("name", "1. FC Köln", "FC 쾰른");
					teamObject.replace("name", "SV Werder Bremen", "SV 베르더 브레멘");
					teamObject.replace("name", "FC Augsburg", "FC 아우크스부르크");
					teamObject.replace("name", "RB Leipzig", "RB 라이프치히");
					teamObject.replace("name", "Hertha BSC", "헤르타 BSC");
					teamObject.replace("name", "FC Schalke 04", "FC 샬케 04");
					teamObject.replace("name", "Bayer 04 Leverkusen", "바이어 04 레버쿠젠");
					teamObject.replace("name", "VfB Stuttgart", "VFB 슈투트가르트");
					teamObject.replace("name", "VfL Wolfsburg", "VFL 볼프스부르그");
					teamObject.replace("name", "VfL Bochum 1848", "VFL 보훔");
					
					
					String playedGames = second.get("playedGames").toString();
					String won = second.get("won").toString();
					String draw = second.get("draw").toString();
					String lost = second.get("lost").toString();
					String points = second.get("points").toString();
					String goalsFor = second.get("goalsFor").toString();
					String goalsAgainst = second.get("goalsAgainst").toString();
					String goalDifference = second.get("goalDifference").toString();				
		
				 }
				 
			
		}
		return jsonObject;
	}
	@GetMapping("/data5.do")
	@ResponseBody
	public JSONObject ajax5() throws Exception {
		//return "etc/data";
		//매개변수 포함하여 api 주소 만들기
		String address= "https://api.football-data.org/v4/competitions/SA/standings";

		//객체 생성 및 url 연결
		URL url = new URL(address);
		URLConnection urlConn = url.openConnection();
		urlConn.setRequestProperty("X-Auth-token", "d5e1fe0b1f084179af33060ed794581f");
	
		//데이터 받아오기
		InputStreamReader ir = new InputStreamReader(urlConn.getInputStream());
		BufferedReader br = new BufferedReader(ir);
		
		String line;
		line = br.readLine();
		//파싱 
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = (JSONObject)jsonParser.parse(line);
		
		
		
		//오브젝트 배열
		JSONObject filtersObject = (JSONObject)jsonObject.get("filters");
		JSONObject areaObject = (JSONObject)jsonObject.get("area");
		JSONObject competitionObject = (JSONObject)jsonObject.get("competition");
		JSONObject seasonObject = (JSONObject)jsonObject.get("season");
		

		
		//스탠딩 배열
		JSONArray standingsArray = (JSONArray)jsonObject.get("standings");
		for(int i=0;i<standingsArray.size();i++){
			JSONObject first = (JSONObject)standingsArray.get(i);
			String stage = first.get("stage").toString();
			String type = first.get("type").toString();
			
			
			JSONArray tableArray = (JSONArray)first.get("table");
			for(int j=0;j<tableArray.size();j++){
					JSONObject second = (JSONObject)tableArray.get(j);
					String position = second.get("position").toString();
					//내부오브젝트 
					JSONObject teamObject = (JSONObject)second.get("team");
					
					teamObject.replace("name", "SSC Napoli", "SSC 나폴리");
					teamObject.replace("name", "Atalanta BC", "아틀란타 BC");
					teamObject.replace("name", "Udinese Calcio", "우디네세 칼초");
					teamObject.replace("name", "SS Lazio", "SS 라치오");
					teamObject.replace("name", "AC Milan", "AC 밀란");
					teamObject.replace("name", "AS Roma", "AS 로마");
					teamObject.replace("name", "FC Internazionale Milano", "FC 인터밀란");
					teamObject.replace("name", "Juventus FC", "유벤투스 FC");
					teamObject.replace("name", "Torino FC", "토리노 FC");
					teamObject.replace("name", "ACF Fiorentina", "FC 피오렌티나");
					teamObject.replace("name", "US Sassuolo Calcio", "US 사수올로 칼초");
					teamObject.replace("name", "Spezia Calcio", "스페치아 칼초");
					teamObject.replace("name", "US Salernitana 1919", "US 살레르리타나");
					teamObject.replace("name", "Empoli FC", "엠폴리 FC");
					teamObject.replace("name", "US Lecce", "US 레체");
					teamObject.replace("name", "Bologna FC 1909", "볼로냐 FC");
					teamObject.replace("name", "Hellas Verona FC", "엘라스 베로나");
					teamObject.replace("name", "AC Monza", "AC 몬차");
					teamObject.replace("name", "US Cremonese", "US 크레모네세");
					teamObject.replace("name", "UC Sampdoria", "UC 샴프도리아");
						
					String playedGames = second.get("playedGames").toString();
					String won = second.get("won").toString();
					String draw = second.get("draw").toString();
					String lost = second.get("lost").toString();
					String points = second.get("points").toString();
					String goalsFor = second.get("goalsFor").toString();
					String goalsAgainst = second.get("goalsAgainst").toString();
					String goalDifference = second.get("goalDifference").toString();				
		
				 }
				 
			
		}
		return jsonObject;
	}
	
	@ResponseBody
	@GetMapping("/live_video.do")
	public String live_video() {
		
		String request_mapping = "<script>alert('진행중인 실시간 방송이 없습니다.');"
				+ "location.href='/rank.do'</script>";
		
		return request_mapping;
	}
	
	@GetMapping("/live_controller.do")
	public String live_controller() {
		
		return "etc/live_controller";
	}
	
	@PostMapping("/live_controller_process.do") // 추후 이곳에 라이브 갱신하는 과정 처리해주어야 함
	public String live_controller_process() {
		return "etc/live_controller_process";
	}
	
	@PostMapping("/point_comment_insert_process.do") // 추후 이곳에 라이브 댓글 작성하는 과정 처리해주어야 함
	public String point_comment_insert_process() {
		return "etc/point_comment_insert_process";
	}
	
	@PostMapping("/point_comment_delete_process.do") // 추후 이곳에 라이브 댓글 삭제하는 과정 처리해주어야 함
	public String point_comment_delete_process() {
		return "etc/point_comment_delete_process";
	}
	
	
	
	
	
	
	
	
	
	
}
