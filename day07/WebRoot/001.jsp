<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.shenjinxiang.com/tags" prefix="ls" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>001</title>
</head>
<body>
hhe
${num }

<ls:choose>
	<ls:when test="${num < 10 }">
		小于10岁
	</ls:when>
	<!-- 
	 -->
	<ls:when test="${num < 20 }">
		少年
	</ls:when>
	<ls:when test="${num < 60 }">
		中年
	</ls:when>
	<ls:otherwise>
		老人了
	</ls:otherwise>
</ls:choose>
</body>
</html>