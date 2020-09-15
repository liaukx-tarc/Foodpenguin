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
import com.xhpp.foodpenguin.ui.food_info.MCD1;
import com.xhpp.foodpenguin.ui.food_info.MCD2;
import com.xhpp.foodpenguin.ui.food_info.MCD3;


public class Mcd extends Fragment implements View.OnClickListener{

    ImageButton mcd1;
    ImageButton mcd2;
    ImageButton mcd3;
    TextView m1;
    TextView m2;
    TextView m3;

    public Mcd() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.mcd, container, false);

        mcd1 = view.findViewById(R.id.mcd1);
        mcd2 = view.findViewById(R.id.mcd2);
        mcd3 = view.findViewById(R.id.mcd3);
        m1 = view.findViewById(R.id.textView1);
        m2 = view.findViewById(R.id.textView3);
        m3 = view.findViewById(R.id.textView5);

        mcd1.setOnClickListener(this);
        mcd2.setOnClickListener(this);
        mcd3.setOnClickListener(this);

        return view;
    }

    public void onClick(View view){
        switch(view.getId())
        {
            case R.id.mcd1:

                MCD1 mcd1= new MCD1();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), mcd1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case R.id.mcd2:


                MCD2 mcd2= new MCD2();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(((ViewGroup)getView().getParent()).getId(), mcd2);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
                break;

            case R.id.mcd3:


                MCD3 mcd3= new MCD3();
                FragmentManager fragmentManager3 = getFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                fragmentTransaction3.replace(((ViewGroup)getView().getParent()).getId(), mcd3);
                fragmentTransaction3.addToBackStack(null);
                fragmentTransaction3.commit();
                break;
        }
    }
}