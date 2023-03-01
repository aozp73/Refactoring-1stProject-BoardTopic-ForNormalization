<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

    <div class="container my-3 py-3 px-3">
        <div class="justify-content-center d-flex py-3">
            <h2>로그인</h2>
        </div>
        <div class="justify-content-center d-flex">
            <nav class="navbar navbar-expand-sm bg-light navbar-light" style="width: 50%;">
                <div class="container-fluid">
                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">일반회원</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/company/loginForm">기업회원</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
        <div class="justify-content-center d-flex">
            <div class="my-border-color-default px-3 py-3" style="width: 50%; ">
                <form action="/user/login" method="post">
                    <div class="my-4">
                        <input name="username" type="text" class="form-control" aria-describedby="emailHelp" placeholder="Username">
                    </div>
                    <div class="my-4">
                        <input name="password" type="password" class="form-control" placeholder="Password">
                    </div>
                    <div class="mb-3 form-check">
                        <input type="checkbox" class="form-check-input">
                        <label class="form-check-label">아이디 기억하기</label>
                    </div>
                    <div class="d-flex justify-content-center">
                        <button type="submit" class="btn btn-primary my-button-color-default">로그인</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
 <%@ include file="../layout/footer.jsp" %>