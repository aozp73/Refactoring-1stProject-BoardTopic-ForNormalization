package shop.mtcoding.examtest.employee;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import shop.mtcoding.examtest.user.vo.UserVo;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mvc;

    private MockHttpSession mockSession;

    @BeforeEach
    public void setUp() {
        UserVo pricipal = new UserVo();
        pricipal.setId(1);
        pricipal.setUsername("ssar");
        pricipal.setRole("employee");
        pricipal.setProfile(null);
        mockSession = new MockHttpSession();
        mockSession.setAttribute("principal", pricipal);
    }

    @Test
    public void join_test() throws Exception {
        // given
        String requestBody = "username=alss&password=1234&email=alss@nate.com";
        // when
        ResultActions resultActions = mvc.perform(post("/employee/join").content(requestBody)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE));

        // then
        resultActions.andExpect(status().is3xxRedirection());
    }

    @Test
    public void update_test() throws Exception {
        // given
        String requestBody = "password=1234&email=ssar@nate.com&address=부산시&detailAddress=12구&tel=01099876554&career=2&education=고졸";
        String requestBody2 = "password=1234&email=&tel=01099876554&career=2"; // email null 테스트

        // when
        ResultActions resultActions = mvc.perform(post("/employee/update").content(requestBody)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).session(mockSession));
        ResultActions resultActions2 = mvc.perform(post("/employee/update").content(requestBody2)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE).session(mockSession));

        // then
        resultActions.andExpect(status().is3xxRedirection());
        resultActions2.andExpect(status().is4xxClientError());

    }
}
