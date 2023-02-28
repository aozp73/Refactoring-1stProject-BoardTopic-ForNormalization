package shop.mtcoding.examtest.apply.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Apply {
    private Integer id;
    private Integer userId;
    private Integer boardId;
    private Timestamp createdAt;
}
