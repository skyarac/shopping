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
    
    <title>用户编辑页面</title>
    
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
                 用户编号：${param.uid}<br/>
   <form action="/shopping/AccountSer" method="post">
		          
		          <input type="hidden" name="uid" value="${param.uid}"/><br/>
		               用户名:<input type="text" name="ulogin" value="${param.ulogin}"/><br/>
		                  姓 名:<input type="text" name="uname" value="${param.uname}"/><br/>
		                   密码:<input type="text" name="upass" value="${param.upass}"/><br/>
                                           性别:<input type="text" name="usex" value="${param.usex}"/><br/>
	                               电话:<input type="text" name="uphone"  value="${param.uphone}"/><br/>
	                               邮编:<input type="text" name="upost"   value="${param.upost}"/><br/>
	                               邮箱:<input type="text" name="uemail" value="${param.uemail}"/><br/>
	                               地址:<input type="text" name="uaddress" value="${param.uaddress}"/><br/>
	                               提交:<input type="submit" value="提交"/><br/>
           <input type="hidden" name="status" value="userModify"><br/>
   </form>
   </center>
  </body>
</html>
