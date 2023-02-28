package shop.mtcoding.examtest.user.dto;

import lombok.Getter;
import lombok.Setter;

public class UserReq {

      @Getter
      @Setter
      public static class UserLoginReqDto {
            private String username;
            private String password;
      }
}
