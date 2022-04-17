<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
<head>
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
        <h2>상품 등록 폼</h2>
    </div>
    <h4 class="mb-3">상품 입력</h4>
    <spring:hasBindErrors name="itemVO">
        <c:if test="${errors.hasGlobalErrors()}">
            <p>${errors.globalError.defaultMessage}</p>
        </c:if>
    </spring:hasBindErrors>
    <form:form modelAttribute="itemVO" action="/item/add" method="post">
        <div>
            <label for="itemName">상품명</label>
            <form:input type="text" id="itemName" name="itemName" class="form-control" placeholder="이름을 입력하세요" path="itemName"/>
            <form:errors path="itemName"/>
        </div>
        <div>
            <label for="itemPrice">가격</label>
            <form:input type="text" id="itemPrice" name="itemPrice" class="form-control" placeholder="가격을 입력하세요" path="itemPrice"/>
            <form:errors path="itemPrice"/>
        </div>
        <div>
            <label for="itemQty">수량</label>
            <form:input type="text" id="itemQty" name="itemQty" class="form-control" placeholder="수량을 입력하세요" path="itemQty"/>
            <form:errors path="itemQty"/>
        </div>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="submit">상품 등록</button>
            </div>
            <div class="col">
                <button class="w-100 btn btn-secondary btn-lg" type="button" onclick="location.href='/item/list'">취소
                </button>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>