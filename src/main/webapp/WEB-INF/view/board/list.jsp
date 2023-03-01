<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <div class="container my-3 py-3 px-3">
            <div class="p-3">
                <h2 style="text-align: center;">채용 공고 목록</h2>
            </div>
            <div class="d-flex justify-content-end mb-2">
                <select class="form-select" style="width: 123px;">
                    <option>관련도순</option>
                    <option> 인기순</option>
                    <option> 날짜순</option>
                </select>
            </div>
            <!-- 카드 시작 -->
            <div class="p-3">
                <div class="row gx-3">

                <c:forEach items="${boardList}" var="board">
                    <div class="col-md-3 py-2">
                        <a href="/board/${board.id}" class="no_under_line_link">
                            <div id="boardImage-${board.id}" class="card col-lg-12"
                                onmouseenter="mouseEnterImages(this)" onmouseleave="mouseLeaveImages(this)">
                                <div class="d-flex justify-content-center">
                                <img class="card-img-top" style="height: 100px; max-width: 200px;" src="${board.profile == null ? " /images/defaultProfile.png" :
                                            board.profile}"
                                    alt="Card image">
                                    </div>
                                <div class="card-body">
                                    <div class="my-text-ellipsis">
                                        <h5>${board.companyName}</h5>
                                    </div>
                                    <div class="my-text-ellipsis">
                                        ${board.title}
                                    </div>
                                    <div class="my-text-ellipsis">
                                        채용
                                    </div>
                                </div>
                        </a>
                        <div class="card-footer d-flex justify-content-between">
                            <div>(D-1)</div>
                            <div><i id="heart" class="fa-regular fa-heart my-xl my-cursor fa-lg"></i></div>
                        </div>
                    </div>
                </div>
                </c:forEach>

        </div>
        </div>

        <!-- 페이징 -->

        <div class="d-flex justify-content-center mt-5" style="margin-bottom: 60px;">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <li class="page-item"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item"><a class="page-link" href="#">5</a></li>
                    <li class="page-item"><a class="page-link" href="#">6</a></li>
                    <li class="page-item"><a class="page-link" href="#">Next</a></li>
                </ul>
            </nav>
        </div>
        </div>

        <script>
            function mouseEnterImages(e) {
                // console.log(e.getAttribute('id'))
                let id = e.getAttribute('id');
                $("#" + id).addClass("border border-primary");
            }
            function mouseLeaveImages(e) {
                let id = e.getAttribute('id');
                $("#" + id).removeClass("border border-primary");
            }
        </script>

        <%@ include file="../layout/footer.jsp" %>