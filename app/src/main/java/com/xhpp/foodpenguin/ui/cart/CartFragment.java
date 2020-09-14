package com.xhpp.foodpenguin.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.food_info.food_info_Fragment;

public class CartFragment extends Fragment  {

    private CartViewModel cartViewModel;
    TextView date;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container,@NonNull Bundle savedInstanceState)
    {
        cartViewModel = ViewModelProviders.of(this).get(CartViewModel.class);
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        Calendar c = Calendar.getInstance();

        c.add(c.MINUTE, 30);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
        String formattedDate = df.format(c.getTime());


        date = view.findViewById(R.id.pick_up_time);
        date.setText(formattedDate);


        return view;
    }

    public void back(){

    }


}