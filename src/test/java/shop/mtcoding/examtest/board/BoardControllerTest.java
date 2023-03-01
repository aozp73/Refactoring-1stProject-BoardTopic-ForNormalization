package shop.mtcoding.examtest.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import shop.mtcoding.examtest.board.dto.BoardReq.BoardUpdateReqDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardDetailRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardListRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardMainRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.BoardUpdateRespDto;
import shop.mtcoding.examtest.board.dto.BoardResp.MyBoardListRespDto;
import shop.mtcoding.examtest.user.model.User;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class BoardControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper om;

    private MockHttpSession mockSession;
    private MockHttpSession mockSession2;

    @BeforeEach
    public void setUp() {
        User companyUser = new User();
        companyUser.setId(6);
        companyUser.setUsername("cos");
        companyUser.setPassword("1234");
        companyUser.setEmail("cos@nate.com");
        companyUser.setAddress("부산시 빡구 동동");
        companyUser.setDetailAddress("71길");
        companyUser.setTel("01012341234");
        companyUser.setRole("company");
        // companyUser.setRole("employee");

        companyUser.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        mockSession = new MockHttpSession();
        mockSession.setAttribute("coPrincipal", companyUser);
    }

    @Test
    public void myBoardList_test() throws Exception {
        // given
        // int id = 7; 여기서 id:userId, 열람권한 없음 체크
        int id = 6;

        // when
        ResultActions resultActions = mvc.perform(
                get("/board/boardList/" + id).session(mockSession));

        Map<String, Object> map = resultActions.andReturn().getModelAndView().getModel();
        List<MyBoardListRespDto> boardListDto = (List<MyBoardListRespDto>) map.get("myBoardList");
        // String model = om.writeValueAsString(boardListDto);
        // System.out.println("테스트 : " + model);

        // then
        resultActions.andExpect(status().is2xxSuccessful());
    }

    @Test
    public void update_test() throws Exception {
        // given
        // int id = 3;
        int id = 1;

        BoardUpdateReqDto boardUpdateReqDto = new BoardUpdateReqDto();
        // boardUpdateReqDto.setId(3); 수정권한 체크
        // boardUpdateReqDto.setUserId(2);
        boardUpdateReqDto.setId(1);
        boardUpdateReqDto.setUserId(1);
        boardUpdateReqDto.setTitle("테스트 제목");
        boardUpdateReqDto.setContent("테스트 내용");
        boardUpdateReqDto.setCareerString("1년이상 ~ 3년미만");
        boardUpdateReqDto.setEducationString("4년 대졸이상");
        boardUpdateReqDto.setJobTypeString("정규직");
        boardUpdateReqDto.setFavor("관련 프로젝트 경험");

        String requestBody = om.writeValueAsString(boardUpdateReqDto);

        // when
        ResultActions resultActions = mvc.perform(
                put("/board/update/" + id)
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .session(mockSession));

        // then
        resultActions.andExpect(status().isOk());

    }

    @Test
    public void updateForm_test() throws Exception {
        // given
        // int id = 3; 수정 권한없음 체크
        // int id = 10; 없는 게시물 체크
        int id = 2;

        // when
        ResultActions resultActions = mvc.perform(
                get("/board/updateForm/" + id)
                        .session(mockSession));

        Map<String, Object> map = resultActions.andReturn().getModelAndView().getModel();
        BoardUpdateRespDto boardDto = (BoardUpdateRespDto) map.get("boardDetail");

        // String boardmodel = om.writeValueAsString(boardDto);
        // System.out.println("테스트 : " + model);

        // then
        resultActions.andExpect(status().isOk());
        assertThat(boardDto.getCareerString()).isEqualTo("3년이상 ~ 5년미만");
    }

    @Test
    public void save_test() throws Exception {
        // given
        String requestBody = "title=테스트제목&content=테스트내용&careerString=1년이상 ~ 3년미만&educationString=4년 대졸이상&jobTypeString=정규직&favor=관련프로젝트 경험&userId=6";

        // when
        ResultActions resultActions = mvc.perform(
                post("/board/save")
                        .content(requestBody)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                        .session(mockSession));

        // then
        resultActions.andExpect(status().is3xxRedirection());
    }

    @Test
    public void saveForm_test() throws Exception {
        // given

        // when
        ResultActions resultActions = mvc.perform(
                get("/board/saveForm")
                        .session(mockSession));

        HttpSession session = resultActions.andReturn().getRequest().getSession();
        User coPrincipal = (User) session.getAttribute("coPrincipal");

        // then
        assertThat(coPrincipal.getEmail()).isEqualTo("cos@nate.com");
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void certification_test() throws Exception {
        // given
        User employeeUser = new User();
        employeeUser.setId(1);
        employeeUser.setUsername("ssar");
        employeeUser.setPassword("1234");
        employeeUser.setEmail("ssar@nate.com");
        employeeUser.setAddress("부산시 야호구 야동");
        employeeUser.setDetailAddress("11길");
        employeeUser.setTel("01023452344");
        employeeUser.setRole("employee");

        employeeUser.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));

        mockSession2 = new MockHttpSession();
        mockSession2.setAttribute("coPrincipal", employeeUser);

        // when
        ResultActions resultActions = mvc.perform(
                get("/board/saveForm")
                        .session(mockSession));
        // .session(mockSession2)); 일반회원 로그인 시 인증체크 테스트 완료

        HttpSession session = resultActions.andReturn().getRequest().getSession();
        User coPrincipal = (User) session.getAttribute("coPrincipal");

        // then
        resultActions.andExpect(status().isOk());
    }

    @Test
    public void boardDetail_test() throws Exception {
        // given
        int id = 1;

        // when
        ResultActions resultActions = mvc.perform(
                get("/board/" + id));

        Map<String, Object> map = resultActions.andReturn().getModelAndView().getModel();
        BoardDetailRespDto board = (BoardDetailRespDto) map.get("board");

        // String model = om.writeValueAsString(board);
        // System.out.println("테스트 : " + model);

        // then
        resultActions.andExpect(status().isOk());
        assertThat(board.getCompanyScale()).isEqualTo("대기업");
        assertThat(board.getCompanyField()).isEqualTo("IT업");
    }

    @Test
    public void boardList_test() throws Exception {
        // given

        // when
        ResultActions resultActions = mvc.perform(
                get("/board/list"));

        Map<String, Object> map = resultActions.andReturn().getModelAndView().getModel();
        List<BoardListRespDto> boardList = (List<BoardListRespDto>) map.get("boardList");

        // String model = om.writeValueAsString(boardList);
        // System.out.println("테스트 : " + model);

        // then
        resultActions.andExpect(status().isOk());
        assertThat(boardList.get(0).getTitle()).isEqualTo("공고제목1");
        assertThat(boardList.get(1).getTitle()).isEqualTo("공고제목2");
    }

    @Test
    public void boardMainList_test() throws Exception {
        // given

        // when
        ResultActions resultActions = mvc.perform(
                get("/"));

        Map<String, Object> map = resultActions.andReturn().getModelAndView().getModel();
        List<BoardMainRespDto> boardList = (List<BoardMainRespDto>) map.get("boardMainList");

        // String model = om.writeValueAsString(boardList);
        // System.out.println("테스트 : " + model);

        // then
        resultActions.andExpect(status().isOk());
        assertThat(boardList.get(0).getTitle()).isEqualTo("공고제목1");
        assertThat(boardList.get(1).getTitle()).isEqualTo("공고제목2");
    }
}
