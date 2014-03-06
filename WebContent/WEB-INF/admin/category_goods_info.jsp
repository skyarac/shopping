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
    
    <title>商品综合信息管理</title>
    
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
     <h1> 商品综合信息管理</h1>
     添加类别信息： 
     <form action="/shopping/AccountSer?status=addCategory" method="post">
        类别名称：<input type="text" name="ctype" /><br/>
        是否热点
        是：<input type="radio" checked="checked" name="chot" value="true"/>
        否：<input type="radio"  name="chot" value="false"/>
        <input type="hidden" name="aid" value="${sessionScope.account.aid}">
      <input type="submit"  value="提交"/>
     </form>
  <hr/>
     <table width="900" border="0" cellspacing="1" bordercolor="#000000">
	    <tr>
	        <th>类别编号</th>
		    <th>类别名</th>
		    <th>是否热点</th>
		    <th>客服编号</th>
		    <th>删除</th>
		    <th>编辑</th>
		    <th>商品信息</th>
	    </tr>
	    <c:forEach items="${sessionScope.categorys}" var="category">
	    <tr>
	        <td>${category.cid}</td>
	        <td>${category.ctype}</td>
	        <td>${category.chot}</td>
	        <td>${category.account.aid}</td>
	        <td id="${category.cid}"><a href="/shopping/AccountSer?status=deleteCategory&cid=${category.cid}">删除</a></td>
	        <c:url value="/admin/categorymodify.jsp" var="modify">
				<c:param name="cid" value="${category.cid}"/>
				<c:param name="ctype" value="${category.ctype}"/>
				<c:param name="chot" value="${category.chot}" />
				<c:param name="aid" value="${category.account.aid}" />
				</c:url>
	        <td><a href="${modify}">编辑</a></td>
	        <td><a href="/shopping/AccountSer?status=getGoodsInfo&cid=${category.cid}">商品信息</a></td>
	    </tr>
	    </c:forEach>
    </table>
    </center>
  </body>
</html>
