package com.xhpp.foodpenguin.ui.promotion;

public class Promotion {

    int ImageForPromo;
    String TitleForPromo;
    String DescForPromo;

    public int getImageForPromo() {
        return ImageForPromo;
    }

    public void setImageForPromo(int imageForPromo) {
        this.ImageForPromo = imageForPromo;
    }

    public String getTitleForPromo() {
        return TitleForPromo;
    }

    public void setTitleForPromo(String titleForPromo) {
        this.TitleForPromo = titleForPromo;
    }

    public String getDescForPromo() {
        return DescForPromo;
    }

    public void setDescForPromo(String descForPromo) {
        this.DescForPromo = descForPromo;
    }

    public Promotion(int img, String title, String des) {
        this.ImageForPromo = img;
        this.TitleForPromo = title;
        this.DescForPromo = des;
    }
}

