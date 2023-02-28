package shop.mtcoding.examtest.employee;

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
import shop.mtcoding.examtest.employee.dto.EmployeeReq.EmployeeJoinReqDto;
import shop.mtcoding.examtest.employee.dto.EmployeeReq.EmployeeUpdateReqDto;
import shop.mtcoding.examtest.employee.dto.EmployeeResp.EmployeeUpdateRespDto;
import shop.mtcoding.examtest.user.vo.UserVo;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final HttpSession session;

    @GetMapping("/employee/joinForm")
    public String joinForm() {
        return "employee/joinForm";
    }

    @GetMapping("/employee/updateForm")
    public String updateForm(Model model) {
        UserVo principal = (UserVo) session.getAttribute("principal");
        Verify.validateObject(principal, "로그인이 필요합니다.");
        if (!principal.getRole().equals("employee")) {
            throw new CustomException("권한이 없습니다.", HttpStatus.FORBIDDEN);
        }
        EmployeeUpdateRespDto employeeUpdateRespDto = employeeService.getEmployeeUpdateRespDto(principal.getId());
        model.addAttribute("employeeDto", employeeUpdateRespDto);
        return "user/updateForm";
    }

    @PostMapping("/employee/join")
    public String join(EmployeeJoinReqDto employeeJoinReqDto) {
        Verify.validateStiring(employeeJoinReqDto.getUsername(), "유저네임을 입력하세요.");
        Verify.validateStiring(employeeJoinReqDto.getPassword(), "암호를 입력하세요.");
        Verify.validateStiring(employeeJoinReqDto.getEmail(), "이메일을 입력하세요.");
        employeeService.insertEmployee(employeeJoinReqDto);
        return "redirect:/loginForm";
    }

    @PostMapping("/employee/update")
    public String update(EmployeeUpdateReqDto employeeUpdateReqDto, MultipartFile profile) {
        UserVo principal = (UserVo) session.getAttribute("principal");
        Verify.validateObject(principal, "로그인이 필요합니다.", HttpStatus.UNAUTHORIZED, "/company/loginForm");
        if (!principal.getRole().equals("employee")) {
            throw new CustomException("권한이 없습니다.", HttpStatus.FORBIDDEN);
        }
        Verify.validateStiring(employeeUpdateReqDto.getPassword(), "암호를 입력하세요.");
        Verify.validateStiring(employeeUpdateReqDto.getEmail(), "이메일을 입력하세요.");
        Verify.validateStiring(employeeUpdateReqDto.getAddress(), "주소를 입력하세요.");
        Verify.validateStiring(employeeUpdateReqDto.getDetailAddress(), "상세 주소를 입력하세요.");
        Verify.validateStiring(employeeUpdateReqDto.getTel(), "전화번호를 입력하세요.");
        Verify.validateObject(employeeUpdateReqDto.getCareer(), "경력을 입력하세요.");
        Verify.validateStiring(employeeUpdateReqDto.getEducation(), "학력을 입력하세요.");

        UserVo UserVoPS = employeeService.updateEmpolyee(employeeUpdateReqDto, principal.getId(), profile);
        session.removeAttribute("principal");
        session.setAttribute("principal", UserVoPS);
        return "redirect:/";
    }
}
