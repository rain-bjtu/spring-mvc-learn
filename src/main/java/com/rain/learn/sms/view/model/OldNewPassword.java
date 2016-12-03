package com.rain.learn.sms.view.model;

import org.hibernate.validator.constraints.Length;

public class OldNewPassword {

    @Length(min = 1, max = 20, message = "{password.length.limitation}")
    private String oldPassword;

    @Length(min = 1, max = 20, message = "{password.length.limitation}")
    private String newPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public String toString() {
        return "OldNewPassword [oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
    }
}
