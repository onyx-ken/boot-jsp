<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <h2>상품 수정 폼</h2>
    </div>
    <form action="/item/update" method="post">
        <div>
            <label for="itemId">상품 ID</label>
            <input type="text" id="itemId" name="itemId" class="form-control" value="${item.itemId}" readonly>
        </div>
        <div>
            <label for="itemName">상품명</label>
            <input type="text" id="itemName" name="itemName" class="form-control" value="${item.itemName}">
        </div>
        <div>
            <label for="itemPrice">가격</label>
            <input type="text" id="itemPrice" name="itemPrice" class="form-control" value="${item.itemPrice}">
        </div>
        <div>
            <label for="itemQty">수량</label>
            <input type="text" id="itemQty" name="itemQty" class="form-control" value="${item.itemQty}">
        </div>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="submit">저장
                </button>
            </div>
            <div class="col">
                <button class="w-100 btn btn-secondary btn-lg" onclick="location.href='/item/list'" type="button">취소</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>