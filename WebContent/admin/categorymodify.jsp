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
    
    <title>类别编辑页面</title>
    
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
  <center>
  
               类别编号：${param.cid}<br/>
   <form action="/shopping/AccountSer" method="post">
		          类别编号<input type="hidden" name="cid" value="${param.cid}"/><br/>
		              类别名称:<input type="text" name="ctype" value="${param.ctype}"/><br/>
		               是否热点:<input type="text" name="chot" value="${param.chot}"/><br/>
		              客服编号:<input type="text" name="aid" value="${param.aid}"/><br/>
	                               提交:<input type="submit" value="提交"/><br/>
           <input type="hidden" name="status" value="categoryModify"><br/>
   </form>
   </center>
  </body>
</html>
