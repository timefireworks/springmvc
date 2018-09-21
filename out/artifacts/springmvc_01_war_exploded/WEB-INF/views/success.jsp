<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Hello World</h4>

    time:${time}
    <br><br><br>

    names:${names}
    <br><br><br>

    requestUser: ${requestScope.user}
    <br><br><br>

    sessionUser: ${sessionScope.user}
    <br><br><br>

    request school: ${requestScope.school}
    <br><br><br>

    session school: ${sessionScope.school}
    <br><br><br>
</body>
</html>
