package shop.mtcoding.examtest.board.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Board {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private Integer career;
    private Integer jobType;
    private Integer education;
    private String favor;
    private Timestamp createdAt;

    public Board(Integer id, Integer userId, String title, String content, Integer career, Integer jobType,
            Integer education, String favor) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.career = career;
        this.jobType = jobType;
        this.education = education;
        this.favor = favor;
    }

    public Board(Integer userId, String title, String content, Integer career, Integer jobType, Integer education,
            String favor) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.career = career;
        this.jobType = jobType;
        this.education = education;
        this.favor = favor;
    }

}
