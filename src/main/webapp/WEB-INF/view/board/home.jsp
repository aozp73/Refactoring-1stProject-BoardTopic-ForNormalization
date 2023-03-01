<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <div class="container my-3 py-3 px-3">
            <div class="row">
                <div id="mainImage1" class="col d-flex justify-content-center" onmouseenter="popularEnterImages(this)"
                    onmouseleave="popularLeaveImages(this)">
                    <img src="/images/newjeans.jpg" class="img-thumbnail" alt="Cinque Terre">
                </div>
                <div id="mainImage2" class="col d-flex justify-content-center" onmouseenter="popularEnterImages(this)"
                    onmouseleave="popularLeaveImages(this)">
                    <img src="/images/newjeans.jpg" class="img-thumbnail" alt="Cinque Terre">
                </div>
                <div id="mainImage3" class="col d-flex justify-content-center" onmouseenter="popularEnterImages(this)"
                    onmouseleave="popularLeaveImages(this)">
                    <img src="/images/newjeans.jpg" class="img-thumbnail" alt="Cinque Terre">
                </div>
            </div>
            <div>
                <!-- 카드 들어갈 곳 -->
                <div class="row">

                    <c:forEach items="${boardMainList}" var="board">
                        <div class="col-md-3 py-2">
                            <a href="/board/${board.id}" class="no_under_line_link">
                                <div id="boardImage-${board.id}" class="card col-lg-12"
                                    onmouseenter="boardEnterImages(this)" onmouseleave="boardLeaveImages(this)">
                                    <div class="d-flex justify-content-center">
                                        <img class="card-img-top" style="height: 100px; max-width: 200px;"
                                            src="${board.profile == null ? "/images/defaultProfile.png" :
                                            board.profile}" alt="Card image">
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
        </div>

        <script>
            function popularEnterImages(e) {
                console.log(e.getAttribute('id'));
                let id = e.getAttribute('id');
                $("#" + id).removeClass("col");
                $("#" + id).addClass("col-6");
            }
            function popularLeaveImages(e) {
                console.log(e.getAttribute('id'));
                let id = e.getAttribute('id');
                $("#" + id).removeClass("col-6");
                $("#" + id).addClass("col");
            }

            function boardEnterImages(e) {
                let id = e.getAttribute('id');
                $("#" + id).addClass("border border-primary");
            }
            function boardLeaveImages(e) {
                let id = e.getAttribute('id');
                $("#" + id).removeClass("border border-primary");
            }
        </script>

        <%@ include file="../layout/footer.jsp" %>