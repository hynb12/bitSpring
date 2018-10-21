<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>삭제 확인</h1>

	<form method="post">
		<input type="hidden" name="messageId" value="${mId}" /> 메시지를 삭제하시려면
		암호를 입력하세요:<br /> 암호: <input type="password" name="password" /> <br />
		<input type="submit" value="메시지 삭제하기" />
	</form>










</body>
</html>