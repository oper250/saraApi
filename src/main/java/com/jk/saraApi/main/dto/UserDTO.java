package com.jk.saraApi.main.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {

    private String userSeq;        // 사용자시퀀스
    private String userId;        // 사용자명
    private String userPwd;        // 비밀번호
    private String nickname;        // 별명
    private String profileUrl;      // 프로필이미지주소
    private String introDesc;       // 자기소개
    private String delYn;           // 삭제여부
    private String role;            // 권한

    public String getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(String userSeq) {
        this.userSeq = userSeq;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getIntroDesc() {
        return introDesc;
    }

    public void setIntroDesc(String introDesc) {
        this.introDesc = introDesc;
    }

    public String getDelYn() {
        return delYn;
    }

    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
