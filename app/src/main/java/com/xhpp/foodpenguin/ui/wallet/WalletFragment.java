package com.xhpp.foodpenguin.ui.wallet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.xhpp.foodpenguin.R;

public class WalletFragment extends Fragment {

    private WalletViewModel walletViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container,@NonNull Bundle savedInstanceState)
    {
        walletViewModel = ViewModelProviders.of(this).get(WalletViewModel.class);
        View view = inflater.inflate(R.layout.fragment_wallet,container,false);

        final TextView wallet = view.findViewById(R.id.text_wallet);
        walletViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                wallet.setText(s);
            }
        });
        return view;
    }


}
