<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>购物车页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="/shopping/js/jquery-1.4.min.js"></script>
	<script type="text/javascript">
		$("document").ready(function(){
			$(".goodsNum").blur(function(){
				$.post("/shopping/ForderSer",{status:"updateSorder",gid:$(this).attr("id"),snumber:$(this).val()},function(ftotal){
					$("#ftotal").html(ftotal);
				},"text/html");
			});
		});
	</script>

  </head>
  
  <body>
    <center>
      这里显示购物车：也就是购买商品的列表显示
		<table>
			<tr>
				<td>
					商品编号
				</td>
				<td>
					商品名称
				</td>
				<td>
					商品价格
				</td>
				<td>
					商品数量
				</td>
				<td>
					删除
				</td>
			</tr>
			<c:choose>
				<c:when test="${sessionScope.forder.ftotal==0.0}">
    				购物车已经清空
    			</c:when>
				<c:otherwise>
					<c:forEach items="${sessionScope.forder.sorders}" var="sorder">
						<tr>
							<td>
								${sorder.goods.gid}
							</td>
							<td>
								${sorder.sname}
							</td>
							<td>
								${sorder.sprice}
							</td>
							<td>
								<input type="text" value="${sorder.snumber}" size="2" class="goodsNum" id="${sorder.goods.gid}" />
							</td>
							<td>
								<a href="/shopping/ForderSer?status=deleteSorder&gid=${sorder.goods.gid}">删除</a>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<a href="/shopping/ForderSer?status=deleteForder">清空购物车</a>
		<a href="/shopping/index.jsp">继续购物</a>
		<div>总价:<span id="ftotal">${sessionScope.forder.ftotal}</span></div>
		<a href="/shopping/users/forderInfo.jsp">提交订单</a>
    
    </center>
  </body>
</html>
