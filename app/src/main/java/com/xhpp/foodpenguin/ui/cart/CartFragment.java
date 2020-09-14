package com.xhpp.foodpenguin.ui.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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
import com.xhpp.foodpenguin.ui.checkout.checkout_fragment;

public class CartFragment extends Fragment  implements View.OnClickListener{

    private CartViewModel cartViewModel;
    TextView date;
    ImageButton back;
    Button checkout;

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

        back = view.findViewById(R.id.back);
        checkout = view.findViewById(R.id.checkout_button);

        back.setOnClickListener(this);
        checkout.setOnClickListener(this);


        return view;
    }


    public void onClick(View view){
        switch(view.getId()){
            case R.id.back:
                food_info_Fragment food_info_fragment = new food_info_Fragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), food_info_fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case R.id.checkout_button:
                checkout_fragment checkout_fragment = new checkout_fragment();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(((ViewGroup)getView().getParent()).getId(), checkout_fragment);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
                break;
        }
    }



}