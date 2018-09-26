<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>input</title>
</head>
<body>
    <!--
        1、使用form标签：可以更快速的开发出表单页面，而且可以更方便的进行表单值的回显
        2、注意：
           可以通过modelAttribute属性指定绑定的模型属性
           若没有指定该属性，则会默认从request域对象中读取command的表单bean
           如果该属性值也不存在，则会发生错误
     -->
    <form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">
        <!-- paht属性对应html表单标签的name属性值 -->
        <c:if test="${employee.id == null}">
            LastName: <form:input path="lastName"/>
        </c:if>
        <c:if test="${employee.id != null}">
            <form:hidden path="id" />
            <%--对于_method不能使用form:hidden标签，因为modelAttribute对应的bean没有_method这个属性--%>
            <%--<form:hidden path="_method" value="PUT"/>--%>
            <input type="hidden" name="_method" value="PUT" />
        </c:if>
        <br>
        Email: <form:input path="email"/>
        <br>
        <%
            Map<String, String> genders = new HashMap();
            genders.put("1", "Male");
            genders.put("2", "feMale");

            request.setAttribute("genders", genders);
        %>
        Gender: <form:radiobuttons path="gender" items="${genders}"/>
        <br>
        Department: <form:select path="department.id" items="${departments}" itemLabel="departName" itemValue="id"></form:select>
        <br>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
