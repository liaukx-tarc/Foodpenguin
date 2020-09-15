package com.xhpp.foodpenguin.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.food_menu.Kfc;
import com.xhpp.foodpenguin.ui.food_menu.Mcd;
import com.xhpp.foodpenguin.ui.food_menu.Domino;

public class MainFragment extends Fragment implements View.OnClickListener
{
    ImageButton mcd;
    ImageButton kfc;
    ImageButton domino;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        mcd = view.findViewById(R.id.mcdButton);
        kfc = view.findViewById(R.id.kfcButton);
        domino = view.findViewById(R.id.dominoButton);
        kfc.setOnClickListener(this);
        mcd.setOnClickListener(this);
        domino.setOnClickListener(this);

        return view;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.kfcButton:
                Kfc kfc = new Kfc();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), kfc);
                fragmentTransaction.commit();
                break;

            case R.id.mcdButton:
                Mcd mcd = new Mcd();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(((ViewGroup)getView().getParent()).getId(), mcd);
                fragmentTransaction2.commit();
                break;

            case R.id.dominoButton:
                Domino domino = new Domino();
                FragmentManager fragmentManager3= getFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                fragmentTransaction3.replace(((ViewGroup)getView().getParent()).getId(), domino);
                fragmentTransaction3.commit();
                break;
        }
    }

}


