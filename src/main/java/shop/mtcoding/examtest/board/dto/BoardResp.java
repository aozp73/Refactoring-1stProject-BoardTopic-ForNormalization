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
        private Integer companyId;
        private String profile;
    }

    @Getter
    @Setter
    public static class MyBoardListRespDto {
        private Integer id;
        private String title;
        private String companyName;
        private Integer companyId;
        private String profile;
    }

    @Getter
    @Setter
    public static class BoardMainRespDto {
        private Integer id;
        private String title;
        private String companyName;
        private Integer companyId;
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
        private Integer companyId;
    }

    @Getter
    @Setter
    public static class BoardDetailRespDto {
        private Integer id;
        private String title;
        private String content;
        private Integer career;
        private String careerString;
        private Integer companyId;
        private String companyName;
        private String companyScale;
        private String companyField;
        private String profile;
    }

}
