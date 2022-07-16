package com.cite.newscoopup;

public class User {
    public String fullName, userName, number;

    public User() {

    }

    public User(String fullName, String userName, String number) {
        this.fullName = fullName;
        this.userName = userName;
        this.number = number;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}