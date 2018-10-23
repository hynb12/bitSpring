<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<h1>방명록 메시지 쓰기</h1>


	<form method="post">
		이름: <input type="text" name="guestName" /> <br /> 암호: <input
			type="password" name="password" /> <br /> 메시지:
		<textarea name="message" cols="30" row="3"></textarea>
		<br /> <input type="submit" value="메시지 남기기" />
	</form>








</body>
</html>