package com.xhpp.foodpenguin.ui.wallet;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.firestore.Transaction;
import com.xhpp.foodpenguin.R;
import com.xhpp.foodpenguin.ui.account.AccountFragment;

import java.util.HashMap;
import java.util.Map;

public class WalletFragment extends Fragment {

    private WalletViewModel walletViewModel;
    FirebaseFirestore db;
    FirebaseAuth fAuth;
    TextInputLayout walletAmount;
    Button topUpButton;
    RadioGroup radioGroup;
    TextView walletCurrentAmount;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@NonNull ViewGroup container,@NonNull Bundle savedInstanceState)
    {
        walletViewModel = ViewModelProviders.of(this).get(WalletViewModel.class);
        View view = inflater.inflate(R.layout.fragment_wallet,container,false);
        fAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        walletAmount = view.findViewById(R.id.topup_value);
        topUpButton = view.findViewById(R.id.topup_button);
        topUpButton.setOnClickListener(walletListener);
        radioGroup = view.findViewById(R.id.wallet_topup);
        walletCurrentAmount = view.findViewById(R.id.wallet_amount);
        getData();


        return view;
    }

    private void getData() {
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
                        Double walletAmountDB = document.getDouble("walletAmount");
                        walletCurrentAmount.setText(String.format("%.2f", walletAmountDB));
                    }
                }
            }
        });
    }

    private void setData()
    {
        String amountString = String.valueOf(walletAmount.getEditText().getText());

        if(TextUtils.isEmpty(amountString))
        {
            walletAmount.setError("Amount Cannot be Blank");
        }
        else if(radioGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getActivity(),"Please Select a Payment Method", Toast.LENGTH_SHORT).show();
        }
        else
        {
            walletAmount.setError(null);
            walletAmount.getEditText().setText(null);
            final Double amount =Double.parseDouble(amountString);
            String UserId = fAuth.getCurrentUser().getUid();
            final DocumentReference documentReference = db.collection("users").document(UserId);

            db.runTransaction(new Transaction.Function<Void>() {
                @Override
                public Void apply(Transaction transaction) throws FirebaseFirestoreException {
                    DocumentSnapshot snapshot = transaction.get(documentReference);

                    double newAmount = snapshot.getDouble("walletAmount") + amount;
                    transaction.update(documentReference, "walletAmount", newAmount);
                    return null;
                }
            });
            getData();
            Toast.makeText(getActivity(),"Top up Successfully", Toast.LENGTH_SHORT).show();
        }
    }


    private View.OnClickListener walletListener = new View.OnClickListener() {
        public void onClick(View v) {
            setData();
        }
    };
}
