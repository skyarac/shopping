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
    
    <title>订单管理</title>
    
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
     <h1> 订单管理</h1>
     <table width="900" border="0" cellspacing="1" bordercolor="#000000">
	    <tr>
	        <th>订单编号</th>
		    <th>订单日期</th>
		    <th>订单总价</th>
		    <th>送货人姓名</th>
		    <th>电话</th>
		    <th>评论</th>
		    <th>邮箱</th>
		    <th>邮政编码</th>
		    <th>用户编号</th>
		    <th>客服编号</th>
		    <th>订单状态</th>
		    <th>送货地址</th>
		    <th>编辑</th>
		    <th>删除</th>
	    </tr>
	    <c:forEach items="${sessionScope.forders}" var="forder">
	    <tr>
	        <td>${forder.fid}</td>
	        <td>${forder.fdate}</td>
	        <td>${forder.ftotal}</td>
	        <td>${forder.fname}</td>
	        <td>${forder.fphone}</td>
	        <td>${forder.fremark}</td>
	        <td>${forder.femail}</td>
	        <td>${forder.fpost}</td>
	        <td>${forder.users.uid}</td>
	        <td>${forder.account.aid}</td>
	        <td>${forder.status.sid}</td>
	        <td>${forder.faddress}</td>
	  <!--      <td id="${forder.users.uid}"><a href="/shopping/AccountSer?status=deleteForder&fid=${forder.fid}">删除</a></td>-->  
	        <c:url value="/admin/fordermodify.jsp" var="modify">
				<c:param name="fid" value="${forder.fid}"/>
				<c:param name="sid" value="${forder.status.sid}"/>
				</c:url>
	        <td><a href="${modify}">编辑</a></td>
	    </tr>
	    </c:forEach>
    </table>
    </center>
  </body>
</html>
