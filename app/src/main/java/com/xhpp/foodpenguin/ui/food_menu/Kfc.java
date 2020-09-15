package com.xhpp.foodpenguin.ui.food_menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.cart.CartFragment;
import com.xhpp.foodpenguin.ui.checkout.checkout_Fragment;
import com.xhpp.foodpenguin.ui.food_info.KFC1;
import com.xhpp.foodpenguin.ui.food_info.KFC2;
import com.xhpp.foodpenguin.ui.food_info.KFC3;
import com.xhpp.foodpenguin.ui.food_info.MCD1;
import com.xhpp.foodpenguin.ui.food_info.MCD2;
import com.xhpp.foodpenguin.ui.food_info.MCD3;

public class Kfc extends Fragment implements View.OnClickListener{
    ImageButton kfc1;
    ImageButton kfc2;
    ImageButton kfc3;
    TextView k1;
    TextView k2;
    TextView k3;


    public Kfc() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kfc, container, false);

        kfc1 = view.findViewById(R.id.kfc1);
        kfc2 = view.findViewById(R.id.kfc2);
        kfc3 = view.findViewById(R.id.kfc3);
        k1 = view.findViewById(R.id.textView1);
        k2 = view.findViewById(R.id.textView3);
        k3 = view.findViewById(R.id.textView5);

        kfc1.setOnClickListener(this);
        kfc2.setOnClickListener(this);
        kfc3.setOnClickListener(this);

        return view;
    }

    public void onClick(View view){
        switch(view.getId())
        {
            case R.id.kfc1:


                KFC1 kfc1= new KFC1();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), kfc1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case R.id.kfc2:


                KFC2 kfc2= new KFC2();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(((ViewGroup)getView().getParent()).getId(), kfc2);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
                break;

            case R.id.kfc3:


                KFC3 kfc3= new KFC3();
                FragmentManager fragmentManager3 = getFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                fragmentTransaction3.replace(((ViewGroup)getView().getParent()).getId(), kfc3);
                fragmentTransaction3.addToBackStack(null);
                fragmentTransaction3.commit();
                break;
        }
    }
}