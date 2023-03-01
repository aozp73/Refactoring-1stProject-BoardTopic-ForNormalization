package shop.mtcoding.examtest.common.util;

public class EducationParse {

    public static int educationToInt(String education) {
        int parseEducation = -99;

        switch (education) {
            case "고졸이상":
                parseEducation = 1;
                break;
            case "2~3년 대졸이상":
                parseEducation = 2;
                break;
            case "4년 대졸이상":
                parseEducation = 4;
                break;
            case "학력무관":
                parseEducation = 0;
                break;
        }

        return parseEducation;
    }

    public static String educationToString(int education) {
        String parseEducation = "";

        switch (education) {
            case 1:
                parseEducation = "고졸이상";
                break;
            case 2:
                parseEducation = "2~3년 대졸이상";
                break;
            case 4:
                parseEducation = "4년 대졸이상";
                break;
            case 0:
                parseEducation = "학력무관";
                break;
        }

        return parseEducation;
    }
}
