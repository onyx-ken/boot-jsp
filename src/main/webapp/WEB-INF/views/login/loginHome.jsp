<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
    <title>로그인 홈</title>
    <meta charset="UTF-8">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="max-width: 600px">
    <div class="py-5 text-center">
        <h2>홈 화면</h2>
    </div>
    <h4 class="mb-3">${memberVO.memName} 님 환영합니다</h4>
    <hr class="my-4">
    <div class="row">
        <div class="col">
            <button class="w-100 btn btn-secondary btn-lg" type="button" onclick="location.href='/item/list'">
                상품 관리
            </button>
        </div>
        <div class="col">
            <form action="/login/out" method="post">
                <button class="w-100 btn btn-dark btn-lg" onclick="location.href=''" type="submit">
                    로그아웃
                </button>
            </form>
        </div>
    </div>
    <hr class="my-4">
</div>
</body>
</html>
