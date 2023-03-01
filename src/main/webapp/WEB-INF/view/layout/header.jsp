<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>구인구직</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script src="https://kit.fontawesome.com/32aa2b8683.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
    <link rel="stylesheet" href="/css/style.css">
</head>

<body>
    <div class="d-flex justify-content-center">
        <div class="text-center fs-1 my-5">
            <a href="/" class="no_under_line_link">구인해요</a>
        </div>
    </div>

    <nav class="navbar navbar-expand-sm my-bg-color-default navbar-dark">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
                <ul class="navbar-nav my-nav-bar">
                    <li class="nav-item fs-4 text-center">
                        <a class="nav-link" href="/board/list">채용정보</a>
                    </li>
                    <li class="nav-item fs-4 text-center">
                        <a class="nav-link" href="/user/list">인재정보</a>
                    </li>
                    <form class="d-flex">
                        <button class="btn btn-primary my-button-no-round" type="button"
                            style="display : none; visibility : hidden;"><img src="/images/search.png" alt="검색"
                                style="width: 20px; height: 23px;"></button>
                        <input class="form-control my-button-no-round text-center" type="text" placeholder="기업 검색">
                    </form>
                
                <c:choose>
                    <c:when test="${coPrincipal != null}">
                    <li class="nav-item fs-4 text-center">
                        <a class="nav-link" href="/company/updateForm">정보수정</a>
                    </li>
                    <li class="nav-item fs-4 text-center">
                        <a class="nav-link" href="/logout">로그아웃</a>
                    </li>
                    </c:when>
                    <c:when test="${usPrincipal != null}">
                    <li class="nav-item fs-4 text-center">
                        <a class="nav-link" href="/user/updateForm">정보수정</a>
                    </li>
                    <li class="nav-item fs-4 text-center">
                        <a class="nav-link" href="/logout">로그아웃</a>
                    </li>
                    </c:when>
                   <c:otherwise>
                    <li class="nav-item fs-4 text-center">
                        <a class="nav-link" href="/user/loginForm">로그인</a>
                    </li>
                    <li class="nav-item fs-4 text-center">
                        <a class="nav-link" href="/user/joinForm">회원가입</a>
                    </li>
                   </c:otherwise>
                </c:choose>
                </ul>
            </div>
        </div>
    </nav>
    <!-- 헤더 경계선 -->