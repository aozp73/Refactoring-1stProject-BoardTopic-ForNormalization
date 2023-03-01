<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

    <div class="container my-3 py-3 px-3">
        <div class="my-border-color-default">
            <div class="my-boardDetail-header">
                <div class="row">
                    <div class="col-md-6 mb-2">
                        <div class="my-4 ms-4 pt-1 ps-2">
                            <div class="d-flex align-items-start" style="font-size: 20px;">
                                <div class="my-text-ellipsis">
                                    ${board.companyName}
                                </div>
                                <div class="ms-2"><i id="heart" class="fa-regular fa-heart my-xl my-cursor fa-sm"></i>
                                </div>
                            </div>
                            <div class="my-text-ellipsis" style="font-size: 22px;">
                                ${board.title}
                            </div>
                        </div>
                        <div class="my-boardDetail-header-sector1-grid">
                            <div>
                                <div class="mb-4 ms-4 ps-2" style="color:#5C667B">
                                    <div>
                                        경력
                                    </div>
                                    <div>
                                        학력
                                    </div>
                                    <div>
                                        근무형태
                                    </div>
                                    <div>
                                        우대사항
                                    </div>
                                </div>
                            </div>
                            <div style="width: 80%; color:#2D65F2;">
                                <div class="my-text-ellipsis">
                                    ${board.careerString}
                                </div>
                                <div class="my-text-ellipsis">
                                    ${board.educationString}
                                </div>
                                <div class="my-text-ellipsis">
                                    ${board.jobTypeString}
                                </div>
                                <div class="my-text-ellipsis">
                                    ${board.favor}
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                    </div>
                </div>
                <div class="pt-3 ps-1 my-borderDetail-color-left">
                    <div class="row d-flex justify-content-center mb-3 mt-3 pt-2" style="height: 80px; flex: 1 1 auto;">
                        <div class="col-md-1"></div>
                        <div class="col-md-7">
                            <img class="card-img-top" style="max-width: 170px;" src="${board.profile == null ? "/images/defaultProfile.png" : board.profile}"
                                alt="Card image">
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                    <div class="row ps-4">
                        <div class="col-md-5" style="color:#5C667B">
                            <div class="mb-2 my-text-ellipsis">회사이름
                            </div>
                            <div class="mb-2 my-text-ellipsis">회사규모
                            </div>
                            <div class="my-text-ellipsis">업종
                            </div>
                        </div>
                        <div class="col-md-6 ps-0">
                            <div class="mb-2 my-text-ellipsis">${board.companyName}</div>
                            <div class="mb-2 my-text-ellipsis">${board.companyScale}</div>
                            <div class="my-text-ellipsis">${board.companyField}</div>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <div class="container px-5 pt-5 pb-4 my-borderDetail-color-top">
                    <div>
                        <%-- <div class="d-flex justify-content-center mb-5">
                            <img class="img-fluid" style="height: 100%; width: auto;" src=""
                                alt="Card image">
                        </div> --%>
                        <div>
                            ${board.content}
                            <br>
                        </div>
                    </div>
                    <div class="d-flex justify-content-center mt-5">
                        <div><button type="submit" class="btn btn-primary my-button-color-default">지원하기</button></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<%@ include file="../layout/footer.jsp" %>