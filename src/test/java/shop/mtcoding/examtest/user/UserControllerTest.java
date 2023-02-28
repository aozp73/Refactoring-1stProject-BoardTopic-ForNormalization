package shop.mtcoding.examtest.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import shop.mtcoding.examtest.user.model.User;
import shop.mtcoding.examtest.user.vo.UserVo;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class UserControllerTest {

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
    public void login_test() throws Exception {
        // given
        String requestBody = "username=ssar&password=1234";
        // when
        ResultActions resultActions = mvc.perform(post("/login").content(requestBody)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE));
        HttpSession session = resultActions.andReturn().getRequest().getSession();
        User usPrincipal = (User) session.getAttribute("principal");

        // then
        assertThat(usPrincipal.getUsername()).isEqualTo("ssar");
        resultActions.andExpect(status().is3xxRedirection());
    }


}
