package shop.mtcoding.examtest.board.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
    private Integer id;
    private Integer userId;
    private String title;
    private String content;
    private String career;
    private String jobType;
    private String education;
    private String favor;
    private Timestamp createdAt;
}
