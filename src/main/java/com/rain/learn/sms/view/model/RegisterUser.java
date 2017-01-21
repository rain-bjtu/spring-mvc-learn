package com.rain.learn.sms.view.model;

import javax.validation.constraints.AssertTrue;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class RegisterUser {

    @NotEmpty(message = "{username.not.empty}")
    @Length(min = 1, max = 100, message = "{username.length.limitation}")
    private String username;

    @NotEmpty(message = "{email.not.empty}")
    @Email(message = "email.not.valid")
    private String email;

    @NotEmpty(message = "{password.not.empty}")
    @Length(min = 1, max = 20, message = "{password.length.limitation}")
    private String password;

    @NotEmpty(message = "{verification.not.empty}")
    @Length(min = 5, max = 5, message = "{verification.must.correct}")
    private String verification;

    @AssertTrue(message = "agree.my.policy")
    private boolean agree;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerification() {
        return verification;
    }

    public void setVerification(String verification) {
        this.verification = verification;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    @Override
    public String toString() {
        return "RegisterUser [username=" + username + ", email=" + email + ", verification=" + verification
                + ", agree=" + agree + "]";
    }

}
