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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.Order;
import com.xhpp.foodpenguin.ui.account.AccountViewModel;
import com.xhpp.foodpenguin.ui.cart.CartFragment;
import com.xhpp.foodpenguin.ui.order.OrderAdapter;
import com.xhpp.foodpenguin.ui.order.OrderFragment;

public class checkout_Fragment extends Fragment implements View.OnClickListener{

    ImageButton back;
    Button confirm;
    RadioGroup checkout;

    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout_fragment, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        back = view.findViewById(R.id.back);
        confirm = view.findViewById(R.id.confirm_button);
        checkout = view.findViewById(R.id.payment_method);

        back.setOnClickListener(this);
        confirm.setOnClickListener(this);

        return view;
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.back:
                CartFragment cartFragment = new CartFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), cartFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;
            case R.id.confirm_button:
                if(checkout.getCheckedRadioButtonId() == -1)
                {
                    Toast.makeText(getActivity(),"Please Select a Payment Method", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    OrderFragment orderFragment = new OrderFragment();
                    FragmentManager fragmentManager2 = getFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                    fragmentTransaction2.replace(((ViewGroup)getView().getParent()).getId(), orderFragment);
                    fragmentTransaction2.addToBackStack(null);
                    fragmentTransaction2.commit();
                }
                break;
        }

    }



}