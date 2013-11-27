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
    
    <title>商品管理</title>
    
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
     <h1> 商品管理</h1>
     <a href="/shopping/admin/addgoods.jsp">添加商品</a>
     <table width="900" border="0" cellspacing="1" bordercolor="#000000">
	    <tr>
	        <th>商品编号</th>
		    <th>商品名</th>
		    <th>商品价格</th>
		    <th>图片名称</th>
		    <th>商品描述</th>
		    <th>添加日期</th>
		    <th>详细描述</th>
		    <th>是否推荐</th>
		    <th>是否有效</th>
		    <th>类别编号</th>
		    <th>删除</th>
		    <th>编辑</th>
	    </tr>
	    <c:forEach items="${sessionScope.goods}" var="good">
	    <tr>
	        <td>${good.gid}</td>
	        <td>${good.gname}</td>
	        <td>${good.gprice}</td>
	        <td>${good.gpic}</td>
	        <td>${good.gremark}</td>
	        <td>${good.gdate}</td>
	        <td>${good.gxremark}</td>
	        <td>${good.giscommend}</td>
	        <td>${good.gisopen}</td>
	        <td>${good.category.cid}</td>
	        <td id="${category.cid}"><a href="/shopping/AccountSer?status=deleteGoods&gid=${good.gid}&cid=${good.category.cid}">删除</a></td>
	        <c:url value="/admin/goodsmodify.jsp" var="modify">
				<c:param name="gid" value="${good.gid}"/>
				<c:param name="gname" value="${good.gname}"/>
				<c:param name="gpic" value="${good.gpic}"/>
				<c:param name="gprice" value="${good.gprice}" />
				<c:param name="gremark" value="${good.gremark}"/>
				<c:param name="gxremark" value="${good.gxremark}"/>
				<c:param name="giscommend" value="${good.giscommend}"/>
				<c:param name="gisopen" value="${good.gisopen}" />
				<c:param name="cid" value="${good.category.cid}"/>
				</c:url>
	        <td><a href="${modify}">编辑</a></td>
	    </tr>
	    </c:forEach>
    </table>
    </center>
  </body>
</html>
