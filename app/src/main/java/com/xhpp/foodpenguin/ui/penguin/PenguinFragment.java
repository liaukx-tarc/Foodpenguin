package com.xhpp.foodpenguin.ui.penguin;

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

public class PenguinFragment extends Fragment {

    private PenguinViewModel penguinViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        penguinViewModel = ViewModelProviders.of(this).get(PenguinViewModel.class);
        View view = inflater.inflate(R.layout.fragment_penguin, container, false);
        final TextView penguin = view.findViewById(R.id.text_penguin);
        penguinViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                penguin.setText(s);
            }
        });
        return view;
    }
}