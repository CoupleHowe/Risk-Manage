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
    <div style="min-width: 1366px;">
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
                    <li role="presentation"><a role="menuitem" href="#" style="font-family: Microsoft Yahei; line-height: 30px;  color: #463265">添加条目</a></li>
                    <li role="presentation"><a role="menuitem" href="#" style="font-family: Microsoft Yahei; line-height: 30px;  color: #463265">风险追踪</a></li>
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

        <div style="width: 600px; margin: 100px auto;">
            <form class="form-horizontal" role="form">
                <div class="form-group">
                    <label for="risk-content" class="col-sm-2 control-label" style="font-family: Microsoft Yahei;">风险内容</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="risk-content">
                    </div>
                </div>

                <div class="form-group">
                    <label for="possibility" class="col-sm-2 control-label" style="font-family: Microsoft Yahei;">可能性</label>
                    <div class="col-sm-10" id="possibility">
                        <label class="radio-inline">
                            <input type="radio" name="possibility" id="possibility-high" value="high"><span style="font-family: Microsoft Yahei;"> 高</span>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="possibility" id="possibility-middle" value="middle"><span style="font-family: Microsoft Yahei;"> 中</span>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="possibility" id="possibility-low" value="low"><span style="font-family: Microsoft Yahei;"> 低</span>
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="effect-level" class="col-sm-2 control-label" style="font-family: Microsoft Yahei;">影响程度</label>
                    <div class="col-sm-10" id="effect-level">
                        <label class="radio-inline">
                            <input type="radio" name="effect-level" id="effect-level-high" value="high"><span style="font-family: Microsoft Yahei;"> 高</span>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="effect-level" id="effect-level-middle" value="middle"><span style="font-family: Microsoft Yahei;"> 中</span>
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="effect-level" id="effect-level-low" value="low"><span style="font-family: Microsoft Yahei;"> 低</span>
                        </label>
                    </div>
                </div>

                <div class="form-group">
                    <label for="threshold-value" class="col-sm-2 control-label" style="font-family: Microsoft Yahei;">阈值</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="threshold-value">
                    </div>
                </div>

                <div class="form-group">
                    <label for="submitter" class="col-sm-2 control-label" style="font-family: Microsoft Yahei;">提交者</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="submitter">
                    </div>
                </div>

                <div class="form-group">
                    <label for="tracker" class="col-sm-2 control-label" style="font-family: Microsoft Yahei;">追踪者</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="tracker">
                    </div>
                </div>

                <div class="form-group" style="text-align: right;">
                    <span id="hint" style="color: red; font-family: Microsoft Yahei; margin-right: 20px;"></span>
                    <button id="submit-btn" type="button" class="btn btn-primary" style="font-family: Microsoft Yahei; width: 100px; margin-right: 15px;">提交</button>
                </div>
            </form>
        </div>
    </div>

</body>
</html>

<script>
    $("#submit-btn").click(function() {
        var riskContent = document.getElementById("risk-content").value.trim();
        var possibity = $('input:radio[name="possibity"]:checked').val();        
        var effectLevel = $('input:radio[name="effect-level"]:checked').val();
        var thresholdValue = document.getElementById("threshold-value").value.trim();
        var submitter = document.getElementById("submitter").value.trim();
        var tracker = document.getElementById("tracker").value.trim();

        if(riskContent === "")
            $("#hint").text("风险内容不能为空!");
        else if(thresholdValue === "")
            $("#hint").text("阈值不能为空!");
        else if(submitter === "")
            $("#hint").text("提交者不能为空!");
        else if(tracker === "")
            $("#hint").text("追踪者不能为空!");
        else if(possibity === undefined)
            $("#hint").text("请选择可能性!");
        else if(effectLevel === undefined)
            $("#hint").text("请选择影响程度!");
        else {
       		var url = "addRisk?riskContent=" + riskContent + "&possibity=" + possibity + "&effectLevel=" + effectLevel + "$thresholdValue=" + thresholdValue + "$submitter=" + submitter + "&tracker=" + tracker;
        	
            if(window.XMLHttpRequest) {  
                req = new XMLHttpRequest();  
            }else if(window.ActiveXObject) {  
                req = new ActiveXObject("Microsoft.XMLHTTP");  
            }
	
            req.open("GET", url, true);
            req.send(null);       
        }
    });    
</script>