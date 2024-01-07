package com.mruruc.model.login;

import java.time.LocalDateTime;

public class UserLogin {
    private Long loginId;
    private String userName;
    private String password;
    private LocalDateTime lastLogin;
    private Integer failedLoginAttempts;
    private Boolean accountLocked;
    private String passwordResetToken;
    private LocalDateTime tokenExpiration;
    private Long clientID;

    public UserLogin(String userName,String password,Long clientID){
        this.userName=userName;
        this.password=password;
        this.lastLogin=LocalDateTime.now();
        this.accountLocked=false;
        this.clientID=clientID;
    }

    public UserLogin(Long loginId, String userName,
                     String password, LocalDateTime lastLogin,
                     Integer failedLoginAttempts, Boolean accountLocked,
                     String passwordResetToken,
                     LocalDateTime tokenExpiration,
                     Long clientID) {
        this.loginId = loginId;
        this.userName = userName;
        this.password = password;
        this.lastLogin = lastLogin;
        this.failedLoginAttempts = failedLoginAttempts;
        this.accountLocked = accountLocked;
        this.passwordResetToken = passwordResetToken;
        this.tokenExpiration = tokenExpiration;
        this.clientID = clientID;
    }

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public Boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public LocalDateTime getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(LocalDateTime tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "loginId=" + loginId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastLogin=" + lastLogin +
                ", failedLoginAttempts=" + failedLoginAttempts +
                ", accountLocked=" + accountLocked +
                ", passwordResetToken='" + passwordResetToken + '\'' +
                ", tokenExpiration=" + tokenExpiration +
                ", clientID=" + clientID +
                '}';
    }



}
