<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<head>
    <meta charset="UTF-8">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <title>초기페이지</title>
</head>
<body>
<div class="container" style="max-width: 600px">
    <div class="py-5 text-center">
        <h2>홈 화면</h2>
    </div>
    <div class="row">
        <div class="col">
            <button class="w-100 btn btn-secondary btn-lg" type="button" onclick="location.href='/member/add'">
                회원 가입
            </button>
        </div>
        <div class="col">
            <button class="w-100 btn btn-dark btn-lg" type="button" onclick="location.href='/login'">
                로그인
            </button>
        </div>
    </div>
    <hr class="my-4">
</div>
</body>
</html>