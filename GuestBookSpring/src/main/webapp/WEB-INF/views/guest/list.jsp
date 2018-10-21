<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
ul {
	
}

ul, li {
	border: 1px solid #EEEEEE;
}
</style>
</head>
<body>

	<h1>방명록</h1>


	${viewData.isEmpty()}

	<c:if test="${viewData.isEmpty()}">
작성된 방명록 메시지가 없습니다.
</c:if>

	<c:if test="${!viewData.isEmpty()}">
		<ul>
			<c:forEach var="message" items="${viewData.messageList}">
				<li>${message.id} <br> ${message.guestName} <br>
					${message.message}<br> <a href="view/${message.id}">상세보기</a> <a
					href="delete?id=${message.id}">[삭제하기]</a>
				</li>
			</c:forEach>
		</ul>

		<c:forEach var="num" begin="1" end="${viewData.pageTotalCount}">
			<a href="list?page=${num}"> [${num}] </a>
		</c:forEach>




	</c:if>














</body>
</html>