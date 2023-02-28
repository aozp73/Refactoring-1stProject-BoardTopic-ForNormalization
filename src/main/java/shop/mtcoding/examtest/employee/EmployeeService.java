package shop.mtcoding.examtest.employee;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.examtest.common.ex.CustomException;
import shop.mtcoding.examtest.common.util.PathUtil;
import shop.mtcoding.examtest.employee.dto.EmployeeReq.EmployeeJoinReqDto;
import shop.mtcoding.examtest.employee.dto.EmployeeReq.EmployeeUpdateReqDto;
import shop.mtcoding.examtest.employee.dto.EmployeeResp.EmployeeUpdateRespDto;
import shop.mtcoding.examtest.employee.model.Employee;
import shop.mtcoding.examtest.employee.model.EmployeeRepository;
import shop.mtcoding.examtest.user.model.User;
import shop.mtcoding.examtest.user.model.UserRepository;
import shop.mtcoding.examtest.user.vo.UserVo;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public EmployeeUpdateRespDto getEmployeeUpdateRespDto(Integer principalId) {
        User user = userRepository.findById(principalId);
        Employee employee = employeeRepository.findByUserId(principalId);
        EmployeeUpdateRespDto employeeUpdateRespDto = new EmployeeUpdateRespDto(user.getPassword(), user.getEmail(),
                user.getAddress(), user.getDetailAddress(), user.getTel(),
                employee.getCareer(), employee.getEducation());
        return employeeUpdateRespDto;
    }

    @Transactional
    public void insertEmployee(EmployeeJoinReqDto employeeJoinReqDto) {
        if (userRepository.findByUsername(employeeJoinReqDto.getUsername()) != null) {
            throw new CustomException("이미 존재하는 유저네임 입니다.");
        }
        User user = new User(employeeJoinReqDto.getUsername(), employeeJoinReqDto.getPassword(),
                employeeJoinReqDto.getEmail());
        try {
            userRepository.insertForEmployee(user);
            employeeRepository.insert(user.getId());
        } catch (Exception e) {
            throw new CustomException("서버 오류: 회원 가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public UserVo updateEmpolyee(EmployeeUpdateReqDto employeeUpdateReqDto, Integer principalId, MultipartFile profile) {
        String uuidImageName = PathUtil.writeImageFile(profile);

        User user = new User(principalId, employeeUpdateReqDto.getPassword(), employeeUpdateReqDto.getEmail(),
                employeeUpdateReqDto.getAddress(), employeeUpdateReqDto.getDetailAddress(),
                employeeUpdateReqDto.getTel(),
                uuidImageName);
        Employee employee = new Employee(principalId, employeeUpdateReqDto.getCareer(), employeeUpdateReqDto.getEducation());
        try {
            userRepository.updateById(user);
            employeeRepository.updateByUserId(employee);
        } catch (Exception e) {
            throw new CustomException("회원 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        user = userRepository.findById(principalId);
        UserVo userVoPS = new UserVo(user.getId(), user.getUsername(), user.getProfile(), user.getRole());
        return userVoPS;
    }
}
