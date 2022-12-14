package com.project.domain.member.join;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

public class JoinFormData {
    @NotBlank
    String username;
    @NotBlank
    String password;
    @NotBlank
    String passwordCheck;
    @NotBlank
    String nickName;
    @NotBlank
    @Email(message = "잘못된 이메일 형식입니다.")
    String email;
    @Length(min=0, max=150)
    String introduction;

    public JoinFormData(String username, String password, String passwordCheck, String nickName, String email, String introduction) {
        this.username = username;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.nickName = nickName;
        this.email = email;
        this.introduction = introduction;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


    @Override
    public String toString() {
        return "JoinFormData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordCheck='" + passwordCheck + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
