<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>后台左部</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <ul>
    	 <li><a href="/shopping/AccountSer?status=usersManage" target="right">用户管理</a></li>
    	<!--  <li><a href="/shopping/admin/category.jsp" target="right">类别管理</a></li>  --> 
    	 <li><a href="/shopping/AccountSer?status=categoryAndGoodsInfo" target="right">商品综合信息管理</a></li>
    	 <li><a href="/shopping/AccountSer?status=forderManage" target="right">订单管理</a></li>
    </ul>
  </body>
</html>
