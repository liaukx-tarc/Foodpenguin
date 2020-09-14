package com.xhpp.foodpenguin.ui.checkout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.account.AccountViewModel;
import com.xhpp.foodpenguin.ui.cart.CartFragment;

public class checkout_fragment extends Fragment implements View.OnClickListener{

    ImageButton back;

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout_fragment, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        back = view.findViewById(R.id.back);

        back.setOnClickListener(this);

        return view;
    }

    public void onClick(View view){
        CartFragment cartFragment = new CartFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), cartFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



}