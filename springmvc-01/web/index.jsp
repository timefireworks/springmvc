<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a href="hello">hello world</a>

    <br>

    <a href="testPathVariable/2">testPathVariable</a>

    <br><br>

    <%--post请求转成put请求:修改--%>
    <form action="testRest/4" method="post">
      <input type="hidden" name="_method" value="PUT"/>
      <input type="submit" value="Test Rest PUT"/>
    </form>

    <br><br>

    <%--post请求转成delete请求：删除--%>
    <form action="testRest/3" method="post">
      <input type="hidden" name="_method" value="DELETE"/>
      <input type="submit" value="Test Rest DELETE"/>
    </form>

    <br><br>

    <form action="testRest" method="post">
      <input type="submit" value="Test Rest POST"/>
    </form>

    <br><br>

    <a href="testRest/1">Test Rest Get</a>

  </body>
</html>
