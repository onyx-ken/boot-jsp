<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>초기페이지</title>
</head>
<body>
    <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="now"/>
    <c:out value="${now}"/>
</body>
</html>