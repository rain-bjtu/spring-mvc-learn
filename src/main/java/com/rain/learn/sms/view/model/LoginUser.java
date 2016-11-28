package com.rain.learn.sms.view.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class LoginUser {

    @NotEmpty(message = "{username.not.empty}")
    @Length(min = 1, max = 100, message = "{username.length.limitation}")
    private String username;

    @NotEmpty(message = "{password.not.empty}")
    @Length(min = 1, max = 20, message = "{password.length.limitation}")
    private String password;

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

}
