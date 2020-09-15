package com.xhpp.foodpenguin.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.checkout.checkout_Fragment;
import com.xhpp.foodpenguin.ui.main.MainFragment;

public class CartFragment extends Fragment  implements View.OnClickListener{

    private CartViewModel cartViewModel;
    TextView date;
    ImageButton back;
    Button checkout;
    CheckBox checkBox;
    TextView pName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container,@NonNull Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        Calendar c = Calendar.getInstance();

        c.add(c.MINUTE, 30);
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
        String formattedDate = df.format(c.getTime());

        String prodName = getArguments().getString("prodName");


        date = view.findViewById(R.id.pick_up_time);
        date.setText(formattedDate);

        back = view.findViewById(R.id.back);
        checkout = view.findViewById(R.id.checkout_button);
        checkBox = view.findViewById(R.id.tac_agree);
        pName = view.findViewById(R.id.product_name);
        pName.setText(prodName);


        back.setOnClickListener(this);
        checkout.setOnClickListener(this);


        return view;
    }


    public void onClick(View view){
        switch(view.getId()){
            case R.id.back:
                MainFragment mainFragment = new MainFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(((ViewGroup)getView().getParent()).getId(), mainFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                break;

            case R.id.checkout_button:
                if(checkBox.isChecked())
                {
                    checkout_Fragment checkout_fragment = new checkout_Fragment();
                    FragmentManager fragmentManager2 = getFragmentManager();
                    FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                    fragmentTransaction2.replace(((ViewGroup)getView().getParent()).getId(), checkout_fragment);
                    fragmentTransaction2.addToBackStack(null);
                    fragmentTransaction2.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Please agree to the TAC", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


}