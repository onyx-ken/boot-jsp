<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form id="frm" action="/item/add" method="post">
        <div>
            <label for="itemName">상품명</label>
            <input type="text" id="itemName" name="itemName" class="form-control" placeholder="이름을 입력하세요" value="${itemVO.itemName}">
        </div>
        <div>
            <label for="itemPrice">가격</label>
            &nbsp;&nbsp;&nbsp;<span id="price-validation" style="visibility: hidden; color: red" >최소 입력 금액은 1000원 이상입니다</span>
            <input type="text" id="itemPrice" name="itemPrice" class="form-control" placeholder="가격을 입력하세요" value="${itemVO.itemPrice}">
        </div>
        <div>
            <label for="itemQty">수량</label>
            <input type="text" id="itemQty" name="itemQty" class="form-control" placeholder="수량을 입력하세요" value="${itemVO.itemQty}">
        </div>
        <hr class="my-4">
        <div class="row">
            <div class="col">
                <button class="w-100 btn btn-primary btn-lg" type="button" id="btn-submit">상품 등록</button>
            </div>
            <div class="col">
                <button class="w-100 btn btn-secondary btn-lg" type="button" onclick="location.href='/item/list'">취소
                </button>
            </div>
        </div>
        </form>
</div>
</body>
<script>
    let formCheck = false; // 폼 검증이 모두 맞아야 submit이 가능하도록 사용하기 위한 boolean 값
    let focus; // 사용자가 다시 입력 해야 할 폼의 위치를 넣어줄 변수
    const priceMinValueRule = 1000; // 검증 조건을 위한 변수

    const priceForm = document.querySelector('#itemPrice');
    priceForm.addEventListener('keyup', event => { // keyup 이벤트로 폼이 끝날 때 마다 검증 결과를 사용자에게 전달
        let value = priceForm.value;
        const priceVal = document.querySelector('#price-validation');
        if (value <= priceMinValueRule) {
            priceVal.style.visibility = "visible"; // 검증 실패한 경우이므로 메시지 표시
            formCheck = false; // 폼 검증을 실패
            focus = priceForm; // 폼 검증이 아직 마치치 않은 input 부분을 변수에 담는다
        } else {
            priceVal.style.visibility = "hidden"; // 검증 통과로 메시지를 감춤
            formCheck = true; // 폼 검증을 성공

        }
    });

    const btnSubmit = document.querySelector('#btn-submit');
    btnSubmit.addEventListener('click', () => {
        if (formCheck) { // 폼 검증이 끝났으므로, 정상적으로 submit이 가능
            const frm = document.querySelector('#frm');
            frm.submit();
        }else {
            focus.focus(); // 검증이 필요한 input의 위치를 사용자에게 알려준다
        }
    });
</script>
</html>