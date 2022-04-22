<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
    <title>로그인 하기</title>
    <meta charset="UTF-8">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 560px;
        }
        .error {
            border-color: #dc3545;
            color: #dc3545;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="py-5 text-center">
        <h2>로그인</h2>
    </div>
    <form action="/login" method="post">
        <div class="error">
            <spring:hasBindErrors name="loginDTO">
                <c:if test="${errors.hasGlobalErrors()}">
                    <c:forEach items="${errors.globalErrors}" var="err">
                        <strong>${err.defaultMessage}</strong>
                    </c:forEach>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <div>
            <label for="loginId">로그인 ID</label>
            <input type="text" id="loginId" name="loginId" class="form-control" value="${loginDTO.loginId}">
        </div>
        <div>
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" class="form-control">
        </div>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="submit"> 로그인</button>
            </div>
            <div class="col">
                <button class="w-100 btn btn-secondary btn-lg" onclick="location.href='/'" type="button">취소</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>
