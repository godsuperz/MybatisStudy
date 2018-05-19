<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>内容列表页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=basePath%>resources/css/w3.css" />
<script src="<%=basePath%>resources/js/echarts.js"></script>
<script src="<%=basePath%>resources/js/jquery-3.2.1.min.js"></script>
<script src="<%=basePath%>resources/js/list.js"></script>
</head>
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>

<body class="w3-light-grey">
	<form name="mainForm" id="mainForm" action="<%= basePath %>" method="post">
		<div class="w3-container">
			<div class="w3-bar w3-margin-top">
				<h5 class="w3-bar-item">内容列表</h5>
				<a href="<%= basePath %>add.jsp"
					class="w3-bar-item w3-right w3-margin-top w3-button w3-round w3-card w3-hover-light-green">
					<span class="w3-large w3-text-green"> <b>+</b>
				</span> 新增
				</a> <span class="w3-bar-item w3-right">&nbsp;</span> <a
					href="javascript:void(0);" onclick="deleteMessages();"
					class="w3-bar-item w3-right w3-margin-top w3-button w3-round w3-card w3-hover-red">
					<span class="w3-large w3-text-red"> <b>&times;</b>
				</span> 删除
				</a>
			</div>
			<hr class="w3-blue" style="width: 100%; height: 2px">
			<div class="w3-container w3-bar">
				<span class="w3-bar-item">指令名称：</span> <input
					class="w3-bar-item w3-input w3-round w3-border" type="text"
					name="command" value="${command}"> <span
					class="w3-bar-item">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述：</span>
				<input class="w3-bar-item w3-input w3-round w3-border" type="text"
					name="description" value="${description}"> 
					<a id="searchButton" class="w3-bar-item w3-right w3-button w3-round w3-card w3-border w3-hover-light-green"
						href="javascript:void(0);" onclick="searchList();">查询</a>
			</div>
			<input id="id" name="id" type="hidden" value="" />
			<table class="w3-table-all w3-centered w3-hoverable w3-margin-top">
				<thead>
					<tr class="w3-light-gray">
						<th><input type="checkbox" name="" id=""></th>
						<th>序号</th>
						<th>指示名称</th>
						<th>描述</th>
						<th>内容<th>
						<th colspan="2">操作</th>
					</tr>
				</thead>
				<c:forEach items="${messageList}" var="message" varStatus="status">
					<tr>
						<td><input type="checkbox" name="ids" value="${message.id}">
						</td>
						<td>${status.index + 1}</td>
						<td>${message.command}</td>
						<td>${message.description}</td>
						<td>${message.content}</td>
						<td><a href="#">修改</a></td>
						<td>
							<input type="hidden" value="${message.id}" />
							<a href="javascript:void(0);">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>
