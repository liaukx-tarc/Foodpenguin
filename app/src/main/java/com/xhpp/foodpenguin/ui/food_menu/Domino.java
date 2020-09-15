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
import com.xhpp.foodpenguin.ui.food_info.Domino1;
import com.xhpp.foodpenguin.ui.food_info.Domino2;
import com.xhpp.foodpenguin.ui.food_info.Domino3;
import com.xhpp.foodpenguin.ui.food_info.KFC1;
import com.xhpp.foodpenguin.ui.food_info.KFC2;
import com.xhpp.foodpenguin.ui.food_info.KFC3;


public class Domino extends Fragment implements View.OnClickListener{
    ImageButton domino1;
    ImageButton domino2;
    ImageButton domino3;
    TextView d1;
    TextView d2;
    TextView d3;

    public Domino() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_domino, container, false);

        domino1 = view.findViewById(R.id.domino1);
        domino2 = view.findViewById(R.id.domino2);
        domino3 = view.findViewById(R.id.domino3);
        d1 = view.findViewById(R.id.textView1);
        d2 = view.findViewById(R.id.textView3);
        d3 = view.findViewById(R.id.textView5);

        domino1.setOnClickListener(this);
        domino2.setOnClickListener(this);
        domino3.setOnClickListener(this);

        return view;
    }

    public void onClick(View view){
        switch(view.getId())
        {
            case R.id.domino1:


                Domino1 domino1= new Domino1();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), domino1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case R.id.domino2:


                Domino2 domino2= new Domino2();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(((ViewGroup)getView().getParent()).getId(), domino2);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
                break;

            case R.id.domino3:


                Domino3 domino3= new Domino3();
                FragmentManager fragmentManager3 = getFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                fragmentTransaction3.replace(((ViewGroup)getView().getParent()).getId(), domino3);
                fragmentTransaction3.addToBackStack(null);
                fragmentTransaction3.commit();
                break;
        }
    }
}