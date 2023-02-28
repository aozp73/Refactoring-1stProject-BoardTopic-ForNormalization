package shop.mtcoding.examtest.company.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * create table company_tb(
    user_id int not null unique,
    company_name varchar not null,
    company_scale varchar,
    company_numb bigint not null,
    company_field varchar
);
 */

@Getter
@Setter
@NoArgsConstructor
public class Company {
    private Integer userId;
    private String companyName;
    private String companyScale;
    private Long companyNumb;
    private String companyField;

    public Company(Integer userId, String companyName, Long companyNumb){
        this.userId = userId;
        this.companyName = companyName;
        this.companyNumb = companyNumb;
    }

    public Company(Integer userId, String companyName, String companyScale, String companyField) {
        this.userId = userId;
        this.companyName = companyName;
        this.companyScale = companyScale;
        this.companyField = companyField;
    }
}
