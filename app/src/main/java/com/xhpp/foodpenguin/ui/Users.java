package com.xhpp.foodpenguin.ui;

public class Users {
    private String username;
    private String password;
    private String phone;
    private String email;
    private String address;
    private String fname;
    private double walletAmount;

    public Users(String username, String password, String phone, String email)
    {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setWalletAmount(double walletAmount)  {
        this.walletAmount = walletAmount;
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

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public double getwalletAmount() { return walletAmount; }

}
