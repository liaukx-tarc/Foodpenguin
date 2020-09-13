package com.xhpp.foodpenguin.ui.account;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.xhpp.foodpenguin.R;

public class AccountFragment extends Fragment{

    private AccountViewModel accountViewModel;

    FirebaseFirestore db;
    FirebaseAuth fAuth;

    ImageButton editButton;
    ImageButton cancelButton;
    ImageButton saveButton;
    Button orderButton;
    Button logoutButton;

    TextView usernameText;
    TextView emailText;
    TextInputLayout fnameText;
    TextInputLayout phoneText;
    TextInputLayout addressText;

    String username;
    String email;
    String fname;
    String phoneNum;
    String address;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container,@NonNull Bundle savedInstanceState)
    {
         accountViewModel = ViewModelProviders.of(this).get(AccountViewModel.class);
        View view = inflater.inflate(R.layout.fragment_account,container,false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        editButton = view.findViewById(R.id.edit);
        cancelButton = view.findViewById(R.id.cancel);
        saveButton = view.findViewById(R.id.save);
        orderButton = view.findViewById(R.id.my_order);
        logoutButton = view.findViewById(R.id.logout);

        editButton.setOnClickListener(pListener);
        cancelButton.setOnClickListener(pListener);
        saveButton.setOnClickListener(pListener);
        orderButton.setOnClickListener(pListener);
        logoutButton.setOnClickListener(pListener);

        usernameText = view.findViewById(R.id.username);
        emailText = view.findViewById(R.id.email);
        fnameText = view.findViewById(R.id.full_name);
        phoneText = view.findViewById(R.id.phone_number);
        addressText = view.findViewById(R.id.address);

        Bundle bundle = this.getArguments();

        if (fAuth.getCurrentUser() != null)
        {
            setData();
        }
        return view;
    }

    private void setData()
    {
        String UserId = fAuth.getCurrentUser().getUid();
        DocumentReference documentReference = db.collection("users").document(UserId);
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful())
                {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists())
                    {
                        username = document.getString("username");
                        email = document.getString("email");
                        fname = document.getString("fname");
                        phoneNum = document.getString("phone");
                        address = document.getString("address");

                        usernameText.setText(username);
                        emailText.setText(email);
                        fnameText.getEditText().setText(fname);
                        phoneText.getEditText().setText(phoneNum);
                        addressText.getEditText().setText(address);

                    }
                }
            }
        });
    }

    public boolean phoneCheck(String phoneNum)
    {
        String phonePattern = "^(\\d{3,4}[- .]?)(\\d{3}[- .]?)\\d{4}$";
        if(TextUtils.isEmpty(phoneNum))   //check empty phone
        {
            phoneText.setError("Can't Empty");
            return false;
        }

        else if(!phoneNum.matches(phonePattern))
        {
            phoneText.setError("Invalid Phone");
            return false;
        }

        else
        {
            return true;
        }
    }

    private final View.OnClickListener pListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.edit:
                    editButton.setVisibility(View.GONE);
                    cancelButton.setVisibility(View.VISIBLE);
                    saveButton.setVisibility(View.VISIBLE);
                    fnameText.setEnabled(true);
                    phoneText.setEnabled(true);
                    addressText.setEnabled(true);
                    break;
                case R.id.cancel:
                    editButton.setVisibility(View.VISIBLE);
                    cancelButton.setVisibility(View.GONE);
                    saveButton.setVisibility(View.GONE);
                    fnameText.setEnabled(false);
                    phoneText.setEnabled(false);
                    addressText.setEnabled(false);
                    break;
                case R.id.save:
                    editButton.setVisibility(View.VISIBLE);
                    cancelButton.setVisibility(View.GONE);
                    saveButton.setVisibility(View.GONE);
                    fnameText.setEnabled(false);
                    phoneText.setEnabled(false);
                    addressText.setEnabled(false);
                    break;
                case R.id.my_order:
                    // do stuff
                    break;
                case R.id.logout:
                    // do stuff
                    break;
            }
        }
    };
}

