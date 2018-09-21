<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testPojo</title>
</head>
<body>
    <form action="testPojo" method="post">
        username:<input type="text" name="username" placeholder="请输入用户名"/>
        <br>
        password:<input type="password" name="password" placeholder="请输入密码"/>
        <br>
        email:<input type="text" name="email" placeholder="请输入邮箱"/>
        <br>
        age:<input type="text" name="age" placeholder="请输入年龄"/>
        <br>
        province:<input type="text" name="address.province" placeholder="请输入省份"/>
        <br>
        city:<input type="text" name="address.city" placeholder="请输入城市"/>
        <br>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
