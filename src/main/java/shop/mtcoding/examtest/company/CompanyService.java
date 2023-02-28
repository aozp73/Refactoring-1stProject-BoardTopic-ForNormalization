package shop.mtcoding.examtest.company;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.examtest.common.ex.CustomException;
import shop.mtcoding.examtest.common.util.PathUtil;
import shop.mtcoding.examtest.company.dto.CompanyReq.CompanyJoinReqDto;
import shop.mtcoding.examtest.company.dto.CompanyReq.CompanyUpdateReqDto;
import shop.mtcoding.examtest.company.dto.CompanyResp.CompanyUpdateRespDto;
import shop.mtcoding.examtest.company.model.Company;
import shop.mtcoding.examtest.company.model.CompanyRepository;
import shop.mtcoding.examtest.user.model.User;
import shop.mtcoding.examtest.user.model.UserRepository;
import shop.mtcoding.examtest.user.vo.UserVo;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public CompanyUpdateRespDto getCompanyUpdateRespDto(Integer principalId) {
        User user = userRepository.findById(principalId);
        Company company = companyRepository.findByUserId(principalId);
        CompanyUpdateRespDto companyUpdateRespDto = new CompanyUpdateRespDto(user.getPassword(), user.getEmail(),
                user.getAddress(),
                user.getDetailAddress(), user.getTel(), company.getCompanyName(), company.getCompanyScale(),
                company.getCompanyField());
        return companyUpdateRespDto;
    }

    @Transactional
    public void insertCompany(CompanyJoinReqDto companyJoinReqDto) {
        if (userRepository.findByUsername(companyJoinReqDto.getUsername()) != null) {
            throw new CustomException("이미 존재하는 유저네임 입니다.");
        }
        User user = new User(companyJoinReqDto.getUsername(), companyJoinReqDto.getPassword(),
                companyJoinReqDto.getEmail(), companyJoinReqDto.getAddress(), companyJoinReqDto.getDetailAddress());
        try {
            userRepository.insertForCompany(user);
            Company company = new Company(user.getId(), companyJoinReqDto.getCompanyName(),
                    companyJoinReqDto.getCompanyNumb());
            companyRepository.insert(company);
        } catch (Exception e) {
            throw new CustomException("서버 오류: 회원 가입 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public UserVo updateCompany(CompanyUpdateReqDto companyUpdateReqDto, Integer principalId, MultipartFile profile) {
        String uuidImageName = PathUtil.writeImageFile(profile);

        User user = new User(principalId, companyUpdateReqDto.getPassword(), companyUpdateReqDto.getEmail(),
                companyUpdateReqDto.getAddress(), companyUpdateReqDto.getDetailAddress(), companyUpdateReqDto.getTel(),
                uuidImageName);
        Company company = new Company(principalId, companyUpdateReqDto.getCompanyName(),
                companyUpdateReqDto.getCompanyScale(),
                companyUpdateReqDto.getCompanyField());

        try {
            userRepository.updateById(user);
            companyRepository.updateByUserId(company);
        } catch (Exception e) {
            throw new CustomException("회원 수정 실패", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        user = userRepository.findById(principalId);
        UserVo userVoPS = new UserVo(user.getId(), user.getUsername(), user.getProfile(), user.getRole());
        return userVoPS;
    }
}
