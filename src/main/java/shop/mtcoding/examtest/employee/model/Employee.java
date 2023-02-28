package shop.mtcoding.examtest.employee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Employee {
    private Integer userId;
    private String realName;
    private Integer career;
    private String education;

    public Employee(Integer userId, Integer career, String education) {
        this.userId = userId;
        this.career = career;
        this.education = education;
    }
}
