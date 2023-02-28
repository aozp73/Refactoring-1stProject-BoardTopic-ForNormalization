package shop.mtcoding.examtest.user.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    private Integer id;
    private String username;
    private String profile;
    private String role;
}
