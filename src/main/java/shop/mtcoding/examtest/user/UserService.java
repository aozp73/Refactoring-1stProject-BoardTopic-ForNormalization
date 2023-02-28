package shop.mtcoding.examtest.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import shop.mtcoding.examtest.common.util.Verify;
import shop.mtcoding.examtest.user.dto.UserReq.UserLoginReqDto;
import shop.mtcoding.examtest.user.model.User;
import shop.mtcoding.examtest.user.model.UserRepository;
import shop.mtcoding.examtest.user.vo.UserVo;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    @Transactional(readOnly = true)
    public UserVo getUser(UserLoginReqDto userLoginReqDto) {
        UserVo userVoPS = userRepository.findByUsernameAndPassword(
                new User(userLoginReqDto.getUsername(), userLoginReqDto.getPassword()));
        Verify.validateObject(userVoPS, "유저네임이나 암호를 확인해주세요.");
        return userVoPS;
    }

    @Transactional(readOnly = true)
    public User checkUsername(String username) {
        User userPS = userRepository.findByUsername(username);
        return userPS;
    }
}
