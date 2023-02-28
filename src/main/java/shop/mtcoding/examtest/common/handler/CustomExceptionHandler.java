package shop.mtcoding.examtest.common.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import shop.mtcoding.examtest.common.dto.ResponseDto;
import shop.mtcoding.examtest.common.ex.CustomApiException;
import shop.mtcoding.examtest.common.ex.CustomException;
import shop.mtcoding.examtest.common.util.Script;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> customException(CustomException e) {
        if (e.getLocation() == null) {
            return new ResponseEntity<>(Script.back(e.getMessage()), e.getStatus());
        }
        return new ResponseEntity<>(Script.herf(e.getMessage(), e.getLocation()), e.getStatus());
    }
    
    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> customApiException(CustomApiException e) {
        return new ResponseEntity<>(new ResponseDto<>(-1, e.getMessage(), null), e.getStatus());
    }
}
