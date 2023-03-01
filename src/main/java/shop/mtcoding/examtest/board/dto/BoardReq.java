package shop.mtcoding.examtest.board.dto;

import lombok.Getter;
import lombok.Setter;

public class BoardReq {

    @Getter
    @Setter
    public static class BoardUpdateReqDto {
        private Integer id;
        private String title;
        private String content;

        private Integer career;
        private String careerString;
        private Integer education;
        private String educationString;
        private Integer jobType;
        private String jobTypeString;

        private String favor;
        private Integer userId;
    }

    @Getter
    @Setter
    public static class BoardInsertReqDto {
        private String title;
        private String content;

        private Integer career;
        private String careerString;
        private Integer education;
        private String educationString;
        private Integer jobType;
        private String jobTypeString;

        private String favor;
        private Integer userId;
    }
}
