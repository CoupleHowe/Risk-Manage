<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>

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
            <button type="button" id="sign-up" class="btn btn-success" style="width: 250px; height: 40px">Sign Up</button>
        </div>
        <p style="color: white; float: right; margin-right: 25px;">Have an account? <a href="./index.jsp" style="font-weight: bold;">Sign In</a> instead!</p>
    </div>
</body>
</html>

<script>
    var req;
    $("#sign-up").click(function() {
        var user_name = document.getElementById("user_name").value.trim();
        var password = document.getElementById("password").value.trim();
       	var url = "addUser?user_name=" + user_name + "&password=" + password;

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
            req.onreadystatechange = register;  
            req.send(null);       
        }
    })

    function register() {
        if(req.readyState == 4 && req.status == 200) {  
            var check = req.responseText;  
            
            if(check === "YES") {
                window.location.href="./index.jsp"; 
            }
            else if(check === "NO") {
                $("#hint").text("用户名已存在");
            }
        }  
    }
</script>