<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>testModelAttribute</title>
</head>
<body>

    <form action="testModelAttribute" method="post">
        <input type="hidden" name="id" value="1" />
        username: <input type="text" name="username" value="Tom" /><br>
        email:<input type="text" name="email" value="tom@123.com" /><br>
        age:<input type="text" name="age" value="12" /><br>
        <input type="submit" value="Submit" />
    </form>

</body>
</html>
