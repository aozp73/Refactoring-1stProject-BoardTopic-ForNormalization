package shop.mtcoding.examtest.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class EmployeeResp {
    
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EmployeeUpdateRespDto {
        private String password;
        private String email;
        private String address;
        private String detailAddress;
        private String tel;
        private Integer career;
        private String education;
    }
}
