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
    
    <title>用户管理</title>
    
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
    <h1>用户管理模块</h1>
    <table width="900" border="0" cellspacing="1" bordercolor="#000000">
	    <tr>
	        <th>用户编号</th>
		    <th>登录名</th>
		    <th>姓名</th>
		    <th>密码</th>
		    <th>性别</th>
		    <th>电话</th>
		    <th>邮政编码</th>
		    <th>邮箱</th>
		    <th>地址</th>
		    <th>删除</th>
		    <th>编辑</th>
	    </tr>
	    <c:forEach items="${sessionScope.users}" var="user">
	    <tr>
	        <td>${user.uid}</td>
	        <td>${user.ulogin}</td>
	        <td>${user.uname}</td>
	        <td>${user.upass}</td>
	        <td>${user.usex}</td>
	        <td>${user.uphone}</td>
	        <td>${user.upost}</td>
	        <td>${user.uemail}</td>
	        <td>${user.uaddress}</td>
	        <td id="${user.uid}"><a href="/shopping/AccountSer?status=deleteUser&uid=${user.uid}">删除</a></td>
	        <c:url value="/admin/usersmodify.jsp" var="modify">
				<c:param name="uid" value="${user.uid}"/>
				<c:param name="ulogin" value="${user.ulogin}"/>
				<c:param name="uname" value="${user.uname}" />
				<c:param name="upass" value="${user.upass}" />
				<c:param name="usex" value="${user.usex}" />
				<c:param name="uphone" value="${user.uphone}"/>
				<c:param name="upost" value="${user.upost}"/>
				<c:param name="uemail" value="${user.uemail}"/>
				<c:param name="uaddress" value="${user.uaddress}"/>
				</c:url>
	        <td><a href="${modify}">编辑</a></td>
	    </tr>
	    </c:forEach>
    </table>
    
  </center>
  </body>
</html>
