package shop.mtcoding.examtest.user.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String address;
    private String detailAddress;
    private String tel;
    private String profile;
    private String role;
    private Timestamp createdAt;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(String username, String password, String email, String address, String detailAddress) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.address = address;
        this.detailAddress = detailAddress;
    }
    
    public User(Integer id,String password, String email, String address, String detailAddress, String tel, String profile) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.address = address;
        this.detailAddress = detailAddress;
        this.tel = tel;
        this.profile = profile;
    }
}
