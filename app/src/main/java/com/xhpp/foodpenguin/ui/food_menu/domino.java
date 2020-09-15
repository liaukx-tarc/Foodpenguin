package com.xhpp.foodpenguin.ui.food_menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xhpp.foodpenguin.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link domino#newInstance} factory method to
 * create an instance of this fragment.
 */
public class domino extends Fragment {


    public domino() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_domino, container, false);
    }
}