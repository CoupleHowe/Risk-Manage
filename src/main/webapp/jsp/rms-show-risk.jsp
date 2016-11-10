<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Track | Risk Management System</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
    </style>
    <link rel="stylesheet" href="../utils/bootstrap/css/bootstrap.min.css">
    <script src="../utils/jquery.min.js"></script>
    <script src="../utils/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <div style="min-width: 1200px;">
        <ul class="nav nav-tabs" role="tablist">
            <li style="margin-left: 100px; height: 52px;">
                <a href="#" class="navbar-brand" style="line-height: 32px; height: 52px; color: #463265; font-family: Microsoft Yahei">Risk Management System</a>
            </li>

            <li role="presentation" class="dropdown" style="float: right; margin-right: 100px;">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="text-decoration: underline; font-family: Microsoft Yahei; line-height: 30px;  color: #463265">Root</a>
                
                <ul class="dropdown-menu" role="menu">
                    <li role="presentation"><a role="menuitem" href="#" style="font-family: Microsoft Yahei; line-height: 30px;  color: #463265">退出</a></li>
                </ul>
            </li>

            <li role="presentation" class="dropdown" style="float: right;">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="font-family: Microsoft Yahei; line-height: 30px; color: #463265">风险管理</a>
                
                <ul class="dropdown-menu" role="menu">
                    <li role="presentation"><a role="menuitem" href="./rms-add-risk.jsp" style="font-family: Microsoft Yahei; line-height: 30px;  color: #463265">添加条目</a></li>
                    <li role="presentation"><a role="menuitem" href="./rms-show-risk.jsp" style="font-family: Microsoft Yahei; line-height: 30px;  color: #463265">风险追踪</a></li>
                </ul>
            </li>

            <li role="presentation" class="dropdown" style="float: right;">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#" style="font-family: Microsoft Yahei; line-height: 30px; color: #463265">用户管理</a>

                <ul class="dropdown-menu" role="menu">
                    <li role="presentation"><a role="menuitem" href="#" style="font-family: Microsoft Yahei; line-height: 30px;  color: #463265">我提交的风险</a></li>
                    <li role="presentation"><a role="menuitem" href="#" style="font-family: Microsoft Yahei; line-height: 30px;  color: #463265">我追踪的风险</a></li>
                </ul>
            </li>
        </ul>

        <header class="main-header" style="background-image: url(../img/header-bg.jpg)">
            <div class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <h1 style="height: 200px; line-height: 200px;">更便捷、更专业、更好用的风险管理系统。</h1>
                    </div>
                </div>
            </div>
        </header>

        <div style="width: 1000px; margin: 100px auto;">
            <table class="table table-hover table-bordered">
            <thead>
                <tr>
                <th>风险内容</th>
                <th>可能性</th>
                <th>影响程度</th>
                <th>阈值</th>
                <th>提交者</th>
                <th>跟踪者</th>
                <th>状态</th>
                <th>描述</th>                
                </tr>
            </thead>
            <tbody id="table-body">
                <tr>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>                
                </tr>
                <tr>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>                
                </tr>
                <tr>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>
                <td>1</td>                
                </tr>
            </tbody>
            </table>
        </div>
    </div>

</body>
</html>

<script>
    window.onload = function() {
        var url = "../showRisk";

        if(window.XMLHttpRequest) {  
            req = new XMLHttpRequest();  
        }else if(window.ActiveXObject) {  
            req = new ActiveXObject("Microsoft.XMLHTTP");  
        }

        req.open("GET", url, true);
        req.onreadystatechange = callback;  
        req.send(null);   
    }

    function callback() {
    	if(req.readyState == 4 && req.status == 200) {  
            var res = req.responseText; 
            res = res.replace(new RegExp(/high/g),'高');
            res = res.replace(new RegExp(/middle/g),'中');
            res = res.replace(new RegExp(/low/g),'低');
            res = res.replace(new RegExp(/(not found)/g),'未发现');
            res = res.replace(new RegExp(/(null)/g),'无');
            $("#table-body").html(res);
        }
    	
    	$("th").css("font-family", "Microsoft Yahei");
        $("td").css("font-family", "Microsoft Yahei");
    }
</script>