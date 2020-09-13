package com.xhpp.foodpenguin.ui.main;

public class Restaurant {
    int Image;
    String Name;
    String Desc;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public Restaurant(int img, String name , String des)
    {
        this.Image = img;
        this.Name=name;
        this.Desc=des;
    }
}
