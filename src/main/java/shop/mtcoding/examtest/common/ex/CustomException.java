package shop.mtcoding.examtest.common.ex;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
    private HttpStatus status;
    private String location;

    public CustomException(String msg, HttpStatus status, String location) {
        super(msg);
        this.status = status;
        this.location = location;
    }

    public CustomException(String msg) {
        this(msg, HttpStatus.BAD_REQUEST);
    }

    public CustomException(String msg, HttpStatus status) {
        this(msg, status, null);
    }
}
