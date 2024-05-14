<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="GetApi.SaveWifiInfo"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<style type="text/css">
	
	#result{
		font-size: 30px;
		padding: 0 10px 0 10px; 
	}
	div {
			text-align: center;
	}
</style>

</head>
<body>
	<%
		SaveWifiInfo saveWifiInfo = new SaveWifiInfo();
		int saved = saveWifiInfo.insertWifiInfo();
	%>
	
	<div>
		<div id="result">
			<%=saved%>건의 데이터를 성공적으로 저장하였습니다. 
		</div>
		<div> 
			<a href='http://localhost:8080/SeoulWifi/index.jsp'>홈으로 돌아가기 </a>
		</div>
	</div>

</body>
</html>