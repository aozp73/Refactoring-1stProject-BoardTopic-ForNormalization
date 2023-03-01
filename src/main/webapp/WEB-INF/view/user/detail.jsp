<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

    <div class="container my-3">
        <div class="mt-3">
            <div class="row">
                <div class=" col-sm-4 p-3">
                    <div class="my-border-color-default m-3 rounded-1" style="height: 100%;">
                        <div class="col-12 p-3">
                            <div class="row">
                                <div class="col-sm-5 m-3">
                                    <h3><c:choose>
                                            <c:when test="${user.realName == null}">
                                                비공개
                                            </c:when>
                                            <c:otherwise>
                                                ${user.realName}
                                            </c:otherwise>
                                        </c:choose></h3>
                                </div>
                                <div class="col-sm-5">
                                    <img src="${user.profile == null ? " /images/newjeans.jpg" :
                                            user.profile}" class="rounded-circle"
                                        style="max-width: 100%; height: auto;">
                                </div>
                            </div>
                        </div>
                        <div class="col-10 m-3 p-3">
                            <hr>
                            <h3>빙그레 공채 1차</h3>
                            <!-- !현재 신청중인 공고가 없다면 안보임 -->
                            <hr>
                        </div>
                        <div class="col-10 m-3 p-3">
                            <h3 class="mt-3">주요 인적사항</h3>
                            <hr>
                            <ul class="nav nav-pills flex-column">
                                <li class="nav-item">
                                    <div class="row">
                                        <div class="col-3 ps-3 pe-0">
                                            주소 : 
                                        </div>
                                        <div class="col-9 ps-0">
                                            <c:choose>
                                                <c:when test="${user.address == null}">
                                                    비공개
                                                </c:when>
                                                <c:otherwise>
                                                    ${user.realName}
                                                </c:otherwise>
                                            </c:choose><br>
                                            <c:choose>
                                                <c:when test="${user.detailAddress == null}">
                                                    비공개
                                                </c:when>
                                                <c:otherwise>
                                                    ${user.detailAddress}
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </li>
                                <br>
                                <li class="nav-item">
                                    <div class="row">
                                        <div class="col-3 ps-3 pe-0">
                                            학력 :
                                        </div>
                                        <div class="col-9 ps-0">
                                            4년제 대학 졸업
                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <div class="row">
                                        <div class="col-3 ps-3 pe-0">
                                            경력 :
                                        </div>
                                        <div class="col-9 ps-0">
                                            <c:choose>
                                                <c:when test="${user.career == 0}">
                                                    신입
                                                </c:when>
                                                <c:otherwise>
                                                    ${user.career} 년차
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                        <div class="col-10 m-3 p-3">
                            <h3 class="mt-3">연락처</h3>
                            <hr>
                            <ul class="nav nav-pills flex-column">
                                <li class="nav-item">
                                    <div class="row">
                                        <div class="col-4 px-0" style="text-align: right;">
                                            전화번호 :
                                        </div>
                                        <div class="col-8">
                                            <c:choose>
                                                <c:when test="${user.tel == null}">
                                                    비공개
                                                </c:when>
                                                <c:otherwise>
                                                    ${user.tel}
                                                </c:otherwise>
                                            </c:choose> 
                                        </div>
                                    </div>
                                </li>
                                <li class="nav-item">
                                    <div class="row">
                                        <div class="col-4 px-0" style="text-align: right;">
                                            email :
                                        </div>
                                        <div class="col-8">
                                            <c:choose>
                                                <c:when test="${user.email == null}">
                                                    비공개
                                                </c:when>
                                                <c:otherwise>
                                                    ${user.email}
                                                </c:otherwise>
                                            </c:choose>
                                            <!-- 이메일이 길어질경우 후에 간격 수정가능 -->
                                        </div>
                                    </div>
                                </li>

                            </ul>
                        </div>

                        <hr class="d-sm-none">
                    </div>
                </div>
                <div class="col-sm-8 p-3 ">
                    <div class="p-3 m-3 my-border-color-default rounded-1">
                        <h2 class="p-3"><b>지원자 자기 소개</b></h2>
                        <hr>
                        <h5><c:choose>
                                <c:when test="${user.resumeTitle == null}">
                                    비공개
                                </c:when>
                                <c:otherwise>
                                    ${user.resumeTitle}
                                </c:otherwise>
                            </c:choose></h5>

                        <p><c:choose>
                                <c:when test="${user.resumeContent == null}">
                                    비공개
                                </c:when>
                                <c:otherwise>
                                    ${user.resumeContent}
                                </c:otherwise>
                            </c:choose></p>
                        
                    </div>
                    <div class="p-3 m-3 my-border-color-default rounded-1">
                        <h2 class="p-3"><b>경력 사항</b></h2>
                        <hr>
                        <h5>핵심 경력</h5>
                        <ul class="nav nav-pills flex-column">
                            <li class="nav-item">
                                보유 기술1
                            </li>
                            <li class="nav-item">
                                보유 기술2
                            </li>
                        </ul>
                    </div>
                    <div class="row p-3">
                        <div class="col-sm-6 b-3 p-3">
                        </div>
                        <div class="col-sm-2 b-3 p-3">
                        </div>
                        <div class="col-sm-2 ">
                            <button type="button" class="col-12 btn btn-outline-info">채용</button>
                        </div>
                        <div class=" col-sm-2 ">
                            <button type="button" class="col-12 btn btn-outline-danger">비채용</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
 <%@ include file="../layout/footer.jsp" %>