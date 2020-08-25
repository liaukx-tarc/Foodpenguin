package com.xhpp.foodpenguin.ui.main;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.xhpp.foodpenguin.MainActivity;
import com.xhpp.foodpenguin.R;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MainViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Main");
    }


    public LiveData<String> getText() {
        return mText;
    }
}