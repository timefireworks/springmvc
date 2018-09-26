<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <fmt:message key="i18n.username"></fmt:message>
    <br><br>

    <fmt:message key="i18n.password"></fmt:message>
    <br><br>

</body>
</html>
