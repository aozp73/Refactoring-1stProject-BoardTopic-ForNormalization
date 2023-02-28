package shop.mtcoding.examtest.company.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CompanyResp {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompanyUpdateRespDto {
        private String password;
        private String email;
        private String address;
        private String detailAddress;
        private String tel;
        private String companyName;
        private String companyScale;
        private String companyField;
    }
    
}
