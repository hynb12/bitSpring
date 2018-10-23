<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<style>
h2 {
	padding: 10px;
}

table {
	margin-top: 10px;
}

td {
	padding: 10px 20px;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/common/header.jsp"%>

	<div id="contents">
		<h2>회원리스트</h2>

		<hr>

		<table border="1">
			<tr>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>사진</td>
				<td>관리</td>
			</tr>



			<c:if test="${!list.isEmpty()}">

				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.userId}</td>
						<td>${list.password}</td>
						<td>${list.userName}</td>
						<td>${list.userPhoto}</td>
						<td><a href="modify?userId=${list.userId}">[수정하기]</a> <a
							href="delete?userId=${list.userId}">[삭제하기]</a></td>
					</tr>
				</c:forEach>


				<%-- 				<c:forEach var="num" begin="1" end="${list.pageTotalCount}">
					<a href="list?page=${num}"> [${num}] </a>
				</c:forEach> --%>

			</c:if>

		</table>

	</div>



</body>
</html>