package com.xhpp.foodpenguin.ui.food_info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.cart.CartFragment;

public class food_info_Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    ImageButton back;
    Button cart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState){




        View view = inflater.inflate(R.layout.fragment_food_info_,container,false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        Spinner spinner = (Spinner) view.findViewById(R.id.ifNotAvailableSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.ifNotAvailable_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        back = view.findViewById(R.id.back);
        cart = view.findViewById(R.id.addCart);

        back.setOnClickListener(this);
        cart.setOnClickListener(this);

        return view;
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.back:

                break;

            case R.id.addCart:
                CartFragment cartFragment = new CartFragment();
                FragmentManager fragmentManager2 = getFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                fragmentTransaction2.replace(((ViewGroup)getView().getParent()).getId(), cartFragment);
                fragmentTransaction2.addToBackStack(null);
                fragmentTransaction2.commit();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}