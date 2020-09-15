package com.xhpp.foodpenguin.ui.main;

import android.os.Parcel;
import android.os.Parcelable;

public class Restaurant {

    private int mImageResource;
    private String mText1;
    private String mText2;

    public Restaurant(int imageResource, String text1, String text2) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    };

    public int getImageResource() {
        return mImageResource;
    }
    public String getText1() {
        return mText1;
    }
    public String getText2() {
        return mText2;
    }
}


//    int Image;
//    String Name;
//    String Desc;
//
//    public String getName() { return Name; }
//
//    public void setName(String name) { Name = name; }
//
//    public String getDesc() {
//        return Desc;
//    }
//
//    public void setDesc(String desc) { Desc = desc; }
//
//    public int getImage() {
//        return Image;
//    }
//
//    public void setImage(int image) { Image = image; }
//
//    public Restaurant(int img, String name , String des)
//    {
//        this.Image = img;
//        this.Name=name;
//        this.Desc=des;
//    }
//
//    protected Restaurant(Parcel in) {
//        Image = in.readInt();
//        Name = in.readString();
//        Desc = in.readString();
//    }
//
//    public static final Creator<Restaurant> CREATOR = new Creator<Restaurant>() {
//        @Override
//        public Restaurant createFromParcel(Parcel in) {
//            return new Restaurant(in);
//        }
//
//        @Override
//        public Restaurant[] newArray(int size) {
//            return new Restaurant[size];
//        }
//    };
//
//
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeInt(Image);
//        parcel.writeString(Name);
//        parcel.writeString(Desc);
//    }

