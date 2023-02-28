package shop.mtcoding.examtest.company;

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

import shop.mtcoding.examtest.user.vo.UserVo;

@Transactional
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class CompanyControllerTest {
    
    @Autowired
    private MockMvc mvc;

    private MockHttpSession mockSession;

    @BeforeEach
    public void setUp() {
        UserVo pricipal = new UserVo();
        pricipal.setId(1);
        pricipal.setUsername("ssar");
        pricipal.setRole("company");
        pricipal.setProfile(null);
        mockSession = new MockHttpSession();
        mockSession.setAttribute("principal", pricipal);
    }

    @Test
    public void join_test() throws Exception {
        // given
        String usernameVal = "alss";
        String passwordVal = "1234";
        String emailVal = "love@naver.com";
        String companyNumbVal = "1234123333";
        String companyNameVal = "(주)야호";
        String addressVal = "부산광역시 야구 김동";
        String detailAddressVal = "석진2길";
        StringBuffer sb = new StringBuffer();
        sb.append("username=");
        sb.append(usernameVal);
        sb.append("&password=");
        sb.append(passwordVal);
        sb.append("&email=");
        sb.append(emailVal);
        sb.append("&companyNumb=");
        sb.append(companyNumbVal);
        sb.append("&companyName=");
        sb.append(companyNameVal);
        sb.append("&address=");
        sb.append(addressVal);
        sb.append("&detailAddress=");
        sb.append(detailAddressVal);
        String requestBody = sb.toString();

        // when
        ResultActions resultActions = mvc.perform(post("/company/join").content(requestBody)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE));

        // then
        resultActions.andExpect(status().is3xxRedirection());
    }

    @Test
    public void update_test() throws Exception {
        // given
        String passwordVal = "1234";
        String emailVal = "love@naver.com";
        String companyNameVal = "(주)야호";
        String addressVal = "부산광역시 야구 김동";
        String detailAddressVal = "석진2길";
        String companyScaleVal = "대기업";
        String companyFieldVal = "SW 개발";
        String telVal = "01020340234";
        StringBuffer sb = new StringBuffer();
        sb.append("password=");
        sb.append(passwordVal);
        sb.append("&email=");
        sb.append(emailVal);
        sb.append("&companyName=");
        sb.append(companyNameVal);
        sb.append("&address=");
        sb.append(addressVal);
        sb.append("&detailAddress=");
        sb.append(detailAddressVal);
        sb.append("&companyScale=");
        sb.append(companyScaleVal);
        sb.append("&companyField=");
        sb.append(companyFieldVal);
        sb.append("&tel=");
        sb.append(telVal);
        String requestBody = sb.toString();

        // when
        ResultActions resultActions = mvc.perform(post("/company/update")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .session(mockSession));
        HttpSession session = resultActions.andReturn().getRequest().getSession();
        UserVo principal = (UserVo) session.getAttribute("principal");

        // verify
        resultActions.andExpect(status().is3xxRedirection());
    }
}
