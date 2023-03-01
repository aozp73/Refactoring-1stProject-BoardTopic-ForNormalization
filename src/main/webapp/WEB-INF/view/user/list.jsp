<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

      <div class="container my-3 py-3 px-3">
            <div class="p-3">
                  <h2 style="text-align: center;">인재 목록</h2>
            </div>
            <div class="d-flex justify-content-end mb-2">
                  <select class="form-select" style="width: 123px;">
                        <option>관련도순</option>
                        <option> 연차순</option>
                        <option> 날짜순</option>
                  </select>
            </div>
            <div class="my-border-color-default p-3">
                  <!-- 카드 들어갈 곳 -->
                  <div class="row gx-3">
                        <c:forEach items="${userList}" var="user">
                        <div class="col-md-3 py-2">
                              <div id="user${user.id}" onmouseenter="mouseEnterImages(this)"
                                    onmouseleave="mouseLeaveImages(this)" class="card col-lg-12">
                                    <a href="/user/${user.id}" class="no_under_line_link">
                                          <img class="card-img-top" style="height: 100px;" src="${user.profile == null ? " /images/newjeans.jpg" :
                                            user.profile}"
                                                alt="Card image">
                                          <div class="card-body">
                                                <div class="my-text-ellipsis">
                                                      <h5>${user.realName}</h5>
                                                </div>
                                                <div class="my-text-ellipsis">
                                                      <c:choose>
                                                      <c:when test="${user.career == 0}">
                                                      신입
                                                      </c:when>
                                                      <c:otherwise>
                                                      ${user.career} 년차
                                                      </c:otherwise>
                                                      </c:choose>
                                                </div>
                                                <div class="my-text-ellipsis">
                                                      ${user.resumeTitle}
                                                </div>
                                          </div>
                                    </a>
                                    <div class="card-footer d-flex justify-content-between">
                                          <div>${user.createdAtToString}</div>
                                          <div><i id="heart" class="fa-regular fa-heart my-xl my-cursor fa-lg"></i>
                                          </div>
                                    </div>
                              </div>
                        </div>
                        </c:forEach>
                        <!-- 반복문 종료 -->
                  </div>
            </div>
            <div class="p-3">
                  <div class="row">
                        <div class="col-md-3 py-2">
                              <div id="userImage5" onmouseenter="mouseEnterImages(this)"
                                    onmouseleave="mouseLeaveImages(this)" class="card col-lg-12">
                                    <a href="/user/1" class="no_under_line_link">
                                          <img class="card-img-top" style="height: 100px;" src="/images/newjeans.jpg"
                                                alt="Card image">
                                          <div class="card-body">
                                                <div class="my-text-ellipsis">
                                                      <h5>박이름</h5>
                                                </div>
                                                <div class="my-text-ellipsis">
                                                      IT직 경력 5년차
                                                </div>
                                                <div class="my-text-ellipsis">
                                                      자기소개문
                                                </div>
                                          </div>
                                    </a>
                                    <div class="card-footer d-flex justify-content-between">
                                          <div>2023.01.01</div>
                                          <div><i id="heart" class="fa-regular fa-heart my-xl my-cursor fa-lg"></i>
                                          </div>
                                    </div>
                              </div>
                        </div>
                        <div class="col-md-3 py-2">
                              <div id="userImage6" onmouseenter="mouseEnterImages(this)"
                                    onmouseleave="mouseLeaveImages(this)" class="card col-lg-12">
                                    <a href="/user/1" class="no_under_line_link">
                                          <img class="card-img-top" style="height: 100px;" src="/images/newjeans.jpg"
                                                alt="Card image">
                                          <div class="card-body">
                                                <div class="my-text-ellipsis">
                                                      <h5>박네임</h5>
                                                </div>
                                                <div class="my-text-ellipsis">
                                                      IT직 신입
                                                </div>
                                                <div class="my-text-ellipsis">
                                                      자기소개문
                                                </div>
                                          </div>
                                    </a>
                                    <div class="card-footer d-flex justify-content-between">
                                          <div>2023.01.01</div>
                                          <div><i id="heart" class="fa-regular fa-heart my-xl my-cursor fa-lg"></i>
                                          </div>
                                    </div>
                              </div>
                        </div>
                        <div class="col-md-3 py-2">
                              <div id="userImage7" onmouseenter="mouseEnterImages(this)"
                                    onmouseleave="mouseLeaveImages(this)" class="card col-lg-12">
                                    <a href="/user/1" class="no_under_line_link">
                                          <img class="card-img-top" style="height: 100px;" src="/images/newjeans.jpg"
                                                alt="Card image">
                                          <div class="card-body">
                                                <div class="my-text-ellipsis">
                                                      <h5>최이름</h5>
                                                </div>
                                                <div class="my-text-ellipsis">
                                                      IT직 경력 7년차
                                                </div>
                                                <div class="my-text-ellipsis">
                                                      자기소개문
                                                </div>
                                          </div>
                                    </a>
                                    <div class="card-footer d-flex justify-content-between">
                                          <div>2023.01.01</div>
                                          <div><i id="heart" class="fa-regular fa-heart my-xl my-cursor fa-lg"></i>
                                          </div>
                                    </div>
                              </div>
                        </div>
                        <div class="col-md-3 py-2">
                              <div id="userImage8" onmouseenter="mouseEnterImages(this)"
                                    onmouseleave="mouseLeaveImages(this)" class="card col-lg-12">
                                    <a href="/user/1" class="no_under_line_link">
                                          <img class="card-img-top" style="height: 100px;" src="/images/newjeans.jpg"
                                                alt="Card image">
                                          <div class="card-body">
                                                <div class="my-text-ellipsis">
                                                      <h5>최네임</h5>
                                                </div>
                                                <div class="my-text-ellipsis">
                                                      IT직 신입
                                                </div>
                                                <div class="my-text-ellipsis">
                                                      자기소개문
                                                </div>
                                          </div>
                                    </a>
                                    <div class="card-footer d-flex justify-content-between">
                                          <div>2023.01.01</div>
                                          <div><i id="heart" class="fa-regular fa-heart my-xl my-cursor fa-lg"></i>
                                          </div>
                                    </div>
                              </div>
                        </div>
                  </div>
            </div>
      </div>
      <script>
            function mouseEnterImages(e) {
                  let id = e.getAttribute('id');
                  $("#" + id).addClass("border border-primary");
            }

            function mouseLeaveImages(e) {
                  let id = e.getAttribute('id');
                  $("#" + id).removeClass("border border-primary");
            }
      </script>

 <%@ include file="../layout/footer.jsp" %>