package com.xhpp.foodpenguin.ui;

public class Users {
    private String username;
    private String password;
    private String phone;

    public Users(String username, String password, String phone)
    {
        this.username = username;
        this.password = password;
        this.phone = phone ;
    }

    public Users()
    {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}
