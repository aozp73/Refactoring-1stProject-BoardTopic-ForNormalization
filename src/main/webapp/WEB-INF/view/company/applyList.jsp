<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <div class="container my-3 py-3 px-3">
            <div class="p-3">
                <h2 style="text-align: center;">지원자 목록</h2>
            </div>
            <div class="container m-3">
                <table class="table table-hover">
                    <thead class="my-bg-color-default">
                        <tr class="text-center text-white">
                            <th>번호</th>
                            <th style="width: 20%;">이름</th>
                            <th style="width: 30%;">지원 공고</th>
                            <th style="width: 20%;">지원 분야</th>
                            <th style="width: 20%;">지원 일자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- 반복문 -->
                        <c:forEach items="${applyList}" var="apply" varStatus="status">
                            <!-- 링크걸기 -->
                            <tr>
                                <td class="text-center">${status.count}</td>
                                <td class="text-center"><a href="/user/${apply.userId}" class="no_under_line_link"
                                        style="width: 100%; display: block;">${apply.realName}</a></td>
                                <td class="my-text-ellipsis"><a href="/board/${apply.boardId}"
                                        class="no_under_line_link" style="width: 100%; display: block;">
                                        ${apply.title}</a></td>
                                <td class="my-text-ellipsis">${apply.jobType}</td>
                                <td class="text-center my-text-ellipsis">${apply.createdAt}</td>
                            </tr>
                        </c:forEach>
                        <!-- 반복문종료 -->
                    </tbody>
                </table>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-sm-4 b-3 p-3">
                    </div>
                    <div class="col-sm-4 b-3 p-3">
                        <div class="row">
                            <div class="col-sm-3 b-3 p-3">
                            </div>
                            <div class="col-sm-4">
                                <ul class="pagination">
                                    <li class="page-item"><a class="page-link" href="#">이전</a></li>
                                </ul>
                            </div>
                            <div class="col-sm-4">
                                <ul class="pagination">
                                    <li class="page-item"><a class="page-link" href="#">다음</a></li>
                                </ul>
                            </div>
                            <div class="col-sm-1 b-3 p-3">
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4 b-3 p-3">
                        <form class="d-flex">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="../layout/footer.jsp" %>