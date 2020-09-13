package com.xhpp.foodpenguin.ui.promotion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.xhpp.foodpenguin.R;

public class PromotionFragment extends Fragment {

    private PromotionViewModel promotionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        promotionViewModel = ViewModelProviders.of(this).get(PromotionViewModel.class);
        View view = inflater.inflate(R.layout.fragment_promotion, container, false);

        return view;
    }
}