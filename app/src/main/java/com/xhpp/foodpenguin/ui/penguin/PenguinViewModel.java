package com.xhpp.foodpenguin.ui.penguin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PenguinViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PenguinViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Main");
    }

    public LiveData<String> getText() {
        return mText;
    }
}