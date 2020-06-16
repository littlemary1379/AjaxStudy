<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Product Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  
</head>
<body>

<div class="container">
  <div>
  <button onclick="orderById()" type="button" class="btn btn-dark">처음으로</button>
  <button onclick="orderByPrice()" type="button" class="btn btn-dark">가격순</button>
  <button onclick="orderByCount()" type="button" class="btn btn-dark">판매순</button>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>번호</th>
        <th>이름</th>
        <th>종류</th>
        <th>가격</th>
        <th>판매수</th>
        <th>      </th>
      </tr>
    </thead>
    <tbody id="table__contents">
    <c:forEach var="product" items="${products}">
      <tr class="table__content__${product.id }"> 
        <td>${product.id }</td>
        <td>${product.name }</td>
        <td>${product.type }</td>
        <td>${product.price }</td>
        <td>${product.count }</td>
        <td><button onclick="deleteById(${product.id})">삭제</button></td>
      </tr>
    </c:forEach>  

    </tbody>
  </table>
  </div>
</div>

<script src="/Product/js/order.js"></script>
</body>
</html>