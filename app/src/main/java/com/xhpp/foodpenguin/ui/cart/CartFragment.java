package com.xhpp.foodpenguin.ui.cart;

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

public class CartFragment extends Fragment {

    private CartViewModel cartViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container,@NonNull Bundle savedInstanceState)
    {
        cartViewModel = ViewModelProviders.of(this).get(CartViewModel.class);
        View view = inflater.inflate(R.layout.fragment_cart, container, false);


        return view;
    }
}