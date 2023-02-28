package shop.mtcoding.examtest.company;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.examtest.common.ex.CustomException;
import shop.mtcoding.examtest.common.util.Verify;
import shop.mtcoding.examtest.company.dto.CompanyReq.CompanyJoinReqDto;
import shop.mtcoding.examtest.company.dto.CompanyReq.CompanyUpdateReqDto;
import shop.mtcoding.examtest.company.dto.CompanyResp.CompanyUpdateRespDto;
import shop.mtcoding.examtest.user.vo.UserVo;

@Controller
@RequiredArgsConstructor
public class CompanyConetroller {
    private final CompanyService companyService;
    private final HttpSession session;

    @GetMapping("/company/joinForm")
    public String joinForm() {
        return "company/joinForm";
    }

    @GetMapping("/company/updateForm")
    public String updateForm(Model model) {
        UserVo principal = (UserVo) session.getAttribute("principal");
        Verify.validateObject(principal, "로그인이 필요합니다.", HttpStatus.UNAUTHORIZED, "/loginForm");
        if (!principal.getRole().equals("company")) {
            throw new CustomException("권한이 없습니다.", HttpStatus.FORBIDDEN);
        }
        CompanyUpdateRespDto companyUpdateRespDto = companyService.getCompanyUpdateRespDto(principal.getId());
        model.addAttribute("companyDto", companyUpdateRespDto);
        return "company/updateForm";
    }

    @PostMapping("/company/join")
    public String join(CompanyJoinReqDto companyJoinReqDto) {
        Verify.validateStiring(companyJoinReqDto.getUsername(), "유저네임을 입력하세요.");
        Verify.validateStiring(companyJoinReqDto.getPassword(), "암호를 입력하세요.");
        Verify.validateStiring(companyJoinReqDto.getEmail(), "이메일을 입력하세요.");
        companyService.insertCompany(companyJoinReqDto);
        return "redirect:/loginForm";
    }

    @PostMapping("/company/update")
    public String update(CompanyUpdateReqDto companyUpdateReqDto, MultipartFile profile) {
        UserVo principal = (UserVo) session.getAttribute("principal");
        Verify.validateObject(principal, "로그인이 필요합니다.", HttpStatus.UNAUTHORIZED, "/company/loginForm");
        if (!principal.getRole().equals("company")) {
            throw new CustomException("권한이 없습니다.", HttpStatus.FORBIDDEN);
        }
        Verify.validateStiring(companyUpdateReqDto.getPassword(), "암호를 입력하세요.");
        Verify.validateStiring(companyUpdateReqDto.getEmail(), "이메일을 입력하세요.");
        Verify.validateStiring(companyUpdateReqDto.getCompanyName(), "회사 이름을 입력하세요.");
        Verify.validateStiring(companyUpdateReqDto.getAddress(), "주소를 입력하세요.");
        Verify.validateStiring(companyUpdateReqDto.getDetailAddress(), "상세 주소를 입력하세요.");
        Verify.validateStiring(companyUpdateReqDto.getCompanyScale(), "회사 규모란을 선택하세요.");
        Verify.validateStiring(companyUpdateReqDto.getCompanyField(), "회사 업종란을 선택하세요.");
        Verify.validateStiring(companyUpdateReqDto.getTel(), "전화번호를 입력하세요.");
        UserVo UserVoPS = companyService.updateCompany(companyUpdateReqDto, principal.getId(), profile);
        session.removeAttribute("principal");
        session.setAttribute("principal", UserVoPS);
        return "redirect:/";
    }
}
