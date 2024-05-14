<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<style type="text/css">
	h1 {
		padding: 0 10px 0 10px;
	}
	table{
		border: 1px solid white;
	}
	th {
		padding: 5px 15px 5px 15px;
		color: white;
		font-size: 11px;
		background-color: green;
	}
</style>
</head>
<body>

	<h1>와이파이 정보 구하기</h1>
	
	<p>
		<a href='http://localhost:8080/SeoulWifi/index.jsp'>홈</a> |
		<a href='#'>위치 히스토리 목록</a> |
		<a href='http://localhost:8080/SeoulWifi/getAPI.jsp'>Open AP 와이파이 정보 가져오기</a>
	</p>
	
	<p>
		LAT:
		,
		LNT:
		내 위치 가져오기
		근처WIPI 정보 보기
	</p>
	
	<table>
		<thead> 
			<tr>
				<th> 거리(Km) </th>
				<th> 관리번호 </th>
				<th> 자치구 </th>
				<th> 와이파이명 </th>
				<th> 도로명주소 </th>
				<th> 상세주소 </th>
				<th> 설치위치(층) </th>
				<th> 설치유형 </th>
				<th> 설치기관 </th>
				<th> 서비스구분 </th>
				<th> 망종류 </th>
				<th> 설치년도 </th>
				<th> 실내외구분 </th>
				<th> WIFI접속환경 </th>
				<th> X좌표 </th>
				<th> Y좌표 </th>
				<th> 작업일자 </th>
			</tr>
		</thead>
	
	</table>
	

</body>
</html>