package com.rain.learn.sms.type;

public enum UserRole {

    USER("Users"), ADMINISTRATOR("Administrators");

    private String text;

    private UserRole(String role) {
        this.text = role;
    }

    public String getText() {
        return text;
    }
}
