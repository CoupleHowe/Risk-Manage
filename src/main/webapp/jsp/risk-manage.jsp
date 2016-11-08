<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style>
    * {
        margin: 0;
        padding: 0;
    }   

    html, body {
        height: 100%;
        background: rgb(247, 247, 247);
    }

    a {
        text-decoration: none;
    }

    .usr-manage:hover, .risk-manage:hover {
        text-decoration: underline;
    }
    </style>
</head>
<body>
    <div class="container" style="width: 900px; height: 100%; min-width: 900px; margin: 10px auto;">
        <div class="nav-container" style="height: 64px;">
            <div style="height: 64px; float: left;">
                <img src="./img/icon.png" alt="404" style="width: 64px; height: 64px; float: left;">
                <span style="line-height: 64px; font-weight: bold; font-family: Microsoft Yahei; font-size: 24px; margin-left: 20px;">风险管理系统</span>
            </div>

            <div style="float: right; height: 64px;">
                <ul style="height: 64px">
                    <li style="float: left; list-style: none; height: 64px"><a class="usr-manage" href="javascript:void(0)" style="line-height: 64px; color: black; font-family: Microsoft Yahei; font-size: 14px">用户管理</a></li>
                    <li style="float: left; list-style: none; height: 64px; margin-left: 20px;"><a class="risk-manage" href="javascript:void(0)" style="line-height: 64px; color: black; font-family: Microsoft Yahei; font-size: 14px">风险管理</a></li>
                </ul>
            </div>
        </div>

        <div class="content-container" style="margin-top: 50px;">
            <div class='btns' style="float: right;">
                <a href="addRisk" type="button" style="display: inline-block; width: 110px; height: 35px; color: white; background: rgb(66, 139, 202); border-radius: 5px; line-height: 35px; text-Align: center; font-family: Microsoft Yahei;">Add</a>                
            </div>

            <div class="table-container">       
            </div>
        </div>
    </div>
</body>
</html>