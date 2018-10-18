<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>list</title>
</head>

<!--
    处理静态资源：
    spring-mvc中配置:<mvc:default-servlet-handler/>
-->
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
  /*将超链接的get请求转成post请求*/
  $(function () {
      $(".delete").click(function () {
          var href = $(this).attr("href");
          $("form").attr("action", href).submit();
          return false;
      })
  })
</script>

<body>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>

    <c:if test="${empty requestScope.employees}">
        没有任何员工信息
    </c:if>
    <c:if test="${!empty requestScope.employees}">
        <table border="1" cellpadding="10" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>LastName</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Department</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>

            <c:forEach items="${requestScope.employees }" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.email}</td>
                    <td>${emp.gender == 0 ? 'Female' : 'male'}</td>
                    <td>${emp.department.departName}</td>
                    <td><a href="emp/${emp.id}">Edit</a></td>
                    <td><a class="delete" href="emp/${emp.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <br><br>

    <a href="emp">Add New Employee</a>
</body>
</html>
