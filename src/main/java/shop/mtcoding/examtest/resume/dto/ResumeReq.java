package shop.mtcoding.examtest.resume.dto;

import lombok.Getter;
import lombok.Setter;

public class ResumeReq {
    
    @Getter
    @Setter
    public static class ResumeSaveReq {
        private String title;
        private String content;
    }
}
