<%--
  Created by IntelliJ IDEA.
  User: justlex
  Date: 2/19/16
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>

<head>
    <title><tiles:insertAttribute name="title"/></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.0/jquery.validate.min.js"></script>
    <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/script.js"></script>
    <link href="${pageContext.request.contextPath}/static/css/styles.css" rel="stylesheet" type="text/css"/>
    <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
</head>
<body>
<div class="header">
    <tiles:insertAttribute name="header"/>
</div>
<br/>
<div class="body">
    <tiles:insertAttribute name="body"/>
</div>
<hr>
<div class="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>
<script>
</script>
</html>
