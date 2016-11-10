<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>

    <link rel="stylesheet" href="./utils/bootstrap/css/bootstrap.min.css">
    <script src="./utils/jquery.min.js"></script>
    <script src="./utils/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="background: rgb(0, 123, 182);">
    <div style="margin: 200px auto; width: 300px; height: 240px; background: rgb(0, 74, 110); border-radius: 20px; overflow: hidden;">
        <div style="margin: 20px 25px 20px 25px;">
            <input type="text" class="form-control" id="user_name" placeholder="User Name" style="width: 250px; height: 40px">
        </div>
        <div style="margin: 20px 25px 20px 25px;">
            <input type="password" class="form-control" id="password" placeholder="Password" style="width: 250px; height: 40px">
        </div>
        <p id="hint" style="margin-left: 25px; margin-bottom: 0px; margin-top: 15px; height: 20px; color: red; font-family: Microsoft Yahei;"></p>
        <div style="margin: 0px 25px 10px 25px; line-height">
            <button type="button" id="sign-in" class="btn btn-primary" style="width: 250px; height: 40px">Sign In</button>
        </div>
        <p style="color: white; float: right; margin-right: 25px;">No Account? <a href="./join.jsp" style="font-weight: bold;">Sign Up</a> instead!</p>
    </div>
</body>
</html>

<script>
    var req;
    $("#sign-in").click(function() {
        var user_name = encodeURI(document.getElementById("user_name").value.trim());
        var password = encodeURI(document.getElementById("password").value.trim());
        var url = "findUser?user_name=" + user_name + "&password=" + password;

        if(user_name === "")
            $("#hint").text("用户名不能为空");
        else if(password === "")
            $("#hint").text("密码不能为空");
        else {
            // 创建XMLHttoRequest对象
            if(window.XMLHttpRequest) {  
                req = new XMLHttpRequest();  
            }else if(window.ActiveXObject) {  
                req = new ActiveXObject("Microsoft.XMLHTTP");  
            }

            req.open("GET", url, true);
            req.onreadystatechange = login;  
            req.send(null);       
        }
    })

    function login() {
        if(req.readyState == 4 && req.status == 200) {  
            var check = req.responseText;  
            
            if(check === "YES") {
                window.location.href="./jsp/rms-add-risk.jsp"; 
            }
            else if(check === "NO") {
                $("#hint").text("用户不存在或密码错误");
            }
        }  
    }
</script>