<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://www.shenjinxiang.com/tags" prefix="ls" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>002</title>
</head>
<body>
<%
	List<String> list = new ArrayList<String>();
	list.add("aaaa");
	list.add("bbbb");
	list.add("cccc");
	list.add("dddd");
	list.add("eeee");
	request.setAttribute("list", list);
	
	Map<String, String> map = new HashMap<String, String>();
	map.put("aa", "111");
	map.put("bb", "222");
	map.put("cc", "333");
	map.put("dd", "444");
	map.put("ee", "555");
	request.setAttribute("map", map);
	
	Integer[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	request.setAttribute("num", num);
%>
	<ls:foreach var="str" items="${list }" >
		${str }
	</ls:foreach>
	<hr/>
	<ls:foreach var='entry' items="${map }" >
		${entry }
	</ls:foreach>
	<hr/>
	<ls:foreach var='i' items="${num }">
		${i }
	</ls:foreach>
</body>
</html>