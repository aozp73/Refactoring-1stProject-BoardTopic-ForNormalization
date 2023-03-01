package shop.mtcoding.examtest.board.dto;

import lombok.Getter;
import lombok.Setter;

public class BoardResp {
    @Getter
    @Setter
    public static class BoardListRespDto {
        private Integer id;
        private String title;
        private String companyName;
        private Integer userId;
        private String profile;
    }

    @Getter
    @Setter
    public static class MyBoardListRespDto {
        private Integer id;
        private String title;
        private String companyName;
        private Integer userId;
        private String profile;
    }

    @Getter
    @Setter
    public static class BoardMainRespDto {
        private Integer id;
        private String title;
        private String companyName;
        private Integer userId;
        private String profile;
    }

    @Getter
    @Setter
    public static class BoardUpdateRespDto {
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
    public static class BoardDetailRespDto {
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
        private String companyName;
        private String companyScale;
        private String companyField;
        private String profile;
    }

}
