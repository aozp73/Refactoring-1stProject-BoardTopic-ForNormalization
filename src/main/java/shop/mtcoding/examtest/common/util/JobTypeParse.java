package shop.mtcoding.examtest.common.util;

public class JobTypeParse {

    public static int jobTypeToInt(String jobType) {
        int parseJobType = -99;

        switch (jobType) {
            case "인턴":
                parseJobType = 1;
                break;
            case "정규직":
                parseJobType = 2;
                break;
        }

        return parseJobType;
    }

    public static String jopTypeToString(int jopType) {
        String parseJobType = "";

        switch (jopType) {
            case 1:
                parseJobType = "인턴";
                break;
            case 2:
                parseJobType = "정규직";
                break;
        }

        return parseJobType;
    }
}
