<%@page import="com.shenjinxiang.entity.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	/* application.setAttribute("name", "aaa");
	application.setAttribute("name", "bbb");
	application.removeAttribute("name"); */
	
	session.setAttribute("user", new User());
	session.removeAttribute("user");

%>
</body>
</html>