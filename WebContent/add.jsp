<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>添加消息页面</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href="<%=basePath%>resources/css/w3.css" />
    <script src="<%=basePath%>resources/js/echarts.js"></script>
    <script src="<%=basePath%>resources/js/jquery-3.3.1.js"></script>
</head>
<style>
    html,
    body,
    h1,
    h2,
    h3,
    h4,
    h5 {
        font-family: "Raleway", sans-serif
    }
</style>

<body class="w3-light-grey">
    <div class="w3-container" style="width: 100%;height: 450px">
        <div class="w3-bar w3-margin-top">
            <h5 class="w3-bar-item">内容列表</h5>
        </div>
        <hr class="w3-blue" style="margin-bottom: 60px;width: 100%;height: 2px">
        <form action="<%= basePath %>addMessage" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue" style="margin: 0 auto; width: 60%;">
            <h2 class="w3-center">添加消息</h2>

            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px">
                    <i class="w3-xxlarge fa fa-user"></i>
                </div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="command" type="text" placeholder="Command">
                </div>
            </div>

            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px">
                    <i class="w3-xxlarge fa fa-envelope-o"></i>
                </div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="description" type="text" placeholder="Description">
                </div>
            </div>

            <div class="w3-row w3-section">
                <div class="w3-col" style="width:50px">
                    <i class="w3-xxlarge fa fa-pencil"></i>
                </div>
                <div class="w3-rest">
                    <input class="w3-input w3-border" name="content" type="text" placeholder="Content">
                </div>
            </div>
            <div>
                <input type="reset" class="w3-button w3-left w3-section w3-blue w3-ripple w3-padding" value="重置">
                <input type="submit" class="w3-button w3-right w3-section w3-blue w3-ripple w3-padding" value="添加">
            </div>
        </form>
    </div>
</body>
</html>