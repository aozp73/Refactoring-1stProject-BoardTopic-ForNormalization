package shop.mtcoding.examtest.resume.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Resume {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
}
