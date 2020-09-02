package com.xhpp.foodpenguin.ui.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.xhpp.foodpenguin.R;

public class AccountFragment extends Fragment{

    private AccountViewModel accountViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container,@NonNull Bundle savedInstanceState)
    {
         accountViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        View view = inflater.inflate(R.layout.fragment_account,container,false);

        final TextView account = view.findViewById(R.id.text_account);
        accountViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                account .setText(s);
            }
        });
        return view;
    }


}

