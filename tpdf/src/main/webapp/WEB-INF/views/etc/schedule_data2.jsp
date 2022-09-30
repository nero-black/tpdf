<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.*, java.io.*"%>
<%@ page import="org.json.simple.*"%>
<%@ page import="org.json.simple.parser.JSONParser"%>
<%
			
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
					String area = first.get("area").toString();
					String competition = first.get("competition").toString();
					String season = first.get("season").toString();
					String id = first.get("id").toString();
					String utcDate = first.get("utcDate").toString();
					String status = first.get("status").toString();
					String stage = first.get("stage").toString();
					
					/* String group = first.get("group").toString(); */
				
					String homeTeam = first.get("homeTeam").toString();
					String awayTeam = first.get("awayTeam").toString();
					String score = first.get("score").toString();
					
					
					
					
					
						 
					
				}
				out.print(line);
				
			
								
				
			
		%>