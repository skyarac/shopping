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
    
    <title>订单编辑页面</title>
    
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
  温馨提示：1-->未支付  2-->已支付  3-->废单<br/>
               订单编号：${param.fid}<br/>
   <form action="/shopping/AccountSer" method="post">
		          订单编号<input type="hidden" name="fid" value="${param.fid}"/><br/>
		               订单状态:<input type="text" name="sid" value="${param.sid}"/><br/>
	                               提交:<input type="submit" value="提交"/><br/>
           <input type="hidden" name="status" value="forderModify"><br/>
   </form>
   </center>
  </body>
</html>
