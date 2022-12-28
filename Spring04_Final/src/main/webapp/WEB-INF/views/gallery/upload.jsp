<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/gallery/upload.jsp</title>
</head>
<body>
	<div class="container">
		<p>
			${id }님 파일을 저장했습니다.
			<a href="${pageContext.request.contextPath}/gallery/list">인덱스로 돌아가기</a>
		</p>
		
	</div>
</body>
</html>