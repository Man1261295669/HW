<%@ page import="java.util.List" %>
<%@ page import="com.example.demo1.model.Beer" %><%--
  Created by IntelliJ IDEA.
  User: 39563
  Date: 2021/5/6
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>String Recommended JSP</title>
</head>
<body>
<%
    List<Beer> styles = (List<Beer>) request.getAttribute("styles");
    out.println("<br/>this is a jsp page");
    for (Beer brand: styles) {
        out.println("<br/>try: " + brand);
    }
%>

</body>
</html>
