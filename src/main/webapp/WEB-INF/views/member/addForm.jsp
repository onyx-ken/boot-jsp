<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="ko">
<head>
    <title>회원등록</title>
    <meta charset="utf-8">
    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 560px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="py-5 text-center">
        <h2>회원등록 폼</h2>
    </div>
    <h4 class="mb-3">회원 등록</h4>
    <form id="frm" action="/member/add" method="post">
        <div>
            <label for="memLoginId">아이디</label>
            <input type="text" id="memLoginId" name="memLoginId" class="form-control" placeholder="아이디를 입력하세요"
                   value="${memberVO.memLoginId}">
        </div>
        <div>
            <label for="memName">이름</label>
            <input type="text" id="memName" name="memName" class="form-control" placeholder="이름을 입력하세요"
                   value="${memberVO.memName}">
        </div>
        <div>
            <label for="memPassword">비밀번호</label>
            <input type="text" id="memPassword" name="memPassword" class="form-control" placeholder="비밀번호를 입력하세요"
                   value="${memberVO.memPassword}">
        </div>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="submit">회원 가입</button>
            </div>
            <div class="col">
                <button class="w-100 btn btn-secondary btn-lg" type="button" onclick="location.href='/'">취소
                </button>
            </div>
        </div>
    </form>
</div>
</body>
</html>