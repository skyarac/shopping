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
    
    <title>商城首页</title>
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
    <c:choose>
       <c:when test="${sessionScope.users==null}">
                          您好目前您的状态是游客,请<a href="/shopping/ulogin.jsp">登录</a>|<a href="/shopping/uRegister.jsp">注册</a>
       </c:when>
       <c:otherwise>
	             您好${sessionScope.users.ulogin}欢迎来到在线购物商城,如果您不是此用户则<a href="/shopping/user/UserSer?status=logout">退出</a>
	   </c:otherwise>
    </c:choose>
    <!-- 首页热点商品展示 -->
    <c:forEach items="${applicationScope.bigList}" var="list">
			<table width="625" height="190" border="1" cellpadding="0"
				cellspacing="0">
				
				<tr>
					<td height="23" colspan="4">
						<a href="/shopping/AccountSer?status=goodsList&cid=${list[0].category.cid}&ctype=${list[0].category.ctype}">==${list[0].category.ctype}</a>
					</td>
				</tr>
				<tr>
					<!-- 循环4次 -->
					<c:forEach items="${list}" var="goods">
					<td width="180" height="165" valign="top">
						<table width="100%" height="164" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="113">
									<img src="/shopping/image/${goods.gpic}" />
								</td>
							</tr>
							<tr>
								<td height="25">
									${goods.gprice}
								</td>
							</tr>
							<tr>
								<td height="26">
									${goods.gname} 
									<c:url value="/detail.jsp" var="detail">
										<c:param name="gid" value="${goods.gid}"></c:param>
										<c:param name="gname" value="${goods.gname}" />
										<c:param name="gprice" value="${goods.gprice}" />
										<c:param name="gpic" value="${goods.gpic}" />
										<c:param name="ctype" value="${goods.category.ctype}" />
									</c:url>
									<a href="${detail}">详细</a>
								</td>
							</tr>
						</table>
					</td>
					</c:forEach>
					<!-- 上面的循环4次 -->
				</tr>
			</table>
		</c:forEach>
		<!-- 循环3次-->
	</center>
  </body>
</html>
